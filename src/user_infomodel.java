import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

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
        ResultSet rs;

        try {
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","Omsainamo@1");
            Statement st = con.createStatement();
            String ins = "SELECT * from user where userid = " + stud.userid;
            rs = st.executeQuery(ins);

            if (rs.next()) {
                try  {
                    Connection con1=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","Omsainamo@1");
                    Statement st1 = con1.createStatement();
                    String ins1 = "INSERT INTO trainer_user VALUES ('" + trainer_id+ "','" + stud.userid + "','" + stud.exercise_plan +"')";
                    st1.executeUpdate(ins1);
                    con1.close();
                }
                 catch (SQLException ex) {
                    System.out.println("An error occurred. Maybe user/password is invalid");
                    ex.printStackTrace();
                }
            }
            else {
                System.out.println("User doesn't exist");
            }
        
            con.close();
        }
         catch (SQLException ex) {
            System.out.println("An error occurred. Maybe user/password is invalid");
            ex.printStackTrace();
        }

        

    }
}
