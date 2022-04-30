import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class usermodel {

    String userid;
    String userPassword;
    String firstName;
    String lastName;
    String phoneNumber;
    String package_type;
    String field;

    static void enter_user_details(){
        usermodel stud=new usermodel();
        Scanner sc= new Scanner(System.in); //System.in is a standard input stream.
        System.out.println("Enter userid: ");
        stud.userid= sc.nextLine(); //reads String.
        System.out.println("Enter user Password: ");
        stud.userPassword= sc.nextLine(); //reads string.
        System.out.println("Enter First Name: ");
        stud.firstName= sc.nextLine(); //reads string.
        System.out.println("Enter Last Name: ");
        stud.lastName= sc.nextLine(); //reads string.
        System.out.println("Enter Phone No: ");
        stud.phoneNumber= sc.nextLine(); //reads string.
        System.out.println("Enter package_type(regular/premium): ");
        stud.package_type= sc.nextLine(); //reads string.
        System.out.println("Enter field: ");
        stud.field= sc.nextLine(); //reads string.
        

        try  {
            
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","Omsainamo@1");
            Statement st = con.createStatement();
            String ins = "INSERT INTO user VALUES ('" + stud.userid+ "','"+ stud.userPassword + "','" + stud.firstName + "','" + stud.lastName + "','" +stud.phoneNumber+"','"+stud.package_type+"','"+
            stud.field  + "')";
            st.executeUpdate(ins);

            con.close();
        }
         catch (SQLException ex) {
            System.out.println("An error occurred. Maybe user/password is invalid");
            ex.printStackTrace();
        }
    }

    

    
}
