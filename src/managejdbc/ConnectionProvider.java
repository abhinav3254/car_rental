package managejdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionProvider {
    public static Connection connection;
    final static String url = "jdbc:mysql://localhost:3306/student_manage";
    final static String user = "root";
    final static String password = "3254";
    public static Connection createConnection() {
        try {

        // Load the Driver
            Class.forName("com.mysql.jdbc.Driver");

            // Create the connection

            connection = DriverManager.getConnection(url, user, password);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return connection;
    }
}
