package myProject.dao;

import myProject.entity.BankAccountEntity;
import myProject.entity.ClientEntity;
import myProject.exception.DaoException;
import myProject.util.ConnectionManager;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class BankAccountDao implements Dao<Integer, BankAccountEntity> {

    public BankAccountDao() {
    }

    private static final BankAccountDao INSTANCE = new BankAccountDao();
    private static final String BANK_ACCOUNT_ID = "bankAccountId";
    private static final String BANK_ACCOUNT_BALANCE = "bank_account_balance";
    private static final String CREATED_TIME = "created_time";

    public static BankAccountDao getInstance() {
        return INSTANCE;
    }

    private static final String DELETE_SQL = """
            DELETE FROM bank_account
            WHERE bankAccountId = ?
            """;
    private static final String SAVE_SQL = """
            INSERT INTO bank_account(bankAccountId, bank_account_balance, created_time)
            VALUES (?, ?, ?)  
            """;
    private static final String UPDATE_SQL = """
            UPDATE bank_account
            SET 
            bank_account_balance = ?,
            created_time = ?
            WHERE bankAccountId = ?
                                """;

    private static final String FIND_ALL_ID = """
             SELECT  bankAccountId, 
                    bank_account_balance, 
                    created_time
                    FROM bank_account
            """;

    private static final String FIND_BY_ID = FIND_ALL_ID + """
            WHERE bankAccountId = ?
            """;


    @Override
    public boolean delete(Integer id) {
        return false;
    }

    @Override
    public void update(BankAccountEntity client) {

    }

    @Override
    public ClientEntity save(BankAccountEntity client) {
        return null;
    }

    public Optional<BankAccountEntity> findById(Integer id, Connection connection) {
        try (var prepareStatement = connection.prepareStatement(FIND_BY_ID)) {
            prepareStatement.setInt(1, id);

            var resultSet = prepareStatement.executeQuery();
//            BankAccount bankAccount = null;
//            if (resultSet.next()) {
//                bankAccount = new BankAccount(resultSet.getInt(BANK_ACCOUNT_ID),
//                        resultSet.getBigDecimal(BANK_ACCOUNT_BALANCE),
//                        resultSet.getTimestamp(CREATED_TIME).toLocalDateTime());
//            }
            BankAccountEntity bankAccountEntity = new BankAccountEntity();
            if (resultSet.next()) {
                bankAccountEntity.setBankAccountId(resultSet.getInt(BANK_ACCOUNT_ID));
                bankAccountEntity.setBankAccountBalance( resultSet.getBigDecimal(BANK_ACCOUNT_BALANCE));
                bankAccountEntity.setCreatedTime(resultSet.getTimestamp(CREATED_TIME).toLocalDateTime());
            }


            return Optional.ofNullable(bankAccountEntity);
        } catch (SQLException throwables) {
            throw new DaoException(throwables);
        }
    }

    @Override
    public Optional<BankAccountEntity> findById(Integer id) {
        try (var connection = ConnectionManager.get()) {
            return findById(id, connection);
        } catch (SQLException throwables) {
            throw new DaoException(throwables);
        }
    }

    @Override
    public List<BankAccountEntity> findAll() {
        return null;
    }
}
