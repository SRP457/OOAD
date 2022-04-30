import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class user_infomodel {
    
    String userid;
    String age;
    String gender;
    String height;
    String weight;
    Float bmi;
    String field;


    public static void enter_user_info_details(){
        user_infomodel stud=new user_infomodel();
        Scanner sc= new Scanner(System.in); //System.in is a standard input stream.
        System.out.println("Enter User id: ");
        stud.userid= sc.nextLine(); //reads 
        System.out.println("Enter age: ");
        stud.age= sc.nextLine(); //reads 
        System.out.println("Enter gender: ");
        stud.gender= sc.nextLine(); //reads string.
        System.out.println("Enter height in metres: ");
        stud.height= sc.nextLine(); //reads string.
        System.out.println("Enter weight: ");
        stud.weight= sc.nextLine(); //reads string.
        // System.out.println("Enter bmi: ");
        // stud.bmi= sc.nextLine(); //reads string.
        System.out.println("Enter field: ");
        stud.field= sc.nextLine(); //reads string.
        //sc.close();

        stud.bmi = Float.parseFloat(stud.weight) / (Float.parseFloat(stud.height) * Float.parseFloat(stud.height));

        try  {
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","Omsainamo@1");
            Statement st = con.createStatement();
            String ins = "INSERT INTO user_info VALUES ('" + stud.userid + "','"+ stud.age + "','"+  stud.gender + "','"+stud.height + "','" + stud.weight + "','"+ stud.bmi + "','" + stud.field +"')";
            st.executeUpdate(ins);

            con.close();
        }
         catch (SQLException ex) {
            System.out.println("An error occurred. Maybe user/password is invalid");
            ex.printStackTrace();
        }
    }
}
