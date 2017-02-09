package io.weirdguy.practice;

import io.weirdguy.practice.sorters.*;

import java.util.Arrays;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        Item[] items = new Item[10];

        SortStrategy[] sorters = new SortStrategy[]{new CombSort(), new HeapSort(),
                new InsertionSort(), new MergeSort(), new QuickSort(), new SelectionSort(), new ShellSort()};

        Random rn = new Random();
        int n = 100 - 1 + 1;

        for(int i = 0; i < items.length; i++) {
            items[i] = new Item(rn.nextInt() % n, rn.nextInt() % n, "RGB" + rn.nextInt() % n + "6" + i);
        }
        StrategyContext sorter = new StrategyContext(new BubbleSort());

        Item[] copy = Arrays.copyOf(items, items.length);

        log(Arrays.toString(items));

        for (SortStrategy s:
             sorters) {
            sorter.changeStrategy(s);
            sorter.sortAsc(items);
            log(Arrays.toString(items));
            items = Arrays.copyOf(copy, copy.length);
        }

    }

    private static void log(Object obj) {
        System.out.println(obj);
    }
    private static void logArr(Object[] objects) {
        for(int i = 0; i < objects.length; i++) {
            log(objects[i]);
        }
    }
}
