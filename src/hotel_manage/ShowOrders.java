package hotel_manage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;


public class ShowOrders {
    public static void showData(Connection connection) {
        try {

            if(connection.isClosed()) {
                System.out.println("connection closed in ShowOrders Class");
            } else {
                System.out.println("Connection Open in ShowOrders class");
            }
            int i = 1;
            System.out.print("Showing Orders");
            while(i<4) {
                System.out.print(".");
                Thread.sleep(1000);
                i++;
            }
            System.out.println();
            System.out.println("The Data..");

            Statement statement = connection.createStatement();
            String query = "SELECT * FROM ORDERS";
            ResultSet resultSet = statement.executeQuery(query);

            while(resultSet.next()) {
                System.out.print("Id is:- "+resultSet.getInt("id")+"  || \t");
                System.out.println("Name is: - "+resultSet.getString("name"));
                Thread.sleep(1000);
            }
        } catch (Exception e) {
            System.out.println("Something Went Wrong");
        }
    }
}
