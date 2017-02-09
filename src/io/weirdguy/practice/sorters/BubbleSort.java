package io.weirdguy.practice.sorters;

import io.weirdguy.practice.SortStrategy;

import java.util.Comparator;

/**
 * io.weirdguy.practice.sorters by laiko in practiceWork
 * Created on 08.02.2017
 */
public class BubbleSort implements SortStrategy {

    @Override
    public  void sortDesc(Comparable[] a) {
        for(int i = 0; i < a.length - 1; i++) {
            for(int j = 1; j < a.length - i; j++) {
                if(a[j].compareTo(a[j - 1]) < 0) {
                    exch(a, j, j - 1);
                }
            }
        }
    }

    @Override
    public void sortAsc(Comparable[] a) {
        for(int i = 0; i < a.length - 1; i++) {
            for(int j = 1; j < a.length - i; j++) {
                if(a[j].compareTo(a[j - 1]) > 0) {
                    exch(a, j, j - 1);
                }
            }
        }
    }


    @Override
    public void sortAsc(Comparable[] a, Comparator comparator) {
        for(int i = 0; i < a.length - 1; i++) {
            for(int j = 1; j < a.length - i; j++) {
                if(comparator.compare(a[j], a[j - 1]) < 0) {
                    exch(a, j, j - 1);
                }
            }
        }
    }

    @Override
    public void sortDesc(Comparable[] a, Comparator comparator) {
        for(int i = 0; i < a.length - 1; i++) {
            for(int j = 1; j < a.length - i; j++) {
                if(comparator.compare(a[j], a[j - 1]) > 0) {
                    exch(a, j, j - 1);
                }
            }
        }
    }
}
