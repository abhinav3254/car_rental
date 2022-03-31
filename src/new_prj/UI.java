package new_prj;

import new_prj.manage_new.Student;
import new_prj.manage_new.StudentDAO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UI {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
            System.out.println("Hit 1 to register");
            System.out.println("Hit 2 to delete your account");
            System.out.println("Hit 3 to update account");
            System.out.println("Hit 4 to display");
            System.out.println("Hit 5 to exit");

            String choice = br.readLine();

            if(choice.equals("1")) {
                // Register

                System.out.print("Enter Name:- ");
                String name = br.readLine();
                System.out.print("Enter Phone:- ");
                String phone = br.readLine();
                System.out.print("Enter City:- ");
                String city = br.readLine();

                Student student = new Student(name,phone,city);

                boolean ans  = StudentDAO.insertIntoDB(student);
                if(ans) {
                    System.out.println("Inserted");
                } else {
                    System.out.println("Failed");
                }

            }

            if(choice.equals("2")) {
                System.out.println("Enter ID to delete");
                String id = br.readLine();
               boolean ans = StudentDAO.deleteData(Integer.parseInt(id));
            }

//            UPDATE

            if(choice.equals("3")) {
                System.out.println("Enter ID");
                String id = br.readLine();
                System.out.println("Enter name");
                String name = br.readLine();
                System.out.println("Enter phone");
                String phone = br.readLine();
                System.out.println("Enter city");
                String city = br.readLine();
                boolean ans = StudentDAO.updateDetails(Integer.parseInt(id),name,phone,city);
                if(ans) {
                    System.out.println("Updated");
                } else {
                    System.out.println("Something went wrong");
                }
            }
            if(choice.equals("4")) {
//                Display
                StudentDAO.displayDetails();
            }
            if(choice.equals("5")) {
                // Exit
                break;
            }
        }

        System.out.println("Thank You\nSee You Again");
    }
}
