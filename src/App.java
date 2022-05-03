import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class App {
    
    public static void main(String[] args) throws Exception {
        
        String option;
        Scanner sc= new Scanner(System.in);
        BufferedReader reader = new BufferedReader(
        new InputStreamReader(System.in));

        do{
            System.out.println("Main Menu :");
            System.out.println("Login as :");
            System.out.print("1)Admin 2)Trainer 3)User 4)Dietician 5)Exit \nEnter Your Option: ");
            option= reader.readLine();
            switch(option){
                case "1": //Admin
                adminmodel ad=new adminmodel();
                String adop1="1";
                String adflag11="3";
                do{
                    System.out.println("Admin Menu:");
                    System.out.print("1)Login  2)Register 3)Exit \nEnter Option: ");
                    adop1=reader.readLine();

                    switch(adop1){
                    
                        case "1": 
                        Integer log;
                        System.out.print("Enter Admin ID: ");
                        ad.adminid= reader.readLine();
                        System.out.print("Enter Admin Password: ");
                        ad.adminPassword= reader.readLine();
                        log=admincontroller.login(ad);
                        String adflag1="3";

                        if(log==1){
                            do{
                                String adminop="5";
                                System.out.println("Logged In Admin Menu:");
                                System.out.print("1)View all users 2)View all Trainers 3)Update Trainer Details 4)Update User Details 5)Log out \nEnter Option: ");
                                if(sc.hasNextLine())
                                {
                                        adminop= sc.nextLine(); 
                                }
                                
                                switch(adminop){
                                    case "1" : // view all exercises
                                    admincontroller.get_all_users();
                                    break;

                                    case "2" : //view all trainers
                                    admincontroller.get_all_trainers();
                                    break;

                                    case "3" : //update trainer details
                                    admincontroller.update_trainer_details();
                                    break;

                                    case "4" : //update user details
                                    admincontroller.update_user_details();
                                    break;

                                    case "5" : //Log out 
                                    adflag1="2";
                                    break;

                                }


                            }while(adflag1.equals("3"));


                        }
                        
                        break;

                        case "2"://Register Admin
                        admincontroller.register_admin(); 
                        break;

                        case "3": //exit
                        System.out.print("Exiting...");
                        System.exit(0);
                        break;

                        default : System.out.println("Wrong Input");

                    }

                
                }while(adflag11.equals("3"));
                break;

                case "2": //login as trainer
                trainermodel teach =new trainermodel();
                String op1="";
                int count=1;
                String flag="3";
                do{
                    System.out.println("\n\nTrainer Menu:");
                    System.out.print("1)Trainer Login 2)Register Trainer 3)Exit\nEnter Option: ");
                    if(sc.hasNextLine() & count!=1)
                    {
                    op1= sc.nextLine(); 
                    } 
                                
                    if(count==1){
                        count++;
                        op1= sc.nextLine(); 
                        }

                    switch(op1){
                        case "1" : //Login
                        int log;
                        System.out.print("Enter Trainer ID: ");
                        teach.trainerid= sc.nextLine(); 
                        System.out.print("Enter Trainer Password: ");
                        teach.trainerPassword= sc.nextLine(); 
                        log=trainercontroller.login(teach);
                        String trainerop,trainerop1="3";
                        if(log==1){
                            do{
                                System.out.println("\n\nLogged In Trainer Menu:");
                                System.out.print("1)Set Exercise 2)View users 3)Log out \nEnter Option: ");
                                trainerop= sc.next(); 

                                switch(trainerop){

                                    case "1": //set exercise
                                    user_infocontroller.set_user_exercise(teach.trainerid);
                                    break;

                                    case "2": //View Users
                                    user_infocontroller.see_user_info(teach.trainerid);
                                    break;

                                    case "3": //log out 
                                    trainerop1="2";
                                    break;

                                    default: System.out.println("Wrong Input");

                                }


                            }while(trainerop1.equals("3"));

                        }

                        break;

                        case "2" : //Register trainer
                        trainercontroller.register_trainer();
                        break;

                        case "3" : //Log out
                        System.out.print("Exiting...");
                        System.exit(0);
                        break;

                        default: System.out.println("Wrong Input");



                    }



                }while(flag.equals("3"));

                break;

                case "3": //login as user
                usermodel stud =new usermodel();
                String studop1="1";
                int studcount=1;
                String studflag="3";

                do{
                    System.out.println("\n\nUser Menu:");
                    System.out.print("1)User Login 2)Register User 3)Exit\nEnter Option: ");
                    if(sc.hasNextLine() & studcount!=1)
                    {
                    studop1= sc.nextLine(); 
                    } 
                    if(studcount==1){
                    studcount++;
                    studop1= sc.nextLine(); 
                    }

                    switch(studop1){
                        case "1": //login
                        int log;
                        System.out.print("Enter User ID: ");
                        stud.userid= sc.nextLine(); 
                        System.out.print("Enter User Password: ");
                        stud.userPassword= sc.nextLine();
                        log=usercontroller.login(stud);
                        String studop,studop11="3";
                        if(log==1){
                            do{
                                System.out.println("\n\nLogged In User Menu:");
                                System.out.print("1)Get exercises 2)Get Diet 3)Get trainers  4)Get dieticians 5) Log out \nEnter Option: ");
                                studop= sc.next();

                                switch(studop){
                                    case "1" : //Get exercises
                                    course_regcontroller.get_exercises(stud); 
                                    break;

                                    case "2" : //Get diet
                                    course_regcontroller.get_diets(stud);
                                    break;

                                    case "3" : 
                                    course_regcontroller.get_trainers();
                                    break;

                                    case "4" :
                                    course_regcontroller.get_dieticians();
                                    break;

                                    case "5" : //logout
                                    studop11="2";
                                    break;
                                
                                
                                }
                            }while(studop11.equals("3"));
                        }
                        
                        break;

                        case "2": //Register user 
                        usercontroller.register_user();
                        break;

                        case "3": //Log out
                        System.out.print("Exiting...");
                        System.exit(0);
                        break;


                    }

                }while(studflag.equals("3"));

                break;


                case "4": //login as dietician
                dietmodel diet = new dietmodel();
                String dietop1="1";
                int dietcount=1;
                String dietflag="3";

                do{
                    System.out.println("\n\nDietician Menu:");
                    System.out.print("1)Dietician Login 2)Register Dietician 3)Exit\nEnter Option: ");
                    if(sc.hasNextLine() & dietcount!=1)
                    {
                    dietop1= sc.nextLine(); 
                    } 
                    if(dietcount==1){
                    dietcount++;
                    dietop1= sc.nextLine(); 
                    }

                    switch(dietop1){
                        case "1": //login
                        int log;
                        System.out.print("Enter Dietician ID: ");
                        diet.dieticianid= sc.nextLine(); 
                        System.out.print("Enter Dietician Password: ");
                        diet.password= sc.nextLine();
                        log=dietcontroller.login(diet);
                        String dietop,dietop11="3";
                        if(log==1){
                            do{
                                System.out.println(" Logged In Dietician Menu:");
                                System.out.print("1)Set Diet 2)View Users 3)Log out \nEnter Option: ");
                                dietop= sc.next();

                                switch(dietop){
                                    case "1" : //Course Registration
                                    dietcontroller.set_diet(diet.dieticianid); 
                                    break;

                                    case "2" : //Take Exam
                                    dietcontroller.view_diet_users(diet.dieticianid);
                                    break;

                                    case "3" : //logout
                                    dietop11="2";
                                    break;                            
                                }

                            }while(dietop11.equals("3"));
                        }
                        
                        break;

                        case "2": //Register diet 
                        dietcontroller.register_dietician();
                        break;

                        case "3": //Log out
                        System.out.print("Exiting...");
                        System.exit(0);
                        break;
                    }

                }while(dietflag.equals("3"));

                break;

                case "5": //Exit
                sc.close();
                System.out.print("Exiting..."); 
                System.exit(0);
                break;

                default: System.out.println("Wrong Input");

            }

        }while(true);


    }
}
