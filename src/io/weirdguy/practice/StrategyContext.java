package io.weirdguy.practice;

import java.util.Comparator;

/**
 * io.weirdguy.practice by laiko in practiceWork
 * Created on 08.02.2017
 */
public class StrategyContext<T> {

    SortStrategy<T> currentSortStrategy;

    public void setCurrentSortStrategy(SortStrategy<T> strategy) {
        this.currentSortStrategy = strategy;
    }

    public void sortAsc(Comparable<T>[] a) {
        currentSortStrategy.sortAsc(a);
    }

    public void sortDesc(Comparable<T>[] a) {
        currentSortStrategy.sortDesc(a);
    }

    public void sortAsc(Comparable<T>[] a, Comparator<T> comparator) {
        currentSortStrategy.sortAsc(a, comparator);
    }

    public void sortDesc(Comparable<T>[] a, Comparator<T> comparator) {
        currentSortStrategy.sortDesc(a, comparator);
    }

    public String getName() {
        return currentSortStrategy.getName();
    }

}
