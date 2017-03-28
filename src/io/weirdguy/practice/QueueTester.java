package io.weirdguy.practice;

/**
 * io.weirdguy.practice by laiko in practiceWork
 * Created on 28.03.2017
 */
public class QueueTester {

    static Queue<Integer> queue;
    static Queue<Integer> noNullQueue;

    public static void main(String[] args) {
        queue = new Queue<Integer>(-1, true);
        noNullQueue = new Queue<>(10, false);

        log("----------Tests With Exceptions----------");
        addWithException();
        noNullQueue = new Queue<>(10, false);
        log("----------Element Exception----------");
        elementWithException();
        log("----------Remove Exception----------");
        removeWithException();
        log("----------Offer Exception----------");
        offerWithException();
        log("----------Exceptions Done----------");

        log(" ");

        log("----------Tests----------");
        additionTester();
        log("----------Element----------");
        elementTester();
        log("----------Offer----------");
        offerTester();
        log("----------Poll----------");
        pollTester();
        log("----------Remove----------");
        removeTester();
        log("----------Peek----------");
        peekTester();
        log("----------Empty----------");
        emptyTester();
        log("----------Search----------");
        searchTester();
        log("----------Done----------");

    }


    public static void additionTester() {
        for (int i = 0; i < 20; i++)
            log(queue.add(new Integer(i)));

        log(queue.toString());
    }

    public static void elementTester() {
        log(queue.element());
        log(queue.toString());
    }

    public static void offerTester() {
        for(int i = 20; i < 30; i++)
            log(queue.offer(new Integer(i)));

        log(queue.toString());
    }

    public static void pollTester() {
        for(int i = 0; i < 10; i++)
            log(queue.poll());

        log(queue.toString());
    }

    public static void removeTester() {
        for(int i = 0; i < 5; i++)
            log(queue.remove());

        log(queue.toString());
    }

    public static void peekTester() {
        log(queue.peek());

        log(queue.toString());
    }

    public static void emptyTester() {
        log(queue.empty());

        log(queue.toString());
    }

    public static void searchTester() {
        log(queue.search(new Integer(17)));
        log(queue.search(new Integer(600)));

        log(queue.toString());
    }

    public static void addWithException() {
        try {
            noNullQueue.add(null);
        } catch (Exception e) {
            log(e.getClass().getSimpleName());
        }
        log(noNullQueue.toString());
        for(int i = 0; i < 10; i++) noNullQueue.add(new Integer(i));

        try {
            noNullQueue.add(new Integer(11));
        } catch (Exception e) {
            log(e.getClass().getSimpleName());
        }

    }

    public static void elementWithException() {
        try {
            noNullQueue.element();
        } catch (Exception e) {
            log(e.getClass().getSimpleName());
        }
    }

    public static void removeWithException() {
        try {
            noNullQueue.remove();
        } catch (Exception e) {
            log(e.getClass().getSimpleName());
        }
    }

    public static void offerWithException() {
        try {
            noNullQueue.offer(null);
        } catch (Exception e) {
            log(e.getClass().getSimpleName());
        }
    }

    private static void log(Object obj) {
        System.out.println(obj);
    }
}
