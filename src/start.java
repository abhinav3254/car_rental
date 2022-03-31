import java.util.Scanner;

import managejdbc.StudentDao;
import managejdbc.student;

public class start {
    public static void main(String[] args) {
        System.out.println("welcome to Student Management Project");

        Scanner sc = new Scanner(System.in);
        while(true) {
            System.out.println("Press 1 to add student");
            System.out.println("Press 2 to delete student");
            System.out.println("Press 3 to display student");
            System.out.println("Preee 4 to exit");

            int c = Integer.parseInt(sc.nextLine());

            if(c==1) {
                // add student
                System.out.println("Enter User Name:");
                String name = sc.nextLine();
                // String name = sc.nextLine();

                System.out.println("Enter Phone Number");
                String phone = sc.nextLine();

                System.out.println("Enter User City");
                String city = sc.nextLine();

                // create student object to store student

                student st = new student(name,phone,city);
                boolean ans = StudentDao.insertStudentToDB(st);

                if(ans) {
                    System.out.println("Inserted....");
                } else {
                    System.out.println("Something went wrong....");
                }

                System.out.println(st);
            }
            if(c ==2 ) {
                // delete 
            } 
            if(c == 3) {
                // display

                StudentDao.studentDisplay();
            }

            if(c==4) {
                break;
            }

            else {
                
            }
        }

        System.out.println("Thank You for using our app");
    }
}
