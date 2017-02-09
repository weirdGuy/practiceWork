package io.weirdguy.practice.sorters;

import io.weirdguy.practice.SortStrategy;

import java.util.Comparator;

/**
 * io.weirdguy.practice.sorters by laiko in practiceWork
 * Created on 09.02.2017
 */
public class QuickSort implements SortStrategy{

    private int order = 1;

    @Override
    public void sortAsc(Comparable[] a) {
        order = 1;
        doQuickSort(a, 0, a.length - 1);
    }

    @Override
    public void sortDesc(Comparable[] a) {
        order = -1;
        doQuickSort(a, 0, a.length - 1);
    }

    @Override
    public void sortAsc(Comparable[] a, Comparator comparator) {
        order = 1;
        doQuickSort(a, 0, a.length - 1, comparator);
    }

    @Override
    public void sortDesc(Comparable[] a, Comparator comparator) {
        order = -1;
        doQuickSort(a, 0, a.length - 1, comparator);
    }

    public void doQuickSort(Comparable[] a, int start, int end) {
        if(start >= end)
            return;
        int i = start, j = end;
        int cur = (i + j) / 2;
        while (i < j) {
            while (i < cur && a[i].compareTo(a[cur]) * order < 0) {
                i++;
            }

            while (j > cur && a[j].compareTo(a[cur]) * order > 0) {
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

    public void doQuickSort(Comparable[] a, int start, int end, Comparator comparator) {
        if(start >= end)
            return;
        int i = start, j = end;
        int cur = (i + j) / 2;
        while (i < j) {
            while (i < cur && comparator.compare(a[i], a[cur]) * order < 0) {
                i++;
            }

            while (j > cur && comparator.compare(a[j], a[cur]) * order > 0) {
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
