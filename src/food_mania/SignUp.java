package food_mania;

import java.sql.*;

public class SignUp {
    public static void createUser(Connection connection , String uname,String rname,String location,String phone) {
        try {
            if(connection.isClosed()) {
                System.out.println("Connection closed in SignUp.java");
            } else {
                String query = "INSERT INTO USERS (UNAME,RNAME,LOCATION,PHONE) VALUES (?,?,?,?)";
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                preparedStatement.setString(1, uname);
                preparedStatement.setString(2, rname);
                preparedStatement.setString(3, location);
                preparedStatement.setString(4, phone);
                int i = preparedStatement.executeUpdate();
                System.out.println(i+" data inserted");
            }
        } catch (Exception e) {
            //TODO: handle exception
            System.out.println("Something went Wrong in SignUp.java");
        }
    }
}
