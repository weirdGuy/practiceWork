package io.weirdguy.practice.sorters;

import io.weirdguy.practice.SortStrategy;

import java.util.Comparator;

/**
 * io.weirdguy.practice.sorters by laiko in practiceWork
 * Created on 08.02.2017
 */
public class SelectionSort<T> implements SortStrategy<T> {

    private String name = "Selection Sort";

    @Override
    public void sortAsc(Comparable<T>[] a) {
        for(int i = 0; i < a.length; i++) {

            int minIndex = i;

            for(int j = i + 1; j < a.length; j++) {
                if(a[j].compareTo((T) a[minIndex]) < 0) {
                    minIndex = j;
                }
            }

            exch(a, i, minIndex);
        }
    }

    @Override
    public void sortDesc(Comparable<T>[] a) {
        for(int i = 0; i < a.length; i++) {

            int minIndex = i;

            for(int j = i + 1; j < a.length; j++) {
                if(a[j].compareTo((T) a[minIndex]) > 0) {
                    minIndex = j;
                }
            }

            exch(a, i, minIndex);
        }
    }

    @Override
    public void sortAsc(Comparable<T>[] a, Comparator<T> comparator) {
        for(int i = 0; i < a.length; i++) {

            int minIndex = i;

            for(int j = i + 1; j < a.length; j++) {
                if(comparator.compare((T) a[j], (T) a[minIndex]) < 0) {
                    minIndex = j;
                }
            }

            exch(a, i, minIndex);
        }
    }

    @Override
    public void sortDesc(Comparable<T>[] a, Comparator<T> comparator) {
        for(int i = 0; i < a.length; i++) {

            int minIndex = i;

            for(int j = i + 1; j < a.length; j++) {
                if(comparator.compare((T) a[j], (T) a[minIndex]) > 0) {
                    minIndex = j;
                }
            }

            exch(a, i, minIndex);
        }
    }

        @Override
        public String getName() {
            return this.name;
        }

}