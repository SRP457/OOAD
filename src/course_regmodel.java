import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;


public class course_regmodel {

    String userid;
    
    static public void reg(usermodel regs){

        course_regmodel stud= new course_regmodel();
        stud.userid=regs.userid;
    
        try  {
            
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","Omsainamo@1");
            Statement st = con.createStatement();
            String ins = "SELECT * FROM trainer_user where userid = " + stud.userid;            

            int flag=1;
            ResultSet rs = st.executeQuery(ins);

            while(rs.next()){
                flag=11;
                String exercise_plan=rs.getString("exercise_plan");
                System.out.println("Exercise Plan: "+exercise_plan);
            }
            if(flag!=11){
                System.out.println("No Plans\n\n");
            }
        }
        catch (SQLException ex) {
            System.out.println("An error occurred. Maybe user/password is invalid");
            ex.printStackTrace();
        }
    }


    static public void getdiets(usermodel regs){

        course_regmodel stud= new course_regmodel();
        stud.userid=regs.userid;
    
        try  {
            
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","Omsainamo@1");
            Statement st = con.createStatement();
            String ins = "SELECT * FROM diet_user where userid = " + stud.userid;            

            int flag=1;
            ResultSet rs = st.executeQuery(ins);

            while(rs.next()){
                flag=11;
                String exercise_plan=rs.getString("diet_plan");
                System.out.println("Diet Plan: "+exercise_plan);
            }
            if(flag!=11){
                System.out.println("No Plans\n\n");
            }
        }
        catch (SQLException ex) {
            System.out.println("An error occurred. Maybe user/password is invalid");
            ex.printStackTrace();
        }
    }


    static public void gettrainers(){

        try  {
            
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","Omsainamo@1");
            Statement st = con.createStatement();
            String ins = "SELECT * FROM trainer";            

            int flag=1;
            ResultSet rs = st.executeQuery(ins);

            while(rs.next()){
                flag=11;
                String first=rs.getString("firstName");
                String last=rs.getString("lastName");
                String field=rs.getString("field");
                String ph=rs.getString("phoneNumber");

                System.out.println("First name  :" + first);
                System.out.println("Last name   :" + last);
                System.out.println("Field       :" + last);
                System.out.print("Phone number  :" + ph + "\n\n");
            }
            if(flag!=11){
                System.out.println("No Trainers\n\n");
            }
        }
        catch (SQLException ex) {
            System.out.println("An error occurred. Maybe user/password is invalid");
            ex.printStackTrace();
        }
    }


    static public void getdieticians(){

        try  {
            
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","Omsainamo@1");
            Statement st = con.createStatement();
            String ins = "SELECT * FROM dietician";            

            int flag=1;
            ResultSet rs = st.executeQuery(ins);

            while(rs.next()){
                flag=11;
                String first=rs.getString("firstName");
                String last=rs.getString("lastName");
                String ph=rs.getString("phoneNumber");

                System.out.println("First name  :" + first);
                System.out.println("Last name   :" + last);
                System.out.print("Phone number  :" + ph + "\n\n");
            }
            if(flag!=11){
                System.out.println("No Dieticians\n\n");
            }
        }
        catch (SQLException ex) {
            System.out.println("An error occurred. Maybe user/password is invalid");
            ex.printStackTrace();
        }
    }
}
