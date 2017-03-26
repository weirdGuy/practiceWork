package io.weirdguy.practice;

/**
 * io.weirdguy.practice by laiko in practiceWork
 * Created on 26.03.2017
 */
public class StackTester {

    private static Stack<Integer> stack;

    public static void main(String[] args) {
        stack = new Stack<Integer>();

        log("------------Tests------------");
        pushTest();
        log("------------Pop------------");
        popTest();
        log("------------Peek------------");
        peekTest();
        log("------------Empty------------");
        emptyTest();
        log("------------Search------------");
        searchTest();
        log("------------Done------------");

    }

    public static void pushTest() {
        for(int i = 0; i < 20; i++) {
            stack.push(new Integer(i));
        }
        log(stack.stackToString());
    }

    public static void popTest() {
        for(int i = 0; i < 5; i++) {
            log(stack.pop());
        }
        log(stack.stackToString());
    }

    public static void peekTest() {
        log(stack.peek());
        log(stack.stackToString());
    }

    public static void emptyTest() {
        log(stack.empty());
        log(stack.stackToString());
    }

    public static void searchTest() {
        log(stack.search(new Integer(8)));
        log(stack.search(new Integer(63)));
        log(stack.stackToString());
    }

    private static void log(Object obj) {
        System.out.println(obj);
    }


}
