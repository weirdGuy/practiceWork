package io.weirdguy.practice.sorters;

import io.weirdguy.practice.SortStrategy;
import io.weirdguy.practice.StrategyContext;

import java.util.Comparator;

/**
 * io.weirdguy.practice.sorters by laiko in practiceWork
 * Created on 08.02.2017
 */
public class BubbleSort<T> implements SortStrategy<T> {

    private String name = "Bubble Sort";

    @Override
    public void sortDesc(Comparable<T>[] a) {
        for(int i = 0; i < a.length - 1; i++) {
            for(int j = 1; j < a.length - i; j++) {
                if(a[j].compareTo((T) a[j - 1]) > 0) {
                    exch(a, j, j - 1);
                }
            }
        }
    }

    @Override
    public void sortAsc(Comparable<T>[] a) {
        for(int i = 0; i < a.length - 1; i++) {
            for(int j = 1; j < a.length - i; j++) {
                if(a[j].compareTo((T) a[j - 1]) < 0) {
                    exch(a, j, j - 1);
                }
            }
        }
    }


    @Override
    public void sortAsc(Comparable<T>[] a, Comparator<T> comparator) {
        for(int i = 0; i < a.length - 1; i++) {
            for(int j = 1; j < a.length - i; j++) {
                if(comparator.compare((T) a[j], (T) a[j - 1]) < 0) {
                    exch(a, j, j - 1);
                }
            }
        }
    }

    @Override
    public void sortDesc(Comparable<T>[] a, Comparator<T> comparator) {
        for(int i = 0; i < a.length - 1; i++) {
            for(int j = 1; j < a.length - i; j++) {
                if(comparator.compare((T) a[j], (T) a[j - 1]) > 0) {
                    exch(a, j, j - 1);
                }
            }
        }
    }

    @Override
    public String getName() {
        return this.name;
    }
}
