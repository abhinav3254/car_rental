package hotel_manage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Front {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
            System.out.println("Enter 1 for add new order");
            System.out.println("Enter 2 to delete order");
            System.out.println("Enter 3 to update order");
            System.out.println("Enter 4 to see orders");
            System.out.println("Enter 5 to exit");

            String choice = br.readLine();

            if(choice.equals("5"))
            break;

            if(choice.equals("1"))
            break;
        }
    }
}
