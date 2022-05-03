import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;


public class user_infoview {

    public static void get_user_info(String trainer_id){
        

        try  {
            
            
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","Omsainamo@1");
            Statement st = con.createStatement();
            String select = "select * from trainer_user where trainerid = " + trainer_id;
           
            int flag=1;
            ResultSet rs = st.executeQuery(select);

            while(rs.next()){
                flag=11;
                String userid = rs.getString("userid");
                String exercise_plan=rs.getString("exercise_plan");

                System.out.println("User Id       : "+userid);
                System.out.println("Exercise Plan : "+exercise_plan+"\n");
            }
            if(flag!=11){
                System.out.println("No Users\n\n");
            }
            con.close();
            con.close();
        }
         catch (SQLException ex) {
            System.out.println("An error occurred. Maybe user/password is invalid");
            ex.printStackTrace();
        }

    }
    
}
