
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;

public class usercontroller {

   static public int login(usermodel stud){
        try  {
            
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","Omsainamo@1");
            Statement st = con.createStatement();
            String select = "select userid,userPassword from user where userid ='"+stud.userid +"' and userPassword = '"+stud.userPassword+"'";
            ResultSet rs = st.executeQuery(select);
            if(rs.next()){
                System.out.println("Login Successful and Logged in as userid "+stud.userid);
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
    
    static public void register_user(){
        usermodel.enter_user_details();
    }

}   
