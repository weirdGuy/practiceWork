package io.weirdguy.practice;


public class Tester {
    private static BinaryTreeArray<Integer> bta;

    public static void main(String[] args) {
        log("START TEST 1:");
        test1();
        log("START TEST 2:");
        test2();
    }

    private static void test1(){
        bta = new BinaryTreeArray<>(new Integer[10000],1);

        log(bta.addLeftSonAt(1, 2));
        log(bta.addRightSonAt(1, 3));
        log(bta.addLeftSonAt(2, 4));
        log(bta.addRightSonAt(2, 5));
        log(bta.addLeftSonAt(3, 6));
        log(bta.addLeftSonAt(3, 2));
        log(bta.addRightSonAt(3, 7));
        log(bta.addLeftSonAt(4, 8));
        log(bta.addRightSonAt(5, 9));
        log(bta.addRightSonAt(5, 1));

        log(bta);
        bta.remove(7);

        log("after remove element 7");
        log(bta);
    }

    private static void test2(){
        BinaryTreeLinkedList<Integer> btll = new BinaryTreeLinkedList<>(1);

        btll.addLeftSonAt(1,2);
        btll.addRightSonAt(1,3);
        btll.addLeftSonAt(2,4);
        btll.addRightSonAt(2,5);
        btll.addLeftSonAt(3,6);
        btll.addRightSonAt(3,7);
        btll.addLeftSonAt(4,8);
        btll.addRightSonAt(4,9);

        log(btll);
        btll.remove(7);

        log("after remove element 7");
        log(btll);
    }

    private static void log(Object obj) {
        System.out.println(obj);
    }
}
