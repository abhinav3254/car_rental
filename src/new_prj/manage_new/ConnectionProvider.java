package new_prj.manage_new;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionProvider {
    public static Connection connection;

    final static String url = "jdbc:mysql://localhost:3306/student_manage";
    final static String user = "root";
    final static String password = "3254";
    public static Connection createConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            connection = DriverManager.getConnection(url,user,password);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return connection;
    }
}
