package io.weirdguy.practice;

import java.util.Comparator;

/**
 * io.weirdguy.practice by laiko in practiceWork
 * Created on 08.02.2017
 */
public interface SortStrategy {

    void sortAsc(Comparable[] a);

    void sortDesc(Comparable[] a);

    void sortAsc(Comparable[] a, Comparator comparator);

    void sortDesc(Comparable[] a, Comparator comparator);

    default void exch(Comparable[] a, int i, int j) {
        Comparable swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

}
