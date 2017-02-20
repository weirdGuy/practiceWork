package io.weirdguy.practice;

import java.util.Comparator;

/**
 * io.weirdguy.practice by laiko in practiceWork
 * Created on 08.02.2017
 */
public interface SortStrategy<T> {

    void sortAsc(Comparable<T>[] a);

    void sortDesc(Comparable<T>[] a);

    void sortAsc(Comparable<T>[] a, Comparator<T> comparator);

    void sortDesc(Comparable<T>[] a, Comparator<T> comparator);

    String getName();

    default void exch(Comparable<T>[] a, int i, int j) {
        Comparable<T> swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

}
