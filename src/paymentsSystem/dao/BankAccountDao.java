package paymentsSystem.dao;

import paymentsSystem.entity.BankAccountEntity;
import paymentsSystem.exception.DaoException;
import paymentsSystem.util.ConnectionManager;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BankAccountDao implements Dao<Integer, BankAccountEntity> {

    private BankAccountDao() {
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

    private static final String FIND_ALL = """
             SELECT  bankAccountId, 
                    bank_account_balance, 
                    created_time
                    FROM bank_account
            """;

    private static final String FIND_BY_ID = FIND_ALL + """
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
    public List<BankAccountEntity> findAll() {
        try (var connection = ConnectionManager.get();
        var prepareStatement=  connection.prepareStatement(FIND_ALL)) {
            var resultSet = prepareStatement.executeQuery();
            List<BankAccountEntity> bankAccount = new ArrayList<>();
            while (resultSet.next()) {
                bankAccount.add(buildBankAccount(resultSet));
            }
            return bankAccount;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public BankAccountEntity save(BankAccountEntity client) {
        return null;
    }

    public Optional<BankAccountEntity> findById(Integer id, Connection connection) {
        try (var prepareStatement = connection.prepareStatement(FIND_BY_ID)) {
            prepareStatement.setInt(1, id);

            var resultSet = prepareStatement.executeQuery();

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


    private BankAccountEntity buildBankAccount(ResultSet resultSet) throws SQLException {
    return new BankAccountEntity(
            resultSet.getInt(BANK_ACCOUNT_ID),
            resultSet.getBigDecimal(BANK_ACCOUNT_BALANCE),
            resultSet.getTimestamp(CREATED_TIME).toLocalDateTime());
    }

}
