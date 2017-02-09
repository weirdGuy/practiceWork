package io.weirdguy.practice.sorters;

import io.weirdguy.practice.SortStrategy;

import java.util.Comparator;

/**
 * io.weirdguy.practice.sorters by laiko in practiceWork
 * Created on 09.02.2017
 */
public class MergeSort implements SortStrategy{

    int order = 1;

    @Override
    public void sortAsc(Comparable[] a) {
        order = 1;
        Comparable[] tmp = new Comparable[a.length];
        mergeSort(a, tmp,  0,  a.length - 1);
    }

    @Override
    public void sortDesc(Comparable[] a) {
        order = -1;
        Comparable[] tmp = new Comparable[a.length];
        mergeSort(a, tmp,  0,  a.length - 1);
    }

    @Override
    public void sortAsc(Comparable[] a, Comparator comparator) {
        Comparable[] tmp = new Comparable[a.length];
        mergeSort(a, tmp,  0,  a.length - 1, comparator);
    }

    @Override
    public void sortDesc(Comparable[] a, Comparator comparator) {
        Comparable[] tmp = new Comparable[a.length];
        mergeSort(a, tmp,  0,  a.length - 1, comparator);
    }

    private void mergeSort(Comparable[] a, Comparable[] tmp, int left, int right) {
        if( left < right )
        {
            int center = (left + right) / 2;
            mergeSort(a, tmp, left, center);
            mergeSort(a, tmp, center + 1, right);
            merge(a, tmp, left, center + 1, right);
        }
    }

    private void mergeSort(Comparable[] a, Comparable[] tmp, int left, int right, Comparator comparator) {
        if( left < right )
        {
            int center = (left + right) / 2;
            mergeSort(a, tmp, left, center, comparator);
            mergeSort(a, tmp, center + 1, right, comparator);
            merge(a, tmp, left, center + 1, right, comparator);
        }
    }

    private void merge(Comparable[] a, Comparable[] tmp, int left, int right, int rightEnd, Comparator comparator) {
        int leftEnd = right - 1;
        int k = left;
        int num = rightEnd - left + 1;

        while(left <= leftEnd && right <= rightEnd)
            if(comparator.compare(a[left], a[right]) <= 0)
                tmp[k++] = a[left++];
            else
                tmp[k++] = a[right++];

        while(left <= leftEnd)
            tmp[k++] = a[left++];

        while(right <= rightEnd)
            tmp[k++] = a[right++];

        for(int i = 0; i < num; i++, rightEnd--)
            a[rightEnd] = tmp[rightEnd];
    }

    private void merge(Comparable[] a, Comparable[] tmp, int left, int right, int rightEnd) {
        int leftEnd = right - 1;
        int k = left;
        int num = rightEnd - left + 1;

        while(left <= leftEnd && right <= rightEnd)
            if(a[left].compareTo(a[right]) * order <= 0)
                tmp[k++] = a[left++];
            else
                tmp[k++] = a[right++];

        while(left <= leftEnd)
            tmp[k++] = a[left++];

        while(right <= rightEnd)
            tmp[k++] = a[right++];

        for(int i = 0; i < num; i++, rightEnd--)
            a[rightEnd] = tmp[rightEnd];
    }

}
