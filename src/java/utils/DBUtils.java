package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Trịnh Hoàng Dũng
 */
public class DBUtils {
    
    private static final String URL = "jdbc:sqlserver://localhost:1433;databaseName=BookstoreDB";
    private static final String USER = "sa";
    private static final String PASSWORD = "123456";

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Connection conn = null;
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        conn = DriverManager.getConnection(URL, USER, PASSWORD);
        return conn;
    }
}