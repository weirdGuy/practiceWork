package io.mageron;

/**
 * io.mageron by Molod
 * 31.01.2017
 */
public interface StudentsGradesInterface<T extends Number> {

    void addGrade(T grade);

    T getMaxGrade();

    T getMinGrade();

    double getAvarageGrade();

    String getAllMarks();

}
