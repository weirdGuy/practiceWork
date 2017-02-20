package io.weirdguy.practice;

import java.util.Comparator;

/**
 * io.weirdguy.practice by laiko in practiceWork
 * Created on 03.02.2017
 */
public class Sorter {

    private static <T> boolean lessThan(Comparable<T> v, Comparable<T> w) {
        return v.compareTo((T) w) < 0;
    }

    private static <T> void exch(Comparable<T>[] a, int i, int j) {
        Comparable<T> swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    private static <T> boolean isSorted(Comparable<T>[] a) {
        for(int i = 1; i < a.length; i++) {
            if(lessThan(a[i], a[i - 1]))return false;
        }
        return true;
    }

    public <T> void bubbleSort(Comparable<T>[] a) {
        for(int i = 0; i < a.length - 1; i++) {
            for(int j = 1; j < a.length - i; j++) {
                if(a[j].compareTo((T) a[j - 1]) < 0) {
                    exch(a, j, j - 1);
                }
            }
        }
    }

    public <T> void bubbleSort(Comparable<T>[] a, Comparator<T> comparator) {
        for(int i = 0; i < a.length - 1; i++) {
            for(int j = 1; j < a.length - i; j++) {
                if(comparator.compare((T) a[j], (T) a[j - 1]) < 0) {
                    exch(a, j, j - 1);
                }
            }
        }
    }

    public static <T> void selectionSort(Comparable<T>[] a) {
        for(int i = 0; i < a.length; i++) {

            int minIndex = i;

            for(int j = i + 1; j < a.length; j++) {
                if(a[j].compareTo((T)a[minIndex]) < 0) {
                    minIndex = j;
                }
            }

            exch(a, i, minIndex);
        }
    }

    public static <T> void selectionSort(Comparable<T>[] a, Comparator<T> comparator) {
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

    public static <T> void insertionSort(Comparable<T>[] a) {
        for(int i = 1; i < a.length; i++) {
            for(int j = i; j > 0 && a[j].compareTo((T) a[j - 1]) < 0; j--) {
                exch(a, j, j - 1);
            }
        }
    }

    public static <T> void insertionSort(Comparable<T>[] a, Comparator<T> comparator) {
        for(int i = 1; i < a.length; i++) {
            for(int j = i; j > 0 && comparator.compare((T) a[j], (T)a[j - 1]) < 0; j--) {
                exch(a, j, j - 1);
            }
        }
    }

    public static <T> void combSort(Comparable<T>[] a) {
        int gap = a.length;
        boolean swapped = true;
        while (gap > 1 || swapped) {
            if (gap > 1) {
                gap = (int) (gap / 1.3);
            }
            swapped = false;
            for (int i = 0; i + gap < a.length; i++) {
                if (a[i].compareTo((T) a[i + gap]) > 0) {
                    exch(a, i, i + gap);
                    swapped = true;
                }
            }
        }
    }

    public static <T> void combSort(Comparable<T>[] a, Comparator<T> comparator) {
        int gap = a.length;
        boolean swapped = true;
        while (gap > 1 || swapped) {
            if (gap > 1) {
                gap = (int) (gap / 1.3);
            }
            swapped = false;
            for (int i = 0; i + gap < a.length; i++) {
                if (comparator.compare((T) a[i], (T)a[i + gap]) > 0) {
                    exch(a, i, i + gap);
                    swapped = true;
                }
            }
        }
    }

    public static <T> void shellSort(Comparable<T>[] a) {
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

    public static <T> void shellSort(Comparable<T>[] a, Comparator<T> comparator) {
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

    public static <T> void heapSort(Comparable<T>[] a) {
        int n = a.length;
        heapMake(a);
        while (n > 0) {
            exch(a, 0, n - 1);
            n--;
            heapify(a, n, 0);
        }

    }

    public static <T> void heapSort(Comparable<T>[] a, Comparator<T> comparator) {
        int n = a.length;
        heapMake(a, comparator);
        while (n > 0) {
            exch(a, 0, n - 1);
            n--;
            heapify(a, n, 0, comparator);
        }

    }

    private static <T> void heapMake(Comparable<T>[] a) {
        int n = a.length;
        for(int i = n - 1; i >= 0; i--) {
            heapify(a, n, i);
        }
    }

    private static <T> void heapMake(Comparable<T>[] a, Comparator<T> comparator) {
        int n = a.length;
        for(int i = n - 1; i >= 0; i--) {
            heapify(a, n, i, comparator);
        }
    }

    private static <T> void heapify(Comparable<T>[] a, int size, int pos) {
        while (2 * pos + 1 < size) {
            int t = 2 * pos + 1;
            if (2 * pos + 2 < size && a[2 * pos + 1].compareTo((T) a[2 * pos + 2]) < 0) {
                t = 2 * pos + 2;
            }
            if ( a[pos].compareTo((T) a[t]) < 0) {
                exch(a, pos, t);
                pos = t;
            } else {
                break;
            }
        }
    }

    private static <T> void heapify(Comparable<T>[] a, int size, int pos, Comparator<T> comparator) {
        while (2 * pos + 1 < size) {
            int t = 2 * pos + 1;
            if (2 * pos + 2 < size && comparator.compare((T) a[2 * pos + 1], (T) a[2 * pos + 2]) < 0) {
                t = 2 * pos + 2;
            }
            if (comparator.compare((T) a[pos], (T)  a[t]) < 0) {
                exch(a, pos, t);
                pos = t;
            } else {
                break;
            }
        }
    }

    public static <T> void mergeSort(Comparable<T>[] a) {
        Comparable[] tmp = new Comparable[a.length];
        mergeSort(a, tmp,  0,  a.length - 1);
    }

    public static <T> void mergeSort(Comparable<T>[] a, Comparator<T> comparator) {
        Comparable[] tmp = new Comparable[a.length];
        mergeSort(a, tmp,  0,  a.length - 1, comparator);
    }

    private static <T> void mergeSort(Comparable<T>[] a, Comparable<T>[] tmp, int left, int right) {
        if( left < right )
        {
            int center = (left + right) / 2;
            mergeSort(a, tmp, left, center);
            mergeSort(a, tmp, center + 1, right);
            merge(a, tmp, left, center + 1, right);
        }
    }

    private static <T> void mergeSort(Comparable<T>[] a, Comparable<T>[] tmp, int left, int right, Comparator<T> comparator) {
        if( left < right )
        {
            int center = (left + right) / 2;
            mergeSort(a, tmp, left, center, comparator);
            mergeSort(a, tmp, center + 1, right, comparator);
            merge(a, tmp, left, center + 1, right, comparator);
        }
    }

    private static <T> void merge(Comparable<T>[] a, Comparable<T>[] tmp, int left, int right, int rightEnd) {
        int leftEnd = right - 1;
        int k = left;
        int num = rightEnd - left + 1;

        while(left <= leftEnd && right <= rightEnd)
            if(a[left].compareTo((T)a[right]) <= 0)
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

    private static <T> void merge(Comparable<T>[] a, Comparable<T>[] tmp, int left, int right, int rightEnd, Comparator<T> comparator) {
        int leftEnd = right - 1;
        int k = left;
        int num = rightEnd - left + 1;

        while(left <= leftEnd && right <= rightEnd)
            if(comparator.compare((T) a[left], (T)a[right]) <= 0)
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

    public static <T> void quickSort(Comparable<T>[] a) {
        doQuickSort(a, 0, a.length - 1);
    }

    public static <T> void doQuickSort(Comparable<T>[] a, int start, int end) {
        if(start >= end)
            return;
        int i = start, j = end;
        int cur = (i + j) / 2;
        while (i < j) {
            while (i < cur && a[i].compareTo((T) a[cur]) < 0) {
                i++;
            }

            while (j > cur && a[j].compareTo((T) a[cur]) > 0) {
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

}
