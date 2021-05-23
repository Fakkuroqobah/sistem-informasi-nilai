package Backend;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet;

public class Db {
    private static final String DB_NAME = "si_nilai";
    private static final String DB_USER = "root";
    private static final String DB_PASS = "";
    
    private static Connection conn() throws SQLException {
        Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/" + DB_NAME, 
                DB_USER, DB_PASS);
        
        return conn;
    }
    
    public static int runUpdate(String sql) throws SQLException {
        return conn().createStatement().executeUpdate(sql);
    }
    
    public static ResultSet runQuery(String sql) throws SQLException {
        return conn().createStatement().executeQuery(sql);
    }
}
