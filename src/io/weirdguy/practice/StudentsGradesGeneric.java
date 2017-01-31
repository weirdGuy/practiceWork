package io.weirdguy.practice;

/**
 * Created by laiko on 25.01.2017.
 */
public interface StudentsGradesGeneric<T extends Number> {

    void addGrade(T grade);

    T getMaxGrade();

    T getMinGrade();

    T getAvarageGrade();

    String getAllMarks();

}
