package myProject.dao;

import myProject.entity.BankAccount;
import myProject.entity.Client;
import myProject.exception.DaoException;
import myProject.util.ConnectionManager;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

public class BankAccountDao implements Dao<Integer, BankAccount> {
    private BankAccountDao() {
    }

    private static final BankAccountDao INSTANCE = new BankAccountDao();

    public static BankAccountDao getInstance() {
        return INSTANCE;
    }

    private static final String DELETE_SQL = """
            DELETE FROM bank_account
            WHERE bank_account_id = ?
            """;
    private static final String SAVE_SQL = """
            INSERT INTO bank_account(bank_account_id, bank_account_balance, created_time)
            VALUES (?, ?, ?)  
            """;
    private static final String UPDATE_SQL = """
            UPDATE bank_account
            SET 
            bank_account_balance = ?,
            created_time = ?
            WHERE bank_account_id = ?
                                """;

    private static final String FIND_ALL_ID = """
             SELECT  bank_account_id, 
                    bank_account_balance, 
                    created_time
                    FROM bank_account
            """;

    private static final String FIND_BY_ID = FIND_ALL_ID + """
            WHERE bank_account_id = ?
            """;


    @Override
    public boolean delete(Integer id) {
        return false;
    }

    @Override
    public void update(BankAccount client) {

    }

    @Override
    public Client save(BankAccount client) {
        return null;
    }

    public Optional<BankAccount> findById(Integer id, Connection connection) {
        try (var prepareStatement = connection.prepareStatement(FIND_BY_ID)) {
            prepareStatement.setInt(1, id);

            var resultSet = prepareStatement.executeQuery();
            BankAccount bankAccount = null;
            if (resultSet.next()) {
                bankAccount = new BankAccount(resultSet.getInt("bank_account_id"),
                        resultSet.getBigDecimal("bank_account_balance"),
                        resultSet.getTimestamp("created_time").toLocalDateTime());
            }
            return Optional.ofNullable(bankAccount);
        } catch (SQLException throwables) {
            throw new DaoException(throwables);
        }
    }

    @Override
    public Optional<BankAccount> findById(Integer id) {
        try (var connection = ConnectionManager.get()) {
            return findById(id, connection);
        } catch (SQLException throwables) {
            throw new DaoException(throwables);
        }
    }

    @Override
    public List<BankAccount> findAll() {
        return null;
    }
}
