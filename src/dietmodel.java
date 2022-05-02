import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class dietmodel {
    String dieticianid;
    String firstName;
    String password;
    String lastName;
    String phoneNumber;

    static void enter_dietician_details(){
        dietmodel stud =new dietmodel();
        Scanner sc= new Scanner(System.in); //System.in is a standard input stream.
        System.out.println("Enter Dietician ID: ");
        stud.dieticianid= sc.nextLine(); //reads 
        System.out.println("Enter Dietician Password: ");
        stud.password= sc.nextLine(); //reads
        System.out.println("Enter First Name: ");
        stud.firstName= sc.nextLine(); //reads string.
        System.out.println("Enter Last Name: ");
        stud.lastName= sc.nextLine(); //reads string.
        System.out.println("Enter Phone No: ");
        stud.phoneNumber= sc.nextLine(); //reads string.
       

        try  {
            
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","Omsainamo@1");
            Statement st = con.createStatement();
            String ins = "INSERT INTO dietician VALUES ('" + stud.dieticianid + "','"+ stud.password + "','" + stud.firstName + "','" + stud.lastName + "','"+stud.phoneNumber+ "')";
            st.executeUpdate(ins);

            con.close();
        }
         catch (SQLException ex) {
            System.out.println("An error occurred. Maybe user/password is invalid");
            ex.printStackTrace();
        }
    }


    public static void set_user_diet(String dieticianid){
        user_infomodel stud=new user_infomodel();
        Scanner sc= new Scanner(System.in); //System.in is a standard input stream.
        System.out.println("Enter User id: ");
        stud.userid= sc.nextLine(); //reads 
        System.out.println("Enter Diet plan: ");
        stud.exercise_plan= sc.nextLine(); //reads 

        try  {
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","Omsainamo@1");
            Statement st = con.createStatement();
            String ins = "INSERT INTO dieti_user VALUES ('" + dieticianid + "','" + stud.userid + "','" + stud.exercise_plan +"')";
            st.executeUpdate(ins);

            con.close();
        }
         catch (SQLException ex) {
            System.out.println("An error occurred. Maybe user/password is invalid");
            ex.printStackTrace();
        }
    }
}
