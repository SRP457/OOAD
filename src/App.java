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
            System.out.println("1) Admin \n2) User\n3) Trainer\n4) Dietician\n5) Exit \nEnter Your Option");
            option= reader.readLine();
            switch(option){
                case "1": //Admin
                adminmodel ad=new adminmodel();
                String adop1="1";
                String adflag11="3";
                do{
                    System.out.println("Admin Menu:");
                    System.out.println("1) Login \n2) Register\n3) Exit\nEnter Option");
                    adop1=reader.readLine();

                    switch(adop1){
                        

                        case "1": 
                        Integer log;
                        System.out.println("Enter Admin ID      :");
                        ad.adminid= reader.readLine();
                        System.out.println("Enter Admin Password:");
                        ad.adminPassword= reader.readLine();
                        log=admincontroller.login(ad);
                        String adflag1="3";

                        if(log==1){
                            do{
                                String adminop="5";
                                System.out.println("Logged In Admin Menu:");
                                System.out.println("1) View all Exercises \n2) View all Gyms \n3) Update Exercise Details \n4) Update Gym Details \n5) Log out \nEnter Option:");
                                if(sc.hasNextLine())
                                {
                                        adminop= sc.nextLine(); 
                                }
                                
                                switch(adminop){
                                    case "1" : // view all users
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

                case "2": //trainer
                trainermodel teach =new trainermodel();
                String op1="";
                int count=1;
                String flag="3";
                do{
                    System.out.println("Trainer Menu:");
                    System.out.println("1) Trainer Login \n2) Register Trainer \n3) Exit\nEnter Option");
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
                        System.out.println("Enter Trainer ID      :");
                        teach.trainerid= sc.nextLine(); 
                        System.out.println("Enter Trainer Password:");
                        teach.trainerPassword= sc.nextLine(); 
                        log=trainercontroller.login(teach);
                        String trainerop,trainerop1="3";
                        if(log==1){
                            do{
                                System.out.println("Logged In Trainer Menu:");
                                System.out.println("1) Set Question Paper\n2) View Question Paper\n3) Check Answer Script \n4) Log out \nEnter Option:");
                                trainerop= sc.next(); 

                                switch(trainerop){

                                    case "1": //set question paper
                                    user_infocontroller.set_user_info();
                                    break;

                                    case "2": //View Question Paper
                                    user_infocontroller.see_user_info();
                                    break;

                                    case "3": //Check answer Script
                                    ans_scriptcontroller.correct_script();
                                    break;

                                    case "4": //log out 
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

                case "3": //user
                usermodel stud =new usermodel();
                String studop1="1";
                int studcount=1;
                String studflag="3";

                do{
                    System.out.println("Dietician Menu:");
                    System.out.println("1) Dietician Login \n2) Register Dietician\n3) Exit\nEnter Option");
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
                        System.out.println("Enter Dietician ID      :");
                        stud.userid= sc.nextLine(); 
                        System.out.println("Enter Dietician Password:");
                        stud.userPassword= sc.nextLine();
                        log=usercontroller.login(stud);
                        String studop,studop11="3";
                        if(log==1){
                            do{
                                System.out.println(" Logged In Dietician Menu:");
                                System.out.println("1) Course Registration\n2) Take Exam\n3) Check Answer Script \n4) Check results \n5) Log out \nEnter Option:");
                                studop= sc.next();

                                switch(studop){
                                    case "1" : //Course Registration
                                    course_regcontroller.register_course(stud); 
                                    break;

                                    case "2" : //Take Exam
                                    examinationcontroller.take_exam(stud);
                                    break;

                                    case "3" : //Check answer Script
                                    ans_scriptcontroller.check_answer_script(stud);
                                    break;

                                    case "4" : //Check results
                                    ans_scriptcontroller.check_result(stud);
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

                case "4": //Exit
                sc.close();
                System.out.print("Exiting..."); 
                System.exit(0);
                break;

                default: System.out.println("Wrong Input");

            }

        }while(true);


    }
}
