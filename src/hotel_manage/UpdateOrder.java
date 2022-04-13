package hotel_manage;

import java.sql.Connection;
import java.sql.Statement;

public class UpdateOrder {
    public static void updateOrder(int id,String name,Connection connection) {
        try {
            String query = "UPDATE ORDERS SET NAME = '"+name+"' WHERE ID = "+id;
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
            System.out.println("Updated Succesfully");
        } catch (Exception e) {
            System.out.println("Something went Wrong");
        }
    }
}
