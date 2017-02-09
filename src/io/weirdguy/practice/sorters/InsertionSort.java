package io.weirdguy.practice.sorters;

import io.weirdguy.practice.SortStrategy;

import java.util.Comparator;

/**
 * io.weirdguy.practice.sorters by laiko in practiceWork
 * Created on 08.02.2017
 */
public class InsertionSort implements SortStrategy {

    @Override
    public void sortAsc(Comparable[] a) {
        for(int i = 1; i < a.length; i++) {
            for(int j = i; j > 0 && a[j].compareTo(a[j - 1]) < 0; j--) {
                exch(a, j, j - 1);
            }
        }
    }

    @Override
    public void sortDesc(Comparable[] a) {
        for(int i = 1; i < a.length; i++) {
            for(int j = i; j > 0 && a[j].compareTo(a[j - 1]) > 0; j--) {
                exch(a, j, j - 1);
            }
        }
    }

    @Override
    public void sortAsc(Comparable[] a, Comparator comparator) {
        for(int i = 1; i < a.length; i++) {
            for(int j = i; j > 0 && comparator.compare(a[j], a[j - 1]) < 0; j--) {
                exch(a, j, j - 1);
            }
        }
    }

    @Override
    public void sortDesc(Comparable[] a, Comparator comparator) {
        for(int i = 1; i < a.length; i++) {
            for(int j = i; j > 0 && comparator.compare(a[j], a[j - 1]) > 0; j--) {
                exch(a, j, j - 1);
            }
        }
    }
}
