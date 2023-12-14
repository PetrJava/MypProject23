package paymentsSystem.dao;

public class UserProfileDao {
    public UserProfileDao() {
    }

    private static final UserProfileDao INSTANCE = new UserProfileDao();

    public static UserProfileDao getInstance() {
        return INSTANCE;
    }

    private static final String USER_ID = "user_id";
    private static final String LOGIN = "login";
    private static final String PASSWORD = "password";
    private static final String ROLE_ID = "role_id";
    private static final String STATUS = "status";
    private static final String CREATED_TIME = "created_time";

    private static final String DELETE_SQL = """
            DELETE FROM user_profile
            WHERE user_id = ?
            """;
    private static final String SAVE_SQL = """
            INSERT INTO user_profile(user_id, login, password, role_id, status, created_time)            
            VALUES (?, ?, ?, ?, ?, ?)  
            """;
    private static final String UPDATE_SQL = """
            UPDATE user_profile
            SET 
            login = ?,
            password = ?,
            role_id = ?,
            status = ?,
            created_time = ?
            WHERE user_id = ?
            """;

    private static final String FIND_ALL_ID = """
             SELECT 
            user_id,
            login, 
            password,
            role_id, 
            status,
            created_time
                    FROM user_profile
            """;

    private static final String FIND_BY_ID = FIND_ALL_ID + """
            WHERE user_profile = ?
            """;
}
