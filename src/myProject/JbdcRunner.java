package myProject;

import org.postgresql.Driver;
import myProject.util.ConnectionManager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JbdcRunner {

    public static void main(String[] args) throws SQLException {
        Class<Driver> driverClass = Driver.class;
        String sql = """
                INSERT INTO info (data)
                Values 
                ('newValue') 
                """;
        try (var connection = ConnectionManager.get();
             var statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE)) {
            System.out.println(connection.getTransactionIsolation());

            var executeResult = statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
            var generatedKeys = statement.getGeneratedKeys();
            if (generatedKeys.next()) {
                var generatedId = generatedKeys.getInt(1);
                System.out.println(generatedId);
            }
        }
    }
}
