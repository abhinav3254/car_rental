package hotel_manage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class DeleteOrders {
    public static void deleteOrder(int id,Connection connection) {
        try {
            String query = "DELETE FROM ORDERS WHERE id = "+id;
            Statement statement = connection.createStatement();
            int i = statement.executeUpdate(query);
            System.out.println(i+" rows affected");
        } catch (Exception e) {
            System.out.println("Something went Wrong");
        }
    }
}
