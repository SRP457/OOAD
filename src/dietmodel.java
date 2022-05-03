import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;


public class dietmodel {
    String dieticianid;
    String firstName;
    String password;
    String lastName;
    String phoneNumber;

    static void enter_dietician_details(){
        dietmodel stud =new dietmodel();
        Scanner sc= new Scanner(System.in); //System.in is a standard input stream.
        System.out.println("Enter Dietician ID: ");
        stud.dieticianid= sc.nextLine(); //reads 
        System.out.println("Enter Dietician Password: ");
        stud.password= sc.nextLine(); //reads
        System.out.println("Enter First Name: ");
        stud.firstName= sc.nextLine(); //reads string.
        System.out.println("Enter Last Name: ");
        stud.lastName= sc.nextLine(); //reads string.
        System.out.println("Enter Phone No: ");
        stud.phoneNumber= sc.nextLine(); //reads string.
       

        try  {
            
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","Omsainamo@1");
            Statement st = con.createStatement();
            String ins = "INSERT INTO dietician VALUES ('" + stud.dieticianid + "','"+ stud.password + "','" + stud.firstName + "','" + stud.lastName + "','"+stud.phoneNumber+ "')";
            st.executeUpdate(ins);

            con.close();
        }
         catch (SQLException ex) {
            System.out.println("An error occurred. Maybe user/password is invalid");
            ex.printStackTrace();
        }
    }


    public static void set_user_diet(String dieticianid){
        user_infomodel stud=new user_infomodel();
        Scanner sc= new Scanner(System.in); //System.in is a standard input stream.
        System.out.println("Enter User id: ");
        stud.userid= sc.nextLine(); //reads 
        System.out.println("Enter Diet plan: ");
        stud.exercise_plan= sc.nextLine(); //reads 
        ResultSet rs;

        try {
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","Omsainamo@1");
            Statement st = con.createStatement();
            String ins = "SELECT * from user where userid = " + stud.userid;
            rs = st.executeQuery(ins);

            if (rs.next()) {
                try  {
                    Connection con1=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","Omsainamo@1");
                    Statement st1 = con1.createStatement();
                    String ins1 = "INSERT INTO diet_user VALUES ('" + dieticianid + "','" + stud.userid + "','" + stud.exercise_plan +"')";
                    st1.executeUpdate(ins1);
        
                    con1.close();
                }
                 catch (SQLException ex) {
                    System.out.println("An error occurred. Maybe user/password is invalid");
                    ex.printStackTrace();
                }
            }
            else {
                System.out.println("User doesn't exist");
            }

            con.close();
        }
        catch (SQLException ex) {
            System.out.println("An error occurred. Maybe user/password is invalid");
            ex.printStackTrace();
        }

    }

    public static void view_users(String dieticianid){
        
        try  {            
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","Omsainamo@1");
            Statement st = con.createStatement();
            String select = "select * from diet_user where dieticianid = " + dieticianid;
           
            int flag=1;
            ResultSet rs = st.executeQuery(select);

            while(rs.next()){
                flag=11;
                String userid = rs.getString("userid");
                String exercise_plan=rs.getString("diet_plan");

                System.out.println("User Id     : "+userid);
                System.out.println("Diet Plan     : "+exercise_plan+"\n\n\n");
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
