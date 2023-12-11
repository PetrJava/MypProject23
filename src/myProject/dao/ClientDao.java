package myProject.dao;

import myProject.dto.BankAccount;
import myProject.dto.ClientFilter;
import myProject.entity.Client;
import myProject.exception.DaoException;
import myProject.util.ConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.*;

public class ClientDao implements Dao<Integer, Client> {
    private ClientDao() {
    }

    private static final ClientDao INSTANCE = new ClientDao();
    private static final String DELETE_SQL = """
            DELETE FROM client
            WHERE client_id = ?
            """;
    private static final String SAVE_SQL = """
            INSERT INTO client (client_id, first_name, last_name, bank_account, created_time) 
            VALUES (?, ?, ?, ?, ?);
            """;
    private static final String UPDATE_SQL = """
            UPDATE client
            SET 
            first_name = ?,
            last_name = ?,
            bank_account = ?,
            created_time = ?
            WHERE client_id = ?
            """;
    private static final String FIND_ALL_ID = """
             SELECT  client_id, 
                    first_name, 
                    last_name,
                    bank_account, 
                    created_time
                    FROM client
            """;

    private static final String FIND_BY_ID = FIND_ALL_ID + """
            WHERE client_id = ?
            """;

    private final BankAccountDao bankAccountDao = BankAccountDao.getInstance();

    public List<Client> findAll(ClientFilter filter) {
        List<Object> parameters = new ArrayList<>();
        List<String> whereSql = new ArrayList<>();
        if (filter.last_name() != null) {
            whereSql.add("last_name LIKE ?");
            parameters.add("%" + filter.last_name() + "%");
        }
        parameters.add(filter.limit());
        parameters.add(filter.offset());

        var where = whereSql.stream()
                .collect(joining(" AND ", " WHERE ", " LIMIT ? OFFSET ? "));
        var sql = FIND_ALL_ID + where;

        try (var connection = ConnectionManager.get();
             var prepareStatement = connection.prepareStatement(sql)) {
            for (int i = 0; i < parameters.size(); i++) {
                prepareStatement.setObject(i + 1, parameters.get(i));
            }

            var resultSet = prepareStatement.executeQuery();
            List<Client> clients = new ArrayList<>();
            while (resultSet.next()) {
                clients.add(buildClient(resultSet));
            }
            return clients;
        } catch (SQLException throwables) {
            throw new DaoException(throwables);
        }
    }

    public List<Client> findAll() {
        try (var connection = ConnectionManager.get();
             var prepareStatement = connection.prepareStatement(FIND_ALL_ID)) {
            var resultSet = prepareStatement.executeQuery();
            List<Client> clients = new ArrayList<>();
            while (resultSet.next()) {
                clients.add(buildClient(resultSet));
            }
            return clients;
        } catch (SQLException throwables) {
            throw new DaoException(throwables);
        }
    }


    public Optional<Client> findById(Integer id) {
        try (var connection = ConnectionManager.get();
             var prepareStatement = connection.prepareStatement(FIND_BY_ID)) {

            prepareStatement.setInt(1, id);
            var resultSet = prepareStatement.executeQuery();
            Client client = null;

            if (resultSet.next()) {
                client = buildClient(resultSet);
            }
            return Optional.ofNullable(client);

        } catch (SQLException throwables) {
            throw new DaoException(throwables);
        }
    }

    private Client buildClient(ResultSet resultSet) throws SQLException {
        var bankAccount = new BankAccount(
                resultSet.getInt("bank_account_id"),
                resultSet.getBigDecimal("bank_account_balance"),
                resultSet.getTimestamp("created_time").toLocalDateTime());

        return new Client(
                resultSet.getInt("client_id"),
                resultSet.getString("First_name"),
                resultSet.getString("Last_name"),
                bankAccountDao.findById(resultSet.getInt("bank_account_id"),
                        resultSet.getStatement().getConnection()).orElse(null),
                resultSet.getTimestamp("created_time").toLocalDateTime());
    }

    public void update(Client client) {
        try (var connection = ConnectionManager.get();
             var prepareStatement = connection.prepareStatement(UPDATE_SQL)) {
            prepareStatement.setString(1, client.getFirst_name());
            prepareStatement.setString(2, client.getLast_name());
            prepareStatement.setInt(3, client.getBank_account().bank_account_id());
            prepareStatement.setTimestamp(4, Timestamp.valueOf(client.getCreated_time()));
            prepareStatement.setInt(5, client.getClient_id());
            prepareStatement.executeUpdate();

        } catch (SQLException throwables) {
            throw new DaoException(throwables);
        }

    }

    public Client save(Client client) {
        try (var connection = ConnectionManager.get();
             var prepareStatement = connection.prepareStatement(SAVE_SQL, Statement.RETURN_GENERATED_KEYS)) {
            prepareStatement.setInt(1, client.getClient_id());
            prepareStatement.setString(2, client.getFirst_name());
            prepareStatement.setString(3, client.getLast_name());
            prepareStatement.setInt(4, client.getBank_account().bank_account_id());
            prepareStatement.setTimestamp(5, Timestamp.valueOf(client.getCreated_time()));
            prepareStatement.executeUpdate();
            var generatedKeys = prepareStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                client.setClient_id(generatedKeys.getInt("client_id"));
            }
            return client;
        } catch (SQLException throwables) {
            throw new DaoException(throwables);
        }
    }


    public boolean delete(Integer id) {
        try (var connection = ConnectionManager.get();
             var prepareStatement = connection.prepareStatement(DELETE_SQL)) {
            prepareStatement.setInt(1, id);
            return prepareStatement.executeUpdate() > 0;
        } catch (SQLException throwables) {
            throw new DaoException(throwables);
        }
    }

    public static ClientDao getInstance() {
        return INSTANCE;
    }
}

