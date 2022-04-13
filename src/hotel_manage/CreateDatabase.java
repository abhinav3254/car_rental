package hotel_manage;
import java.sql.*;
public class CreateDatabase {
    public static void setDatabase(Connection connection) {
        try {
            if(connection.isClosed()){
                System.out.println("Connection is Close in CreateDatabase Class");
            } else {
                System.out.println("Connection is open in CreateDatabase Class");
            }

            Statement statement = connection.createStatement();

            String query = "CREATE DATABASE RES";
            statement.executeUpdate(query);
            System.out.println("RES named database created Successfully");
        } catch (Exception e) {
            System.out.println("Something went Wrong");
        }
    }
}
