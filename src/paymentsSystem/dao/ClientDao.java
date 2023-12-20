package paymentsSystem.dao;

import paymentsSystem.entity.BankAccountEntity;
import paymentsSystem.entity.ClientEntity;
import paymentsSystem.exception.DaoException;
import paymentsSystem.util.ConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ClientDao implements Dao<Integer, ClientEntity> {
    private ClientDao() {
    }

    private static final String CLIENT_ID = "client_id";
    private static final String FIRST_NAME = "first_name";
    private static final String LAST_NAME = "last_name";
    private static final String CREATED_TIME = "created_time";
    private static final String BANK_ACCOUNT_ID = "bank_account_id";
    private static final String BANK_ACCOUNT_BALANCE = "bank_account_balance";

    private static final ClientDao INSTANCE = new ClientDao();

    public static ClientDao getInstance() {
        return INSTANCE;
    }

    private final BankAccountDao bankAccountDao = BankAccountDao.getInstance();

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
            account_id = ?,
            created_time = ?
            WHERE client_id = ?
            """;
    private static final String FIND_ALL = """
             SELECT  c.client_id, 
                    first_name, 
                    last_name,
                    account_id, 
                    c.created_time,
                    b.bank_account_id,
                    b.bank_account_balance, 
                    b.created_time
                    FROM client c 
                    JOIN bank_account b 
                    ON c.account_id = b.bank_account_id
            """;
    private static final String FIND_BY_ID = FIND_ALL + """
            WHERE account_id = ?
            """;


    public List<ClientEntity> findAll() {
        try (var connection = ConnectionManager.get();
             var prepareStatement = connection.prepareStatement(FIND_ALL)) {
            var resultSet = prepareStatement.executeQuery();
            List<ClientEntity> clientEntities = new ArrayList<>();
            while (resultSet.next()) {
                clientEntities.add(buildClient(resultSet));
            }
            return clientEntities;
        } catch (SQLException throwables) {
            throw new DaoException("client is not finded", throwables);
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
            throw new DaoException("client is not finded", throwables);
        }
    }

    private ClientEntity buildClient(ResultSet resultSet) throws SQLException {
        var bankAccountEntity = new BankAccountEntity(
                resultSet.getInt(BANK_ACCOUNT_ID),
                resultSet.getBigDecimal(BANK_ACCOUNT_BALANCE),
                resultSet.getTimestamp(CREATED_TIME).toLocalDateTime());

        return new ClientEntity(
                resultSet.getInt(CLIENT_ID),
                resultSet.getString(FIRST_NAME),
                resultSet.getString(LAST_NAME),
                bankAccountEntity,
                resultSet.getTimestamp(CREATED_TIME).toLocalDateTime());

    }


    public boolean update(ClientEntity clientEntity) {
        int result;
        try (var connection = ConnectionManager.get();
             var prepareStatement = connection.prepareStatement(UPDATE_SQL)) {
            prepareStatement.setString(1, clientEntity.getFirstName());
            prepareStatement.setString(2, clientEntity.getLastName());
            prepareStatement.setInt(3, clientEntity.getBankAccountEntity().getBankAccountId());
            prepareStatement.setTimestamp(4, Timestamp.valueOf(clientEntity.getCreatedTime()));
            prepareStatement.setInt(5, clientEntity.getClientId());
            result = prepareStatement.executeUpdate();

            return result > 0;

        } catch (SQLException exception) {
            throw new DaoException("client %s is not updated".formatted(clientEntity.getClientId()), exception);
        }
    }

    public ClientEntity save(ClientEntity clientEntity) {
        try (var connection = ConnectionManager.get();
             var prepareStatement = connection.prepareStatement(SAVE_SQL, Statement.RETURN_GENERATED_KEYS)) {
            prepareStatement.setInt(1, clientEntity.getClientId());
            prepareStatement.setString(2, clientEntity.getFirstName());
            prepareStatement.setString(3, clientEntity.getLastName());
            prepareStatement.setInt(4, clientEntity.getBankAccountEntity().getBankAccountId());
            prepareStatement.setTimestamp(5, Timestamp.valueOf(clientEntity.getCreatedTime()));
            prepareStatement.executeUpdate();
            var generatedKeys = prepareStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                clientEntity.setClientId(generatedKeys.getInt(CLIENT_ID));
            }
            return clientEntity;
        } catch (SQLException throwables) {
            throw new DaoException("client is not saved", throwables);
        }
    }

    public boolean delete(Integer id) {
        try (var connection = ConnectionManager.get();
             var prepareStatement = connection.prepareStatement(DELETE_SQL)) {
            prepareStatement.setInt(1, id);
            return prepareStatement.executeUpdate() > 0;
        } catch (SQLException throwables) {
            throw new DaoException("client is not deleted", throwables);
        }
    }
}

