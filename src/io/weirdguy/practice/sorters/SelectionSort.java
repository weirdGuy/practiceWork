package io.weirdguy.practice.sorters;

import io.weirdguy.practice.SortStrategy;

import java.util.Comparator;

/**
 * io.weirdguy.practice.sorters by laiko in practiceWork
 * Created on 08.02.2017
 */
public class SelectionSort implements SortStrategy {

    @Override
    public void sortAsc(Comparable[] a) {
        for(int i = 0; i < a.length; i++) {

            int minIndex = i;

            for(int j = i + 1; j < a.length; j++) {
                if(a[j].compareTo(a[minIndex]) < 0) {
                    minIndex = j;
                }
            }

            exch(a, i, minIndex);
        }
    }

    @Override
    public void sortDesc(Comparable[] a) {
        for(int i = 0; i < a.length; i++) {

            int minIndex = i;

            for(int j = i + 1; j < a.length; j++) {
                if(a[j].compareTo(a[minIndex]) > 0) {
                    minIndex = j;
                }
            }

            exch(a, i, minIndex);
        }
    }

    @Override
    public void sortAsc(Comparable[] a, Comparator comparator) {
        for(int i = 0; i < a.length; i++) {

            int minIndex = i;

            for(int j = i + 1; j < a.length; j++) {
                if(comparator.compare(a[j], a[minIndex]) < 0) {
                    minIndex = j;
                }
            }

            exch(a, i, minIndex);
        }
    }

    @Override
    public void sortDesc(Comparable[] a, Comparator comparator) {
        for(int i = 0; i < a.length; i++) {

            int minIndex = i;

            for(int j = i + 1; j < a.length; j++) {
                if(comparator.compare(a[j], a[minIndex]) > 0) {
                    minIndex = j;
                }
            }

            exch(a, i, minIndex);
        }
    }
}
