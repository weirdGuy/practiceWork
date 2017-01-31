package io.weirdguy.practice;

import java.util.Objects;

public class Main {

    public static void main(String[] args) {
        double[] test = new double[]{60.0, 50.0, 70.0};
        StudentGradesDouble stud = new StudentGradesDouble(test);
        stud.addGrade(1.0);
        stud.addGrade(60.0);
        stud.addGrade(60.5);
        stud.addGrade(60.0);
        stud.addGrade(60.5);
        stud.addGrade(60.0);
        stud.addGrade(20.0);
        stud.addGrade(1.0);
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
