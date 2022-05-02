public class course_regcontroller {
 
    
    static public void get_exercises(usermodel stud){
        course_regmodel.reg(stud);
    }

    static public void get_diets(usermodel stud){
        course_regmodel.getdiets(stud);
    }

    static public void get_trainers(){
        course_regmodel.gettrainers();
    }

    static public void get_dieticians(){
        course_regmodel.getdieticians();
    }
}
