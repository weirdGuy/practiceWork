package io.weirdguy.practice;

import java.util.Arrays;

/**
 * io.weirdguy.practice by laiko in practiceWork
 * Created on 29.01.2017
 */
public class StudentGradesDouble implements StudentsGradesGeneric<Double> {


    private Double[] marks;

    private Double maxGrade = 0.0;
    private Double minGrade = 0.0;

    private Double avarageGrade = 0.0;

    private int exceStud = 0;
    private int wellStud = 0;
    private int goodStud = 0;

    private Double allMarks = 0.0;
    private Double allMarksSum = 0.0;
    private int emptySpace = 0;

    public StudentGradesDouble(double[] _marks) {
        this.marks = Arrays.stream(_marks).boxed().toArray(Double[]::new);
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

    @Override
    public void addGrade(Double grade) {
        if(grade.compareTo(0.0) > 0 && grade.compareTo(100.0) < 0) {
            if (emptySpace == 0) {
                emptySpace = 5;
                marks = Arrays.copyOf(marks, marks.length + emptySpace); //new int[marks.length + emptySpace];
                //System.arraycopy(marks, 0, buffArr, 0, marks.length);
                //marks = buffArr;
                for (int i = marks.length - emptySpace; i < marks.length; i++) {
                    marks[i] = -1.0;
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

    @Override
    public Double getMaxGrade() {
        return this.maxGrade;
    }

    @Override
    public Double getMinGrade() {
        return this.minGrade;
    }

    @Override
    public double getAvarageGrade() {
        return this.avarageGrade;
    }

    public int getUpAvarage() {
        int count = 0;
        for (Double mark :
                marks) {
            if(mark > avarageGrade) count++;
        }
        return count;
    }

    public int getLowAvarage() {
        int count = 0;
        for (Double mark :
                marks) {
            if(mark < avarageGrade) count++;
        }
        return count;
    }

    @Override
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

    private void addStud(Double i) {
        if(i >= 91 && i <= 100) {
            exceStud++;
        } else if(i >= 71 && i <= 90) {
            wellStud++;
        } else if(i >= 60 && i <= 70) {
            goodStud++;
        }
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

    private void checkMinMax(Double i) {
        if(i > maxGrade) maxGrade = i;
        if(i < minGrade) minGrade = i;
    }
}
