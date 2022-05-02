import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;


public class admincontroller {

    static public int login(adminmodel admin){
        try  {
            
            //Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","Omsainamo@1");
            Statement st = con.createStatement();
            String select = "select adminid,adminPassword from admin where adminid = "+admin.adminid+" and adminPassword = "+admin.adminPassword;
            ResultSet rs = st.executeQuery(select);
            if(rs.next()){
                System.out.println("Login Successful and Logged in as Admin Id "+admin.adminid);
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

    public static void get_all_trainers(){

        try  {
            
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","Omsainamo@1");
            Statement st = con.createStatement();
            int flag=1;
            String select = "select * from trainer";
            
            ResultSet rs = st.executeQuery(select);

            while(rs.next()){
                flag=11;
                String trainerid = rs.getString("trainerid");
                String firstName=rs.getString("firstName");
                String lastName=rs.getString("lastName");
                String phoneNumber=rs.getString("phoneNumber");
                String field=rs.getString("field");

                System.out.println("trainer ID  : "+trainerid);
                System.out.println("Firstname   : "+firstName);
                System.out.println("Lastname    : "+lastName);
                System.out.println("PhoneNumber : "+phoneNumber);
                System.out.println("field  : "+field+"\n\n");
            }
            if(flag!=11){
                System.out.println("No trainers Registered\n\n");
            }
            con.close();
        }
         catch (SQLException ex) {
            System.out.println("An error occurred. Maybe user/password is invalid");
            ex.printStackTrace();
        }
        

    }

    public static void get_all_users(){

        try  {
            
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","Omsainamo@1");
            Statement st = con.createStatement();
            String select = "select * from user";
    
            ResultSet rs = st.executeQuery(select);
            int flag=1;

            while(rs.next()){
                flag=11;
                String userid = rs.getString("userid");
                String firstName=rs.getString("firstName");
                String lastName=rs.getString("lastName");
                String phoneNumber=rs.getString("phoneNumber");
                String package_type=rs.getString("package_type");
                
                System.out.println("user userid : "+userid);
                System.out.println("Firstname   : "+firstName);
                System.out.println("Lastname    : "+lastName);
                System.out.println("Package Type    : "+package_type);
                System.out.println("PhoneNumber : "+phoneNumber + "\n\n");
            }

            if(flag!=11){
                System.out.println("No users Registered\n\n");
            }
            con.close();
        }
         catch (SQLException ex) {
            System.out.println("An error occurred. Maybe user/password is invalid");
            ex.printStackTrace();
        }
        

    }

    public static void update_user_details(){
        
        usermodel stud =new usermodel();
        Scanner sc= new Scanner(System.in); //System.in is a standard input stream.
        System.out.println("Enter userid: ");
        stud.userid= sc.nextLine(); //reads
        System.out.println("Enter New First Name: ");
        stud.firstName= sc.nextLine(); //reads string.
        System.out.println("Enter New Last Name: ");
        stud.lastName= sc.nextLine(); //reads string.
        System.out.println("Enter New Phone No: ");
        stud.phoneNumber= sc.nextLine(); //reads string.
        System.out.println("Enter package_type: ");
        stud.package_type= sc.nextLine(); //reads string.
        //sc.close();

        try  {

            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","Omsainamo@1");
            Statement st = con.createStatement();
            String up="UPDATE user set firstName = '"+stud.firstName +"', lastName = '"+stud.lastName+"', phoneNumber = '"+stud.phoneNumber+"',package_type ='"+stud.package_type +"' where userid ="+stud.userid;
            st.executeUpdate(up);

            String select = "select userid,firstName,lastName,phoneNumber,package_type from user where userid = '"+stud.userid+"' and firstName = '"+stud.firstName+"' and lastName = '"+stud.lastName+"' and phoneNumber = '"+stud.phoneNumber+"' and package_type = '"+stud.package_type;
            ResultSet rs = st.executeQuery(select);
            if(rs.next()){
            System.out.println("Updated Successfully");
             
             }
        else{
            System.out.println("Update Failed since userid is Not Valid");
            con.close();
        }

            con.close();
        }
         catch (SQLException ex) {
            System.out.println("An error occurred. Maybe user/password is invalid");
            ex.printStackTrace();
        }
    }

    public static void update_trainer_details(){
        trainermodel stud =new trainermodel();
        Scanner sc2= new Scanner(System.in); //System.in is a standard input stream.
        System.out.println("Enter trainer ID: ");
        stud.trainerid= sc2.nextLine(); //reads 
        System.out.println("Enter New First Name: ");
        stud.firstName= sc2.nextLine(); //reads string.
        System.out.println("Enter New Last Name: ");
        stud.lastName= sc2.nextLine(); //reads string.
        System.out.println("Enter New Phone No: ");
        stud.phoneNumber= sc2.nextLine(); //reads string.
        System.out.println("Enter New field: ");
        stud.field= sc2.nextLine(); //reads string.
        
        try  {
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","Omsainamo@1");
            Statement st = con.createStatement();
            
            String up="UPDATE trainer set firstName = '"+stud.firstName +"', lastName = '"+stud.lastName+"', phoneNumber = '"+stud.phoneNumber+"',field = '"+stud.field+"' where trainerid ='"+stud.trainerid+"'";
            
            st.executeUpdate(up);
            String select = "select trainerid,firstName,lastName,phoneNumber,field from trainer where trainerid = '"+stud.trainerid+"' and firstName = '"+stud.firstName+"' and lastName = '"+stud.lastName+"' and phoneNumber = '"+stud.phoneNumber+"' and field = '"+stud.field+"'";
            ResultSet rs = st.executeQuery(select);
            if(rs.next()){
            System.out.println("Updated Successfully");
            con.close();
           
            
        }
        else{
            System.out.println("Update Failed Since trainer Id is not Valid");
            con.close();
           
        }


            con.close();
        }
         catch (SQLException ex) {
            System.out.println("An error occurred. Maybe user/password is invalid");
            ex.printStackTrace();
        }
    }

    public static void register_admin(){
        adminmodel.enter_admin_details();
    }
    
}
