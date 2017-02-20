package io.weirdguy.practice.sorters;

import io.weirdguy.practice.SortStrategy;

import java.util.Comparator;

/**
 * io.weirdguy.practice.sorters by laiko in practiceWork
 * Created on 09.02.2017
 */
public class QuickSort<T> implements SortStrategy<T> {

    private String name = "Quick Sort";

    private int order = 1;

    @Override
    public void sortAsc(Comparable<T>[] a) {
        order = 1;
        doQuickSort(a, 0, a.length - 1);
    }

    @Override
    public void sortDesc(Comparable<T>[] a) {
        order = -1;
        doQuickSort(a, 0, a.length - 1);
    }

    @Override
    public void sortAsc(Comparable<T>[] a, Comparator<T> comparator) {
        order = 1;
        doQuickSort(a, 0, a.length - 1, comparator);
    }

    @Override
    public void sortDesc(Comparable<T>[] a, Comparator<T> comparator) {
        order = -1;
        doQuickSort(a, 0, a.length - 1, comparator);
    }

    @Override
    public String getName() {
        return this.name;
    }

    private void doQuickSort(Comparable<T>[] a, int start, int end) {
        if(start >= end)
            return;
        int i = start, j = end;
        int cur = (i + j) / 2;
        while (i < j) {
            while (i < cur && a[i].compareTo((T) a[cur]) * order < 0) {
                i++;
            }

            while (j > cur && a[j].compareTo((T) a[cur]) * order >= 0) {
                j--;
            }

            if(i < j) {
                exch(a, i, j);
                if(i == cur) cur = j;
                else if(j == cur) cur = i;
            }
        }
        doQuickSort(a, start, cur);
        doQuickSort(a, cur + 1, end);
    }

    private void doQuickSort(Comparable<T>[] a, int start, int end, Comparator<T> comparator) {
        if(start >= end)
            return;
        int i = start, j = end;
        int cur = (i + j) / 2;
        while (i < j) {
            while (i < cur && comparator.compare((T) a[i], (T) a[cur]) * order < 0) {
                i++;
            }

            while (j > cur && comparator.compare((T) a[j], (T) a[cur]) * order > 0) {
                j--;
            }

            if(i < j) {
                exch(a, i, j);
                if(i == cur) cur = j;
                else if(j == cur) cur = i;
            }
        }
        doQuickSort(a, start, cur, comparator);
        doQuickSort(a, cur + 1, end, comparator);
    }

}
