package io.weirdguy.practice;

import java.util.Comparator;

/**
 * io.weirdguy.practice by laiko in practiceWork
 * Created on 03.02.2017
 */
public class Item implements Comparable<Item>{

    private int size;
    private int weight;
    private String color;

    public static final Comparator<Item> BY_WEIGHT = new ByWeight();
    public static final Comparator<Item> BY_COLOR = new ByColor();

    public Item(int size, int weight, String color) {

        this.size = size;
        this.weight = weight;
        this.color = color;

    }

    @Override
    public int compareTo(Item o) {
        return this.size - o.size;
    }

    @Override
    public String toString() {
        return "{ size: " + size + ", weight: " + weight + " }";
    }

    private static class ByWeight implements Comparator<Item> {
        @Override
        public int compare(Item o1, Item o2) {
            return o1.weight - o2.weight;
        }

    }

    private static class ByColor implements Comparator<Item> {
        @Override
        public int compare(Item o1, Item o2) {
            return o1.color.compareToIgnoreCase(o2.color);
        }
    }
}
