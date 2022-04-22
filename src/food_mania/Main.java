package food_mania;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;

public class Main {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Connection connection = CreateConnection.createConnection();
        CreateTable.createTableUser(connection);

        while(true) {

            System.out.println("Hit 1 for Log In");
            System.out.println("Hit 2 to register");
            System.out.println("Hit 3 to exit");

            String choice = br.readLine();

            if(choice.equals("1")) {

                System.out.print("Enter username:- ");
                String name = br.readLine();
                System.out.print("Enter Password");
                String password = br.readLine();

            } else if(choice.equals("2")) {

                System.out.print("Enter Username:-");
                String uname = br.readLine();
                System.out.print("Enter Real Name");
                String rname = br.readLine();
                System.out.print("Enter Location:-");
                String location = br.readLine();
                System.out.println("Enter Phone Number");
                String phone = br.readLine();

                SignUp.createUser(connection, uname, rname, location, phone);

                System.out.println("Log In again...... to use our feature");

            } else if(choice.equals("3")) {
                break;
            } else {

            }
        }
    }
}
