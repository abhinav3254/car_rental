package food_mania;

import java.sql.Connection;
import java.sql.DriverManager;


public class CreateConnection {
    static Connection connection;

    private static final String USER = "root";
    private static final String PASSWORD = "3254";
    private static final String DB_URL = "jdbc:mysql://localhost/fm";

    public static Connection createConnection() {
        try {
        Class.forName("com.mysql.cj.jdbc.Driver");

        connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);

        if(connection.isClosed()) {
            System.out.println("Connection is closed in Create Connection Class");
        }   
        } catch (Exception e) {
            //TODO: handle exception
            System.out.println("Error Inside the CreateConnection Class");
        }

        return connection;
    }
}
