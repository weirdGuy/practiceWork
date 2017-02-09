package io.weirdguy.practice;

import io.weirdguy.practice.sorters.MergeSort;

import java.util.Arrays;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        Item[] items = new Item[10];

        Random rn = new Random();
        int n = 100 - 1 + 1;

        for(int i = 0; i < items.length; i++) {
            items[i] = new Item(rn.nextInt() % n, rn.nextInt() % n, "RGB" + rn.nextInt() % n + "6" + i);
        }
        StrategyContext sorter = new StrategyContext(new MergeSort());

        log(Arrays.toString(items));

        sorter.sortAsc(items);
        //Sorter.quickSort(items);

        log(Arrays.toString(items));


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
