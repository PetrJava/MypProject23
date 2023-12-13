package myProject.dao;

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

    private static final String FIND_ALL_ID = """
             SELECT 
            type_operation_id,
            type
            FROM type_operation
            """;

    private static final String FIND_BY_ID = FIND_ALL_ID + """
            WHERE type_operation_id = ?
            """;
}
