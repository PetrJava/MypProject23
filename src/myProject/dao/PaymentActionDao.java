package myProject.dao;

public class PaymentActionDao {
    public PaymentActionDao() {
    }
    private static final PaymentActionDao INSTANCE = new PaymentActionDao();

    public static PaymentActionDao getInstance() {
        return INSTANCE;
    }

    private static final String DELETE_SQL = """
            DELETE FROM payment_action
            WHERE payment_action_id = ?
            """;
    private static final String SAVE_SQL = """
            INSERT INTO payment_action(payment_action_id, date_and_time, transaction_amount, transaction_from, transaction_to, status)
            VALUES (?, ?, ?, ?, ?, ?)  
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

    private static final String FIND_ALL_ID = """
             SELECT 
            payment_action_id,
            date_and_time,
            transaction_amount,
            transaction_from,
            transaction_to,
            status
                    FROM payment_action
            """;

    private static final String FIND_BY_ID = FIND_ALL_ID + """
            WHERE payment_action_id = ?
            """;
}
