package io.weirdguy.practice;

import java.util.Arrays;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        Item[] items = new Item[10];

        Random rn = new Random();
        int n = 100 - 1 + 1;

        for(int i = 0; i < items.length; i++) {
            items[i] = new Item(rn.nextInt() % n, rn.nextInt() % n, rn.nextInt() % n);
        }

        log(Arrays.toString(items));

        Sorter.shellSort(items);

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
