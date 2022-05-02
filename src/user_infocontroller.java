
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import java.sql.ResultSet;
import java.sql.Statement;


public class user_infocontroller {

    public static void get_user_info_info(){
        try  {
            
           
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","Omsainamo@1");
            Statement st = con.createStatement();
            String select = "select * from user_info";
            
            ResultSet rs = st.executeQuery(select);

            while(rs.next()){

                String userid = rs.getString("userid");
                String age=rs.getString("age");
                String gender=rs.getString("gender");
                String field=rs.getString("field");
                String height=rs.getString("height");
                String weight=rs.getString("weight");
                String BMI=rs.getString("BMI");

                System.out.println("User id   : "+userid);
                System.out.println("age    : "+age);
                System.out.println("gender           : "+gender);
                System.out.println("height    : "+height);
                System.out.println("weight  : "+weight);
                System.out.println("BMI   : "+ BMI);
                System.out.println("field      : "+field+"\n\n\n");
            }
            con.close();
        }
         catch (SQLException ex) {
            System.out.println("An error occurred. Maybe user/password is invalid");
            ex.printStackTrace();
        }

    }
    
    public static void set_user_exercise(String trainer_id){
        user_infomodel.enter_user_info_details(trainer_id);
    }

    public static void see_user_info(String trainer_id){

        user_infoview.get_user_info(trainer_id);

    }
}
