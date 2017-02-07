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

    public static <T> void bubbleSort(Comparable<T>[] a) {
        for(int i = 0; i < a.length - 1; i++) {
            for(int j = 1; j < a.length - i; j++) {
                if(a[j].compareTo((T) a[j - 1]) < 0) {
                    exch(a, j, j - 1);
                }
            }
        }
    }

    public static <T> void bubbleSort(Comparable<T>[] a, Comparator<T> comparator) {
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

}
