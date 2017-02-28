package io.weirdguy.practice;

import io.weirdguy.practice.sorters.*;

import princeton.lib.*;

import java.io.File;

public class Main {

    public static void main(String[] args) {

        Item[] items = new Item[10];

        SortStrategy[] sorters = new SortStrategy[]{new CombSort<Integer>(), new HeapSort<Integer>(),
                new InsertionSort<Integer>(), new MergeSort<Integer>(), new QuickSort<Integer>(), new SelectionSort<Integer>(), new ShellSort<Integer>()};

        File[] files = new File[]{new File("input1024.txt"), new File("input2048.txt"), new File("input4096.txt"),
                new File("input8192.txt"), new File("input16384.txt"), new File("input32768.txt")};

        StrategyContext<Integer> sorter = new StrategyContext<>();

        sorter.setCurrentSortStrategy(new BubbleSort());

        for(int i = 0; i < sorters.length; i++) {
            for(int j = 0; j < files.length; j++) {
                int input[] = new princeton.lib.In(files[j].getName()).readAllInts();
                Integer fileItems[] = new Integer[input.length];

                for (int k = 0; k < input.length; k++) {
                    fileItems[k] = input[k];
                }

                Stopwatch stopwatch = new Stopwatch();
                sorter.sortDesc(fileItems);
                log("Strategy: "+ sorter.getName() +"; File: " + files[j].getName() +
                        "; Sorting completed in: " + stopwatch.elapsedTime());
            }
            sorter.setCurrentSortStrategy(sorters[i]);
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
