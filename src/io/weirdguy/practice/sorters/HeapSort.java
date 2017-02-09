package io.weirdguy.practice.sorters;

import io.weirdguy.practice.SortStrategy;

import java.util.Comparator;

/**
 * io.weirdguy.practice.sorters by laiko in practiceWork
 * Created on 08.02.2017
 */
public class HeapSort implements SortStrategy {

    private int order = 1;

    @Override
    public void sortAsc(Comparable[] a) {
        order = 1;
        int n = a.length;
        heapMake(a);
        while (n > 0) {
            exch(a, 0, n - 1);
            n--;
            heapify(a, n, 0);
        }
    }

    @Override
    public void sortDesc(Comparable[] a) {
        order = -1;
        int n = a.length;
        heapMake(a);
        while (n > 0) {
            exch(a, 0, n - 1);
            n--;
            heapify(a, n, 0);
        }
    }

    @Override
    public void sortAsc(Comparable[] a, Comparator comparator) {
        order = 1;
        int n = a.length;
        heapMake(a, comparator);
        while (n > 0) {
            exch(a, 0, n - 1);
            n--;
            heapify(a, n, 0, comparator);
        }
    }

    @Override
    public void sortDesc(Comparable[] a, Comparator comparator) {
        order = -1;
        int n = a.length;
        heapMake(a, comparator);
        while (n > 0) {
            exch(a, 0, n - 1);
            n--;
            heapify(a, n, 0, comparator);
        }
    }

    private void heapMake(Comparable[] a) {
        int n = a.length;
        for(int i = n - 1; i >= 0; i--) {
            heapify(a, n, i);
        }
    }

    private void heapMake(Comparable[] a, Comparator comparator) {
        int n = a.length;
        for(int i = n - 1; i >= 0; i--) {
            heapify(a, n, i, comparator);
        }
    }

    private void heapify(Comparable[] a, int size, int pos) {
        while (2 * pos + 1 < size) {
            int t = 2 * pos + 1;
            if (2 * pos + 2 < size && a[2 * pos + 1].compareTo(a[2 * pos + 2]) * order > 0) {
                t = 2 * pos + 2;
            }
            if ( a[pos].compareTo(a[t]) * order > 0) {
                exch(a, pos, t);
                pos = t;
            } else {
                break;
            }
        }
    }

    private void heapify(Comparable[] a, int size, int pos, Comparator comparator) {
        while (2 * pos + 1 < size) {
            int t = 2 * pos + 1;
            if (2 * pos + 2 < size && comparator.compare(a[2 * pos + 1], a[2 * pos + 2]) * order < 0) {
                t = 2 * pos + 2;
            }
            if (comparator.compare(a[pos], a[t]) < 0) {
                exch(a, pos, t);
                pos = t;
            } else {
                break;
            }
        }
    }
}
