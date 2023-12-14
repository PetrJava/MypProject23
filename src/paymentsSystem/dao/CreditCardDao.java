package paymentsSystem.dao;

public class CreditCardDao {
    public CreditCardDao() {
    }

    private static final CreditCardDao INSTANCE = new CreditCardDao();

    public static CreditCardDao getInstance() {
        return INSTANCE;
    }
    private static final String CARD_ID = "card_id";
    private static final String CARD_NO = "card_no";
    private static final String CREDIT_CARD_BALANCE = "credit_card_balance";
    private static final String CREATED_TIME = "created_time";
    private static final String EXPIRE_DATE = "expire_date";

    private static final String DELETE_SQL = """
            DELETE FROM credit_card
            WHERE card_id = ?
            """;
    private static final String SAVE_SQL = """
            INSERT INTO credit_card(card_id, card_no, credit_card_balance, created_time, expire_date)
            VALUES (?, ?, ?, ?, ?)  
            """;
    private static final String UPDATE_SQL = """
            UPDATE credit_card
            SET 
            card_no = ?,
            credit_card_balance = ?,
            created_time = ?,
            expire_date = ?
            WHERE card_id = ?
                                """;

    private static final String FIND_ALL_ID = """
             SELECT 
             card_id,
             card_no,
             credit_card_balance,
             created_time,
             expire_date 
                    FROM credit_card
            """;

    private static final String FIND_BY_ID = FIND_ALL_ID + """
            WHERE card_id = ?
            """;

}
