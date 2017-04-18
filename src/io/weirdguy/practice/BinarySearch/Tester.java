package io.weirdguy.practice.BinarySearch;

import java.util.LinkedList;


public class Tester {
    public static void main(String arg[]){
        BinarySearchTree b = new BinarySearchTree();
        LinkedList<Integer> list = new LinkedList<>();
        b.add(3);b.add(8);
        b.add(1);b.add(4);b.add(6);b.add(2);b.add(10);b.add(9);
        b.add(20);b.add(25);b.add(15);b.add(16);
        log("Original Tree : ");
        log(b);
        log("");
        log("Check whether Node with value 4 exists : " + b.contains(4));
        log("Delete Node with no children (2) : " + b.remove(2));
        log(b);
        log("Delete Node with one child (4) : " + b.remove(4));
        log(b);
        log("Delete Node with Two children (10) : " + b.remove(10));
        log(b);

        list = b.getElementsAsc();
        log(list);

        list = b.getElementsDesc();
        log(list);
    }

    private static void log(Object obj) {
        System.out.println(obj);
    }
}