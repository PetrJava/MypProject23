package paymentsSystem.dao;

import paymentsSystem.entity.CreditCardEntity;

import java.util.List;
import java.util.Optional;

public class CreditCardDao implements Dao<Integer, CreditCardEntity> {
    public CreditCardDao(){
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

    @Override
    public boolean delete(Integer id) {
        return false;
    }

    @Override
    public boolean update(CreditCardEntity entity) {
        return false;
    }

    @Override
    public CreditCardEntity save(CreditCardEntity entity) {
        return null;
    }

    @Override
    public Optional<CreditCardEntity> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public List<CreditCardEntity> findAll() {
        return null;
    }
}
