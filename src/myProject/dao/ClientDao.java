package myProject.dao;

import myProject.dto.ClientFilter;
import myProject.entity.BankAccountEntity;
import myProject.entity.ClientEntity;
import myProject.exception.DaoException;
import myProject.util.ConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.*;

public class ClientDao implements Dao<Integer, ClientEntity> {
    private ClientDao() {
    }

    private static final ClientDao INSTANCE = new ClientDao();
    private static final String CLIENT_ID = "client_id";
    private static final String FIRST_NAME = "first_name";
    private static final String LAST_NAME = "last_name";
    private static final String BANK_ACCOUNT = "bank_account";
    private static final String CREATED_TIME = "created_time";
    private static final String BANK_ACCOUNT_ID = "bankAccountId";
    private static final String BANK_ACCOUNT_BALANCE = "bank_account_balance";


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
             SELECT  c.client_id, 
                    first_name, 
                    last_name,
                    account_id, 
                    c.created_time,
                    b.bank_account_balance, 
                    b.created_time
                    FROM client c 
                    JOIN bank_account b 
                    ON c.account_id = b.bank_account_id
            """;

    private static final String FIND_BY_ID = FIND_ALL_ID + """
            WHERE c.account_id = ?
            """;

    private final BankAccountDao bankAccountDao = BankAccountDao.getInstance();

    public List<ClientEntity> findAll(ClientFilter filter) {
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
            List<ClientEntity> clientEntities = new ArrayList<>();
            while (resultSet.next()) {
                clientEntities.add(buildClient(resultSet));
            }
            return clientEntities;
        } catch (SQLException throwables) {
            throw new DaoException(throwables);
        }
    }

    public List<ClientEntity> findAll() {
        try (var connection = ConnectionManager.get();
             var prepareStatement = connection.prepareStatement(FIND_ALL_ID)) {
            var resultSet = prepareStatement.executeQuery();
            List<ClientEntity> clientEntities = new ArrayList<>();
            while (resultSet.next()) {
                clientEntities.add(buildClient(resultSet));
            }
            return clientEntities;
        } catch (SQLException throwables) {
            throw new DaoException(throwables);
        }
    }


    public Optional<ClientEntity> findById(Integer id) {
        try (var connection = ConnectionManager.get();
             var prepareStatement = connection.prepareStatement(FIND_BY_ID)) {

            prepareStatement.setInt(1, id);
            var resultSet = prepareStatement.executeQuery();
            ClientEntity clientEntity = null;

            if (resultSet.next()) {
                clientEntity = buildClient(resultSet);
            }
            return Optional.ofNullable(clientEntity);

        } catch (SQLException throwables) {
            throw new DaoException(throwables);
        }
    }

    private ClientEntity buildClient(ResultSet resultSet) throws SQLException {
        var bankAccount = new BankAccountEntity(
                resultSet.getInt(BANK_ACCOUNT_ID),
                resultSet.getBigDecimal(BANK_ACCOUNT_BALANCE),
                resultSet.getTimestamp(CREATED_TIME).toLocalDateTime());

        return new ClientEntity(
                resultSet.getInt(CLIENT_ID),
                resultSet.getString(FIRST_NAME),
                resultSet.getString(LAST_NAME),
                bankAccountDao.findById(resultSet.getInt(BANK_ACCOUNT_ID),
                        resultSet.getStatement().getConnection()).orElse(null),
                resultSet.getTimestamp(CREATED_TIME).toLocalDateTime());
    }

    public void update(ClientEntity clientEntity) {
        try (var connection = ConnectionManager.get();
             var prepareStatement = connection.prepareStatement(UPDATE_SQL)) {
            prepareStatement.setString(1, clientEntity.getFirstName());
            prepareStatement.setString(2, clientEntity.getLastName());
            prepareStatement.setInt(3, clientEntity.getBankAccount().getBankAccountId());
            prepareStatement.setTimestamp(4, Timestamp.valueOf(clientEntity.getCreatedTime()));
            prepareStatement.setInt(5, clientEntity.getClientId());
            prepareStatement.executeUpdate();

        } catch (SQLException throwables) {
            throw new DaoException(throwables);
        }

    }

    public ClientEntity save(ClientEntity clientEntity) {
        try (var connection = ConnectionManager.get();
             var prepareStatement = connection.prepareStatement(SAVE_SQL, Statement.RETURN_GENERATED_KEYS)) {
            prepareStatement.setInt(1, clientEntity.getClientId());
            prepareStatement.setString(2, clientEntity.getFirstName());
            prepareStatement.setString(3, clientEntity.getLastName());
            prepareStatement.setInt(4, clientEntity.getBankAccount().getBankAccountId());
            prepareStatement.setTimestamp(5, Timestamp.valueOf(clientEntity.getCreatedTime()));
            prepareStatement.executeUpdate();
            var generatedKeys = prepareStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                clientEntity.setClientId(generatedKeys.getInt(CLIENT_ID));
            }
            return clientEntity;
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

