import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class course_regmodel {

    String userid;
    String userid;
    String age;


    
    static public void reg(usermodel regs){

        course_regmodel stud= new course_regmodel();
        stud.userid=regs.userid;
        Scanner sc= new Scanner(System.in); //System.in is a standard input stream.
        System.out.println("Enter Course Code: ");
        stud.userid= sc.nextLine(); //reads 
        System.out.println("Enter Course Name : ");
        stud.age= sc.nextLine(); //reads 
    
        try  {
            
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","Omsainamo@1");
            Statement st = con.createStatement();
            String ins = "INSERT INTO course_reg VALUES ('" +stud.userid + "','"+ stud.userid + "','"+ stud.age +"')";
            
    
            st.executeUpdate(ins);
    
            con.close();
        }
         catch (SQLException ex) {
            System.out.println("An error occurred. Maybe user/password is invalid");
            ex.printStackTrace();
        }
    
    }

}
