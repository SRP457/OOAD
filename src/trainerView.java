
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;


public class trainerView {
    void get_trainer_info(){
        
        try  {
            
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","Omsainamo@1");
            Statement st = con.createStatement();
            String select = "select * from trainer";
            ResultSet rs = st.executeQuery(select);

            while(rs.next()){

                String trainerid = rs.getString("trainerid");
                String firstName=rs.getString("firstName");
                String lastName=rs.getString("lastName");
                String phoneNumber=rs.getString("phoneNumber");
                String field=rs.getString("field");

                System.out.println("Trainer ID  : "+trainerid);
                System.out.println("First name  : "+firstName);
                System.out.println("Last name   : "+lastName);
                System.out.println("Phone Number: "+phoneNumber);
                System.out.print("Field         : "+field+"\n");
            }
            con.close();
        }
         catch (SQLException ex) {
            System.out.println("An error occurred. Maybe user/password is invalid");
            ex.printStackTrace();
        }
        
    }
}
