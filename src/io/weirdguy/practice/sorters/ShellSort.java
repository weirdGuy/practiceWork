package io.weirdguy.practice.sorters;

import io.weirdguy.practice.SortStrategy;

import java.util.Comparator;

/**
 * io.weirdguy.practice.sorters by laiko in practiceWork
 * Created on 08.02.2017
 */
public class ShellSort<T> implements SortStrategy<T> {

    private String name = "Shell Sort";

    @Override
    public void sortAsc(Comparable<T>[] a) {
        int increment = a.length / 2;
        while (increment > 0) {
            for (int i = increment; i < a.length; i++) {
                int j = i;
                Comparable<T> temp = a[i];
                while (j >= increment && a[j - increment].compareTo((T) temp) > 0) {
                    exch(a, j, j - increment);
                    j = j - increment;
                }
                a[j] = temp;
            }
            if (increment == 2) {
                increment = 1;
            } else {
                increment *= (4.0 / 9);
            }
        }
    }

    @Override
    public void sortDesc(Comparable<T>[] a) {
        int increment = a.length / 2;
        while (increment > 0) {
            for (int i = increment; i < a.length; i++) {
                int j = i;
                Comparable<T> temp = a[i];
                while (j >= increment && a[j - increment].compareTo((T) temp) < 0) {
                    exch(a, j, j - increment);
                    j = j - increment;
                }
                a[j] = temp;
            }
            if (increment == 2) {
                increment = 1;
            } else {
                increment *= (4.0 / 9);
            }
        }
    }

    @Override
    public void sortAsc(Comparable<T>[] a, Comparator<T> comparator) {
        int increment = a.length / 2;
        while (increment > 0) {
            for (int i = increment; i < a.length; i++) {
                int j = i;
                while (j >= increment && comparator.compare((T) a[j - increment], (T) a[i]) > 0) {
                    exch(a, j, j - increment);
                    j = j - increment;
                }
                a[j] = a[i];
            }
            if (increment == 2) {
                increment = 1;
            } else {
                increment *= (4.0 / 9);
            }
        }
    }

    @Override
    public void sortDesc(Comparable<T>[] a, Comparator<T> comparator) {
        int increment = a.length / 2;
        while (increment > 0) {
            for (int i = increment; i < a.length; i++) {
                int j = i;
                while (j >= increment && comparator.compare((T) a[j - increment], (T) a[i]) < 0) {
                    exch(a, j, j - increment);
                    j = j - increment;
                }
                a[j] = a[i];
            }
            if (increment == 2) {
                increment = 1;
            } else {
                increment *= (4.0 / 9);
            }
        }
    }

    @Override
    public String getName() {
        return this.name;
    }
}
