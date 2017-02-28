package io.weirdguy.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
/**
 * io.weirdguy.test by laiko in practiceWork
 * Created on 28.02.2017
 */

@RunWith(Suite.class)
@SuiteClasses({ BubbleSortTester.class,
        CombSortTester.class,
        HeapSortTester.class,
        InsertionSortTester.class,
        MergeSortTester.class,
        QuickSortTester.class,
        SelectionSortTester.class,
        ShellSortTester.class
})
public class AllUnitTests {
}
