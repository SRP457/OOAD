
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import java.sql.ResultSet;
import java.sql.Statement;

public class userview {
    
    static void get_user_info(usermodel stud){


        try  {
            
            
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","Omsainamo@1");
            Statement st = con.createStatement();
            String select = "select * from user";
           
            ResultSet rs = st.executeQuery(select);

            while(rs.next()){

                String userid = rs.getString("trainerid");
                String firstName=rs.getString("firstName");
                String lastName=rs.getString("lastName");
                String phoneNumber=rs.getString("phoneNumber");
                String package_type=rs.getString("package_type");
                String field=rs.getString("field");

                System.out.println("userid      : "+userid);
                System.out.println("Firstname   : "+firstName);
                System.out.println("Lastname    : "+lastName);
                System.out.println("PhoneNumber : "+phoneNumber);
                System.out.println("package_type: "+package_type);
                System.out.println("field       : "+field+"\n\n");
                
            }
            con.close();
        }
         catch (SQLException ex) {
            System.out.println("An error occurred. Maybe user/password is invalid");
            ex.printStackTrace();
        }
        
        
    }
    
    
}
