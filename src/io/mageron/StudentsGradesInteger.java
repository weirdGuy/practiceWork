package io.mageron;

import java.util.Arrays;
import java.util.Date;
import java.util.Objects;

/**
 * io.mageron by Molod
 * 31.01.2017
 */
public class StudentsGradesInteger implements StudentsGradesInterface<Integer>{

    private Integer[] marks;

    private Integer maxGrade;
    private Integer minGrade;

    private double avarageGrade = 0;

    private int exceStud = 0;
    private int wellStud = 0;
    private int goodStud = 0;

    private int allMarks = 0;
    private Integer allMarksSum = 0;

    private int emptySpace = 0;

    public StudentsGradesInteger(int[] _marks) {

        this.marks = Arrays.stream(_marks).boxed().toArray(Integer[]::new);
        for(int i = 0; i < marks.length; i++) {
            if(i == 0) {
                minGrade = marks[i];
                maxGrade = marks[i];
            }
            if(marks[i] >= 0 && marks[i] <= 100) {
                allMarks++;
                checkMinMax(marks[i]);
                allMarksSum += marks[i];
                addStud(marks[i]);
            }
        }

        avarageGrade = allMarksSum / allMarks;

        log(avarageGrade);

    }

    @Override
    public void addGrade(Integer grade) {

        if(grade >= 0 && grade <= 100) {

            if(emptySpace == 0) {
                emptySpace = 5;
                marks = Arrays.copyOf(marks, marks.length + emptySpace);

                for(int i = marks.length - emptySpace; i < marks.length; i++) {
                    marks[i] = -1;
                }
            }

            marks[marks.length - emptySpace] = grade;
            emptySpace--;
            checkMinMax(grade);
            addStud(grade);
            allMarks++;
            allMarksSum += grade;
            avarageGrade = allMarksSum / allMarks;
        }

    }

    public int getUpAvarage() {
        int count = 0;
        for(Integer mark:
                marks) {
            if(mark > avarageGrade) count++;
        }
        return count;
    }

    public int getLowAvarage() {
        int count = 0;
        for(Integer mark:
                marks) {
            if(mark < avarageGrade) count++;
        }
        return count;
    }

    @Override
    public Integer getMaxGrade() {
        return this.maxGrade;
    }

    @Override
    public Integer getMinGrade() {
        return this.minGrade;
    }

    @Override
    public double getAvarageGrade() {
        return this.avarageGrade;
    }

    @Override
    public String getAllMarks() {
        String s = "[";
        for(int i = 0; i < marks.length; i++) {
            if(marks[i] >= 0) {
                if(marks.length - i - emptySpace - 1 == 0) s += marks[i];
                else s += marks[i] + ", ";
            }
        }
        return s + "]";
    }

    public int getExceStud() {
        return this.exceStud;
    }

    public int getWellStud() {
        return this.wellStud;
    }

    public int getGoodStud() {
        return this.goodStud;
    }

    private void checkMinMax(Integer i) {
        if(i > maxGrade) maxGrade = i;
        if(i < minGrade) minGrade = i;
    }

    private void addStud(Integer i) {
        if(i >= 91 && i <= 100) {
            exceStud++;
        } else if(i >= 71 && i <= 90) {
            wellStud++;
        } else if(i >= 60 && i <= 70) {
            goodStud++;
        }
    }

    private void log(Object obj) {
        System.out.println(obj);
    }
}
