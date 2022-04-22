package food_mania;

import java.sql.Connection;

public class LogIn {
    public static void logIn(Connection connection) {
        try {
            if(connection.isClosed()) {
                System.out.println("Connection closed in LogIn.java");
            } else {
                String Query = "SELECT * FROM ";
            }
        } catch (Exception e) {
            //TODO: handle exception
            System.out.println("Something went wrong in LogIn.Java class");
        }
    }
}
