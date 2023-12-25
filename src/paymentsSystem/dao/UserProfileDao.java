package paymentsSystem.dao;

import lombok.SneakyThrows;
import paymentsSystem.entity.Role;
import paymentsSystem.entity.UserProfileEntity;
import paymentsSystem.exception.DaoException;
import paymentsSystem.util.ConnectionManager;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
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
    private static final String EMAIL = "email";
    private static final String PASSWORD = "password";
    private static final String ROLE = "role";
    private static final String CREATED_TIME = "created_time";

    private static final String DELETE_SQL = """
            DELETE FROM user_profile
            WHERE user_id = ?
            """;
    private static final String SAVE_SQL = """
            INSERT INTO user_profile(login, email, password, role, created_time)            
            VALUES (?, ?, ?, ?, ?)  
            """;
    private static final String UPDATE_SQL = """
            UPDATE user_profile
            SET 
            login = ?,
            email = ?,
            password = ?,
            role = ?,
            created_time = ?
            WHERE user_id = ?
            """;

    private static final String FIND_ALL_SQL = """
             SELECT 
            user_id,
            login, 
            email,
            password,
            role, 
            created_time
                    FROM user_profile
            """;

    private static final String FIND_BY_ID_SQL = FIND_ALL_SQL + """
            WHERE user_profile = ?
            """;

    private static final String FIND_BY_EMAIL_AND_PASSWORD_SQL = """
            SELECT 
             user_id,
             login, 
             email,
             password,
             role, 
             created_time
                     FROM user_profile
                     WHERE email = ? AND password = ?;
             """;


    @Override
    public UserProfileEntity save(UserProfileEntity entity) {
        return builderEntity(entity, SAVE_SQL, "is not update!");
    }


    public UserProfileEntity builderEntity(UserProfileEntity entity, String sql, String ExceptionText) {
        try (var connection = ConnectionManager.get();
             var prepareStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            prepareStatement.setString(1, entity.getLogin());
            prepareStatement.setString(2, entity.getEmail());
            prepareStatement.setString(3, entity.getPassword());
            prepareStatement.setString(4, entity.getRole().name());
            prepareStatement.setDate(5, Date.valueOf(entity.getCreatedTime()));
            prepareStatement.executeUpdate();

            var generatedKeys = prepareStatement.getGeneratedKeys();
            generatedKeys.next();
            entity.setUserId(generatedKeys.getInt(USER_ID));


            return entity;
        } catch (SQLException throwables) {
            throw new DaoException("error in UserDao/builderEntity ", throwables);
        }
    }



    @SneakyThrows
    public Optional<UserProfileEntity> findByEmailAndPassword(String email, String password) {
        try (var connection = ConnectionManager.get();
             var prepareStatement = connection.prepareStatement(FIND_BY_EMAIL_AND_PASSWORD_SQL)) {
            prepareStatement.setString(1, email);
            prepareStatement.setString(2, password);

            var resultSet = prepareStatement.executeQuery();
            UserProfileEntity user = null;
            if (resultSet.next()) {
                user = builderToEntity(resultSet);
            }
            return Optional.ofNullable(user);
        }
    }

    private static UserProfileEntity builderToEntity(ResultSet resultSet) throws SQLException {
        return UserProfileEntity.builder()
                .userId(resultSet.getInt(USER_ID))
                .login(resultSet.getString(LOGIN))
                .email(resultSet.getString(EMAIL))
                .password(resultSet.getString(PASSWORD))
                .role(Role.valueOf(resultSet.getString(ROLE)))
                .createdTime(resultSet.getDate(CREATED_TIME).toLocalDate())
                .build();
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }

    @Override
    public boolean update(UserProfileEntity entity) {
        return false;
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
