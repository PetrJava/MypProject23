package myProject.dao;

public class RoleDao {
    public RoleDao() {
    }

    private static final RoleDao INSTANCE = new RoleDao();

    public static RoleDao getInstance() {
        return INSTANCE;
    }

    private static final String ROLE_ID = "role_id";
    private static final String ROLE = "role";
    private static final String DELETE_SQL = """
            DELETE FROM role
            WHERE role_id = ?
            """;

    private static final String SAVE_SQL = """
            INSERT INTO role(role_id, role)
            VALUES (?, ?)  
            """;
    private static final String UPDATE_SQL = """
            UPDATE role
            SET role = ?
            WHERE role_id = ?
            """;

    private static final String FIND_ALL_ID = """
             SELECT 
            role_id,
            role
            FROM role
            """;

    private static final String FIND_BY_ID = FIND_ALL_ID + """
            WHERE role_id = ?
            """;


}
