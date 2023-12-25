package paymentsSystem.dao;

import paymentsSystem.entity.BankAccountEntity;
import paymentsSystem.entity.ClientEntity;
import paymentsSystem.entity.TypeOperationEntity;
import paymentsSystem.exception.DaoException;
import paymentsSystem.util.ConnectionManager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TypeOperationDao {
    public TypeOperationDao() {
    }

    private static final TypeOperationDao INSTANCE = new TypeOperationDao();

    public static TypeOperationDao getInstance() {
        return INSTANCE;
    }

    private static final String TYPE_OPERATION_ID = "type_operation_id";
    private static final String TYPE = "type";
    private static final String DELETE_SQL = """
            DELETE FROM type_operation
            WHERE type_operation_id = ?
            """;
    private static final String SAVE_SQL = """
            INSERT INTO type_operation(type_operation_id, type)
            VALUES (?, ?)  
            """;
    private static final String UPDATE_SQL = """
            UPDATE type_operation
            SET type = ?
            WHERE type_operation_id = ?
            """;

    private static final String FIND_ALL_SQL = """
             SELECT 
            type
            FROM type_operation
            """;

    private static final String FIND_BY_ID = FIND_ALL_SQL + """
            WHERE type_operation_id = ?
            """;

    public List<TypeOperationEntity> findAll() {
        try (var connection = ConnectionManager.get();
             var prepareStatement = connection.prepareStatement(FIND_ALL_SQL)) {
            var resultSet = prepareStatement.executeQuery();
            List<TypeOperationEntity> typeOperationEntity = new ArrayList<>();
            while (resultSet.next()) {
                typeOperationEntity.add(new TypeOperationEntity(
                        resultSet.getString(TYPE)));
            }
            return typeOperationEntity;
        } catch (SQLException throwables) {
            throw new DaoException("client is not finded", throwables);
        }
    }

}
