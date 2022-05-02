import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class user_infomodel {
    
    String userid;
    String exercise_plan;


    public static void enter_user_info_details(String trainer_id){
        user_infomodel stud=new user_infomodel();
        Scanner sc= new Scanner(System.in); //System.in is a standard input stream.
        System.out.println("Enter User id: ");
        stud.userid= sc.nextLine(); //reads 
        System.out.println("Enter Exercise plan: ");
        stud.exercise_plan= sc.nextLine(); //reads 

        try  {
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","Omsainamo@1");
            Statement st = con.createStatement();
            String ins = "INSERT INTO trainer_user VALUES ('" + trainer_id + "','" + stud.userid + "','" + stud.exercise_plan +"')";
            st.executeUpdate(ins);

            con.close();
        }
         catch (SQLException ex) {
            System.out.println("An error occurred. Maybe user/password is invalid");
            ex.printStackTrace();
        }
    }
}
