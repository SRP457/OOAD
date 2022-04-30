import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;


public class user_infoview {

    public static void get_user_info_info(){
        

        try  {
            
            
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","Omsainamo@1");
            Statement st = con.createStatement();
            String select = "select * from user_info";
           
            int flag=1;
            ResultSet rs = st.executeQuery(select);

            while(rs.next()){
                flag=11;
                String userid = rs.getString("userid");
                String age=rs.getString("age");
                String gender=rs.getString("gender");
                String field=rs.getString("field");
                String height=rs.getString("height");
                String weight=rs.getString("weight");
                String bmi=rs.getString("bmi");

                System.out.println("Course Code     : "+userid);
                System.out.println("Course Name     : "+age);
                System.out.println("gender           : "+gender);
                System.out.println("height    : "+height);
                System.out.println("weight  : "+weight);
                System.out.println("bmi   : "+bmi);
                System.out.println("field      : "+field+"\n\n\n");
            }
            if(flag!=11){
                System.out.println("No Question Paper Set\n\n");
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
