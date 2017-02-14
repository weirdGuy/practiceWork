package io.weirdguy.practice;

import java.util.Comparator;

/**
 * io.weirdguy.practice by laiko in practiceWork
 * Created on 08.02.2017
 */
public class StrategyContext {

    SortStrategy currentSortStrategy;

    public StrategyContext(SortStrategy strategy) {
        this.currentSortStrategy = strategy;
    }

    public void changeStrategy(SortStrategy strategy) { this.currentSortStrategy = strategy; }

    public void sortAsc(Comparable[] a) {
        currentSortStrategy.sortAsc(a);
    }

    public void sortDesc(Comparable[] a) {
        currentSortStrategy.sortDesc(a);
    }

    public void sortAsc(Comparable[] a, Comparator comparator) {
        currentSortStrategy.sortAsc(a, comparator);
    }

    public void sordDesc(Comparable[] a, Comparator comparator) {
        currentSortStrategy.sortDesc(a, comparator);
    }

}
