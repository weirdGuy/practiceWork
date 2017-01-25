package io.weirdguy.practice;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

/**
 * Created by laiko on 25.01.2017.
 */
public class StudentsGrades {

    private int[] marks;
    private int[] buffArr;

    private double maxGrade = 0;
    private double minGrade = 0;

    private double avarageGrade = 0;

    private int exceStud = 0;
    private int wellStud = 0;
    private int goodStud = 0;

    private int allMarks = 0;
    private double allMarksSum = 0;
    private int emptySpace = 0;


    public StudentsGrades(int[] _marks) {
        this.marks = _marks;
        for(int i = 0; i < this.marks.length; i++) {
            if(marks[i] >= 0 && marks[i] <= 100) {
                allMarks++;
                if (marks[i] > maxGrade) {
                    maxGrade = marks[i];
                }
                if (marks[i] < minGrade) {
                    minGrade = marks[i];
                }
                allMarksSum += marks[i];
                addStud(marks[i]);

            }
        }

        avarageGrade = allMarksSum / allMarks;
        //log(avarageGrade);
        //log(marks[3]);
    }


    public void addGrade(int grade) {
        if(grade >= 0 && grade <= 100) {
            if (emptySpace == 0) {
                emptySpace = 5;
                marks = Arrays.copyOf(marks, marks.length + emptySpace); //new int[marks.length + emptySpace];
                //System.arraycopy(marks, 0, buffArr, 0, marks.length);
                //marks = buffArr;
                for (int i = marks.length - emptySpace; i < marks.length; i++) {
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

    public double getMaxGrade() {
        return this.maxGrade;
    }

    public double getMinGrade() {
        return this.minGrade;
    }

    public double getAvarageGrade() {
        return this.avarageGrade;
    }

    public int getUpAvarage() {
        int count = 0;
        for (int mark :
                marks) {
            if(mark > avarageGrade) count++;
        }
        return count;
    }

    public int getLowAvarage() {
        int count = 0;
        for (int mark :
                marks) {
            if(mark < avarageGrade) count++;
        }
        return count;
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

    public String getAllMarks() {
        String s = "[";
        for(int i = 0; i < marks.length; i++) {
            if(marks[i] != -1) {
                if (marks.length - i - emptySpace - 1 == 0) s += marks[i];
                else s += marks[i] + ", ";
            }
        }
        return s + "]";
    }

    private void checkMinMax(int i) {
        if(i > maxGrade) maxGrade = i;
        if(i < minGrade) minGrade = i;
    }

    private void addStud(int i) {
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

    private void logArr(int[] obj) {
        for(int i = 0; i < obj.length; i++) {
            log(obj[i]);
        }
    }

}
