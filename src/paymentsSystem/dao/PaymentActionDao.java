package paymentsSystem.dao;

import paymentsSystem.entity.PaymentActionEntity;

import java.util.List;
import java.util.Optional;

public class PaymentActionDao implements Dao<Integer, PaymentActionEntity> {
    public PaymentActionDao() {
    }
    private static final PaymentActionDao INSTANCE = new PaymentActionDao();

    public static PaymentActionDao getInstance() {
        return INSTANCE;
    }

    private static final String PAYMENT_ACTION_ID = "payment_action_id";
    private static final String DATE_AND_TIME = "date_and_time";
    private static final String TRANSACTION_AMOUNT = "transaction_amount";
    private static final String TRANSACTION_FROM = "transaction_from";
    private static final String TRANSACTION_TO = "transaction_to";
    private static final String PAYMENT_ACTION_NO = "payment_action_no";
    private static final String STATUS = "status";

    private static final String DELETE_SQL = """
            DELETE FROM payment_action
            WHERE payment_action_no = ?
            """;
    private static final String SAVE_SQL = """
            INSERT INTO payment_action(payment_action_id, date_and_time, transaction_amount, transaction_from, transaction_to, status, payment_action_no)
            VALUES (?, ?, ?, ?, ?, ?, ?)  
            """;
    private static final String UPDATE_SQL = """
            UPDATE payment_action
            SET 
            date_and_time = ?,
            transaction_amount = ?,
            transaction_from = ?,
            transaction_to = ?,
            status = ?
            WHERE payment_action_id = ?
                                """;

    private static final String FIND_ALL_SQL = """
             SELECT 
        
            date_and_time,
            transaction_amount,
            transaction_from,
            transaction_to,
            status,
            payment_action_no
                    FROM payment_action
            """;

    private static final String FIND_BY_ID_SQL = FIND_ALL_SQL + """
            WHERE payment_action_id = ?
            """;
    private static final String FIND_BY_NO_SQL = FIND_ALL_SQL + """
            WHERE payment_action_id = ?
            """;

    @Override
    public boolean delete(Integer id) {
        return false;
    }

    @Override
    public boolean update(PaymentActionEntity entity) {
        return false;
    }

    @Override
    public PaymentActionEntity save(PaymentActionEntity entity) {
        return null;
    }

    @Override
    public Optional<PaymentActionEntity> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public List<PaymentActionEntity> findAll() {
        return null;
    }
}
