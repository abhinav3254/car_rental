package hotel_manage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;

public class Front {
    static Connection connection;
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        connection = ConnectionSetUp.setConnection();

        while(true) {
            System.out.println("Enter 1 for add new order");
            System.out.println("Enter 2 to delete order");
            System.out.println("Enter 3 to update order");
            System.out.println("Enter 4 to see orders");
            System.out.println("Enter 5 to exit");

            String choice = br.readLine();

            if(choice.equals("5")){
                break;
            }
            if(choice.equals("1")) {
                // CreateDatabase.setDatabase(connection);
                System.out.println("Enter Name of the user:- ");
                String name = br.readLine();
                AddOrders.addOrder(name, connection);
            }

            if (choice.equals("4")) {
                ShowOrders.showData(connection);
            }
        }
    }
}
