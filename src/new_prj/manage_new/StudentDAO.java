package new_prj.manage_new;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class StudentDAO {

    public static boolean insertIntoDB (Student student) {

        boolean flag = false;

        try {
            Connection connection = ConnectionProvider.createConnection();
//        Query
            String query = "INSERT INTO STUDENT_NEW(NAME,PHONE,CITY) VALUES (?,?,?)";
//        Prepared Statement
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,student.getSname());
            preparedStatement.setString(2, student.getSphone());
            preparedStatement.setString(3,student.getScity());

            preparedStatement.executeUpdate();

            flag = true;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return flag;
    }

    public static void displayDetails () {
        try {
            Connection connection = ConnectionProvider.createConnection();
            // Query
            String query = "SELECT * FROM STUDENT_NEW";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while(resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString("name");
                String phone = resultSet.getString("phone");
                String city = resultSet.getString("city");

                System.out.println("ID :- "+id);
                System.out.println("Name:- "+name);
                System.out.println("Phone:- "+phone);
                System.out.println("City:- "+city);
                System.out.println("****************************");
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean deleteData(int id) {
        boolean flag = false;

        try {
            Connection connection = ConnectionProvider.createConnection();
            String query = "DELETE FROM STUDENT_NEW WHERE ID = "+id;

            Statement statement = connection.createStatement();
            statement.executeUpdate(query);

            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return flag;
    }

    public static boolean updateDetails (int id ,String name,String phone,String city) {
        boolean flag = false;
        try {
            Connection connection = ConnectionProvider.createConnection();

            String query = "UPDATE STUDENT_NEW SET NAME = '"+name+"', PHONE = '"+phone+"',CITY = '"+city+"' WHERE ID = "+id;

            Statement statement = connection.createStatement();
            statement.executeUpdate(query);


            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return flag;
    }
}
