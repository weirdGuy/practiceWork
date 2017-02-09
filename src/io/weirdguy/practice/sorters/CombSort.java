package io.weirdguy.practice.sorters;

import io.weirdguy.practice.SortStrategy;

import java.util.Comparator;

/**
 * io.weirdguy.practice.sorters by laiko in practiceWork
 * Created on 08.02.2017
 */
public class CombSort implements SortStrategy {

    @Override
    public void sortAsc(Comparable[] a) {
        int gap = a.length;
        boolean swapped = true;
        while (gap > 1 || swapped) {
            if (gap > 1) {
                gap = (int) (gap / 1.3);
            }
            swapped = false;
            for (int i = 0; i + gap < a.length; i++) {
                if (a[i].compareTo(a[i + gap]) > 0) {
                    exch(a, i, i + gap);
                    swapped = true;
                }
            }
        }
    }

    @Override
    public void sortDesc(Comparable[] a) {
        int gap = a.length;
        boolean swapped = true;
        while (gap > 1 || swapped) {
            if (gap > 1) {
                gap = (int) (gap / 1.3);
            }
            swapped = false;
            for (int i = 0; i + gap < a.length; i++) {
                if (a[i].compareTo(a[i + gap]) < 0) {
                    exch(a, i, i + gap);
                    swapped = true;
                }
            }
        }
    }

    @Override
    public void sortAsc(Comparable[] a, Comparator comparator) {
        int gap = a.length;
        boolean swapped = true;
        while (gap > 1 || swapped) {
            if (gap > 1) {
                gap = (int) (gap / 1.3);
            }
            swapped = false;
            for (int i = 0; i + gap < a.length; i++) {
                if (comparator.compare(a[i], a[i + gap]) > 0) {
                    exch(a, i, i + gap);
                    swapped = true;
                }
            }
        }
    }

    @Override
    public void sortDesc(Comparable[] a, Comparator comparator) {
        int gap = a.length;
        boolean swapped = true;
        while (gap > 1 || swapped) {
            if (gap > 1) {
                gap = (int) (gap / 1.3);
            }
            swapped = false;
            for (int i = 0; i + gap < a.length; i++) {
                if (comparator.compare(a[i], a[i + gap]) < 0) {
                    exch(a, i, i + gap);
                    swapped = true;
                }
            }
        }
    }
}
