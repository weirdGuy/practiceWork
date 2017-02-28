package io.weirdguy.practice.sorters;

import io.weirdguy.practice.SortStrategy;

import java.util.Comparator;

/**
 * io.weirdguy.practice.sorters by laiko in practiceWork
 * Created on 08.02.2017
 */
public class HeapSort<T> implements SortStrategy<T> {

    private String name = "Heap Sort";

    private int order = 1;

    @Override
    public void sortAsc(Comparable<T>[] a) {
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
    public void sortDesc(Comparable<T>[] a) {
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
    public void sortAsc(Comparable<T>[] a, Comparator<T> comparator) {
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
    public void sortDesc(Comparable<T>[] a, Comparator<T> comparator) {
        order = -1;
        int n = a.length;
        heapMake(a, comparator);
        while (n > 0) {
            exch(a, 0, n - 1);
            n--;
            heapify(a, n, 0, comparator);
        }
    }

    @Override
    public String getName() {
        return this.name;
    }

    private void heapMake(Comparable<T>[] a) {
        int n = a.length;
        for(int i = n - 1; i >= 0; i--) {
            heapify(a, n, i);
        }
    }

    private void heapMake(Comparable<T>[] a, Comparator<T> comparator) {
        int n = a.length;
        for(int i = n - 1; i >= 0; i--) {
            heapify(a, n, i, comparator);
        }
    }

    private void heapify(Comparable<T>[] a, int size, int pos) {
        while (2 * pos + 1 < size) {
            int t = 2 * pos + 1;
            if (2 * pos + 2 < size && a[2 * pos + 1].compareTo((T) a[2 * pos + 2]) * order < 0) {
                t = 2 * pos + 2;
            }
            if ( a[pos].compareTo((T) a[t]) * order < 0) {
                exch(a, pos, t);
                pos = t;
            } else {
                break;
            }
        }
    }

    private void heapify(Comparable<T>[] a, int size, int pos, Comparator<T> comparator) {
        while (2 * pos + 1 < size) {
            int t = 2 * pos + 1;
            if (2 * pos + 2 < size && comparator.compare((T) a[2 * pos + 1], (T) a[2 * pos + 2]) * order < 0) {
                t = 2 * pos + 2;
            }
            if (comparator.compare((T) a[pos], (T) a[t]) * order < 0) {
                exch(a, pos, t);
                pos = t;
            } else {
                break;
            }
        }
    }
}
