package hotel_manage;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionSetUp {

    static Connection connection;

    private static final String USER = "root";
    private static final String PASSWORD = "3254";

    private static final String DB_URL = "jdbc:mysql://localhost/res";
    
    public static Connection setConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);

            if(connection.isClosed()) {
                System.out.println("Connection Closed");
            } else 
            System.out.println("Connection is now open to use ........");

        } catch (Exception e) {
            System.out.println("Something went Wrong");
        } 

        return connection;
        
    }
}
