
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;


public class trainercontroller {

    static public int login( trainermodel teach){
        try  {
            
           
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","Omsainamo@1");
            Statement st = con.createStatement();
            String select = "select trainerid,trainerPassword from trainer where trainerid ="+teach.trainerid +" and trainerPassword = "+teach.trainerPassword;
            ResultSet rs = st.executeQuery(select);
            if(rs.next()){
                System.out.println("Login Successful and Logged in as Admin Id "+teach.trainerid);
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

    static void register_trainer(){
        trainermodel.enter_trainer_details();
    }

    public static void main(String[] args) {
        

        
    }
    


}
