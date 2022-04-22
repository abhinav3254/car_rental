package food_mania;

import java.sql.*;

public class CreateTable {
    public static void createTableUser(Connection connection) {
        try {
            if(connection.isClosed()) {
                System.out.println("Connection Closed in CreateTable.java");
            } else {
                Statement statement = connection.createStatement();
                String query = "CREATE TABLE USERS("+
                "ID INT NOT NULL AUTO_INCREMENT,"+
                "UNAME VARCHAR(10) NOT NULL,"+
                "RNAME VARCHAR(20) NOT NULL,"+
                "LOCATION VARCHAR(20) NOT NULL,"+
                "PHONE VARCHAR(10) NOT NULL,"+
                "PRIMARY KEY (ID)"+
                ");";

                statement.executeUpdate(query);
                System.out.println("Table created");
            }
        } catch (Exception e) {
            //TODO: handle exception
        }
    }
}
