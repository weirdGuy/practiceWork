package io.weirdguy.test;

import io.weirdguy.practice.sorters.CombSort;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * io.weirdguy.test by laiko in practiceWork
 * Created on 28.02.2017
 */
public class CombSortTester extends SortStrategyUnitTester{

    @BeforeClass
    public static void setSortStrategy(){
        mySorter.setCurrentSortStrategy(new CombSort());
    }

    @Override
    @Test
    public void testSortAscNoComparator() {
        mySorter.sortAsc(testDataCopy);
        assertTrue(isSortedAsc(testDataCopy));
        System.out.println(mySorter.getName() + " -- works");
    }

    @Override
    @Test
    public void testSortDescNoComparator() {
        mySorter.sortDesc(testDataCopy);
        assertTrue(isSortedDesc(testDataCopy));
        System.out.println(mySorter.getName() + " -- works");
    }

    @Override
    @Test
    public void testSortAscWithComparator() {
        mySorter.sortAsc(testDataCopy, comparator);
        assertTrue(isSortedAsc(testDataCopy, comparator));
        System.out.println(mySorter.getName() + " -- works");
    }

    @Override
    @Test
    public void testSortDescWithComparator() {
        mySorter.sortDesc(testDataCopy, comparator);
        assertTrue(isSortedDesc(testDataCopy, comparator));
        System.out.println(mySorter.getName() + " -- works");
    }
}
