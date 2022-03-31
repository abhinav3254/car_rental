package managejdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class StudentDao {
    public static boolean insertStudentToDB (student st) {

        // JDBC Code to insert Value

        boolean f = false;

        try {
        Connection connection = ConnectionProvider.createConnection();
        // PARAMETRISED QUERY
        String query = "INSERT INTO STUDENTS(SNAME,SPHONE,SCITY) VALUES(?,?,?)";
        // PREPARED STATMENT
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        // set the values of parameters\
        preparedStatement.setString(1, st.getStuddentName());
        preparedStatement.setString(2, st.getStudentPhone());
        preparedStatement.setString(3, st.getStudentCity());

        // execute the query

        preparedStatement.executeUpdate();
        f = true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return f;
    }

    public static void studentDisplay(){

        try {
        Connection connection = ConnectionProvider.createConnection();
        // PARAMETRISED QUERY
        String query = "SELECT * FROM STUDENTS;";


        Statement statement = connection.createStatement();

        // Bringing the data
        ResultSet resultSet = statement.executeQuery(query);

        while(resultSet.next()) {
            int id = resultSet.getInt(1);
            String name = resultSet.getString(2);
            String phone = resultSet.getString(3);
            String city = resultSet.getString(4);

            System.out.println("ID :- "+id);
            System.out.println("Name:- "+name);
            System.out.println("Phone:- "+phone);
            System.out.println("City:- "+city);

            System.out.println("**********************");
        }


        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
