package paymentsSystem.dao;

import paymentsSystem.entity.UserProfileEntity;

import java.util.List;
import java.util.Optional;

public class UserProfileDao implements Dao<Integer, UserProfileEntity> {
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

    private static final String FIND_ALL_ID_SQL = """
             SELECT 
            user_id,
            login, 
            password,
            role_id, 
            status,
            created_time
                    FROM user_profile
            """;

    private static final String FIND_BY_ID_SQL = FIND_ALL_ID_SQL + """
            WHERE user_profile = ?
            """;


    @Override
    public boolean delete(Integer id) {
        return false;
    }

    @Override
    public boolean update(UserProfileEntity entity) {
        return false;
    }

    @Override
    public UserProfileEntity save(UserProfileEntity entity) {
        return null;
    }

    @Override
    public Optional<UserProfileEntity> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public List<UserProfileEntity> findAll() {
        return null;
    }
}
