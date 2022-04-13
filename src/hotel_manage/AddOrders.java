package hotel_manage;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class AddOrders {
    public static void addOrder(String name, Connection connection) {
        try {
            if (connection.isClosed()) {
                System.out.println("Connection closed in AddOrders class");
            } else {
                System.out.println("Connection is Open in AddOrders Class");
            }
            String query = "INSERT INTO ORDERS(name) VALUES (?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,name);

            int i = preparedStatement.executeUpdate();
            System.out.println(i+" data inserted");
        } catch (Exception e) {
            System.out.println("something went wrong");
        }
    }
}
