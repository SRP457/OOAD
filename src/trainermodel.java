import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import java.sql.Statement;


public class trainermodel {

    String trainerid;
    String trainerPassword;
    String firstName;
    String lastName;
    String phoneNumber;
    String field;

    static void enter_trainer_details(){
        trainermodel stud =new trainermodel();
        Scanner sc= new Scanner(System.in); //System.in is a standard input stream.
        System.out.println("Enter trainer ID: ");
        stud.trainerid= sc.nextLine(); //reads 
        System.out.println("Enter trainer Password: ");
        stud.trainerPassword= sc.nextLine(); //reads
        System.out.println("Enter First Name: ");
        stud.firstName= sc.nextLine(); //reads string.
        System.out.println("Enter Last Name: ");
        stud.lastName= sc.nextLine(); //reads string.
        System.out.println("Enter Phone No: ");
        stud.phoneNumber= sc.nextLine(); //reads string.
        System.out.println("Enter field: ");
        stud.field= sc.nextLine(); //reads string.
       

        try  {
            
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","Omsainamo@1");
            Statement st = con.createStatement();
            String ins = "INSERT INTO trainer VALUES ('" + stud.trainerid + "','"+ stud.trainerPassword + "','" + stud.firstName + "','" + stud.lastName + "','" + stud.field+"','"+stud.phoneNumber+ "')";
            st.executeUpdate(ins);

            con.close();
        }
         catch (SQLException ex) {
            System.out.println("An error occurred. Maybe user/password is invalid");
            ex.printStackTrace();
        }
    }


    
}
