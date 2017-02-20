package io.weirdguy.practice.sorters;

import io.weirdguy.practice.SortStrategy;

import java.util.Comparator;

/**
 * io.weirdguy.practice.sorters by laiko in practiceWork
 * Created on 08.02.2017
 */
public class InsertionSort<T> implements SortStrategy<T> {

    private String name = "Insertion Sort";

    @Override
    public void sortAsc(Comparable<T>[] a) {
        for(int i = 1; i < a.length; i++) {
            for(int j = i; j > 0 && a[j].compareTo((T) a[j - 1]) < 0; j--) {
                exch(a, j, j - 1);
            }
        }
    }

    @Override
    public void sortDesc(Comparable<T>[] a) {
        for(int i = 1; i < a.length; i++) {
            for(int j = i; j > 0 && a[j].compareTo((T) a[j - 1]) > 0; j--) {
                exch(a, j, j - 1);
            }
        }
    }

    @Override
    public void sortAsc(Comparable<T>[] a, Comparator<T> comparator) {
        for(int i = 1; i < a.length; i++) {
            for(int j = i; j > 0 && comparator.compare((T) a[j], (T) a[j - 1]) < 0; j--) {
                exch(a, j, j - 1);
            }
        }
    }

    @Override
    public void sortDesc(Comparable<T>[] a, Comparator<T> comparator) {
        for(int i = 1; i < a.length; i++) {
            for(int j = i; j > 0 && comparator.compare((T) a[j], (T) a[j - 1]) > 0; j--) {
                exch(a, j, j - 1);
            }
        }
    }

    @Override
    public String getName() {
        return this.name;
    }
}
