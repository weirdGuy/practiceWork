package io.mageron;

public class Main {

    public static void main(String[] args) {

        int[] marks = new int[]{60, 40, 70};

        StudentsGradesInteger stud = new StudentsGradesInteger(marks);
        stud.addGrade(1);
        stud.addGrade(60);
        stud.addGrade(60);
        stud.addGrade(60);
        stud.addGrade(60);
        stud.addGrade(60);
        stud.addGrade(20);
        stud.addGrade(1);
        log("All marks: " + stud.getAllMarks());
        log("Avarage grade: " + stud.getAvarageGrade());
        log("Excelent stud: " + stud.getExceStud());
        log("Good stud: " + stud.getGoodStud());
        log("Well stud: " + stud.getWellStud());
        log("Max grade: " + stud.getMaxGrade());
        log("Min grade: " + stud.getMinGrade());
        log("Up avarage: " + stud.getUpAvarage());
        log("Low avarage: " + stud.getLowAvarage());

    }

    private static void log(Object obj) {
        System.out.println(obj);
    }
}
