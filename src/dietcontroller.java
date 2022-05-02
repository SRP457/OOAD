
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;

public class dietcontroller {

   static public int login(dietmodel stud){
        try  {
            
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","Omsainamo@1");
            Statement st = con.createStatement();
            String select = "select dieticianid,password from dietician where dieticianid ='"+stud.dieticianid +"' and password = '"+stud.password+"'";
            ResultSet rs = st.executeQuery(select);
            if(rs.next()){
                System.out.println("Login Successful and Logged in as userid "+stud.dieticianid);
                con.close();
                return 1;
                
            }
            else{
                System.out.println("Login Unsuccessful");
                con.close();
                return 0;
                
            }
        }
         catch (SQLException ex) {
            System.out.println("An error occurred. Maybe user/password is invalid");
            ex.printStackTrace();
        }
        return 0;
    }
    
    static public void register_dietician(){
        dietmodel.enter_dietician_details();
    }

    static public void set_diet(String dieticianid){
        dietmodel.set_user_diet(dieticianid);
    }

}   
