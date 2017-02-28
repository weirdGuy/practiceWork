package io.weirdguy.test;

/**
 * io.weirdguy.test by laiko in practiceWork
 * Created on 28.02.2017
 */

import io.weirdguy.practice.Item;
import io.weirdguy.practice.StrategyContext;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public abstract class SortStrategyUnitTester {

    static StrategyContext mySorter;
    static Comparable<Item>[] testData;
    static Comparable<Item>[] testDataCopy;
    static Comparator<Item> comparator;

    protected boolean isSortedAsc(Comparable[] arr) {
        boolean result = true;

        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i].compareTo(arr[i + 1]) > 0) {
                result = false;
                break;
            }
        }

        return result;
    }

    protected boolean isSortedDesc(Comparable[] arr) {
        boolean result = true;

        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i].compareTo(arr[i + 1]) < 0) {
                result = false;
                break;
            }
        }

        return result;
    }

    protected boolean isSortedAsc(Comparable[] arr, Comparator comparator) {
        boolean result = true;

        for (int i = 0; i < arr.length - 1; i++) {
            if (comparator.compare(arr[i], arr[i + 1]) > 0) {
                result = false;
                break;
            }
        }

        return result;
    }

    protected boolean isSortedDesc(Comparable[] arr, Comparator comparator) {
        boolean result = true;

        for (int i = 0; i < arr.length - 1; i++) {
            if (comparator.compare(arr[i], arr[i + 1]) < 0) {
                result = false;
                break;
            }
        }

        return result;
    }

    @BeforeClass
    public static void initialSetUp() {

        Random rn = new Random();

        mySorter = new StrategyContext();

        testData = new Item[10];

        for(int i = 0; i < testData.length; i++) {
            testData[i] = new Item(rn.nextInt() % 100, rn.nextInt() % 100, "RGB" + rn.nextInt() % 50);
        }

        comparator = Item.BY_WEIGHT;
    }

    @Before
    public void setup() {
        testDataCopy = Arrays.copyOf(testData, testData.length);
    }

    @Test
    abstract void testSortAscNoComparator();

    @Test
    abstract void testSortDescNoComparator();

    @Test
    abstract void testSortAscWithComparator();

    @Test
    abstract void testSortDescWithComparator();

}
