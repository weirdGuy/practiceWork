package io.weirdguy.practice;

/**
 * io.weirdguy.practice by laiko in practiceWork
 * Created on 21.03.2017
 */
public class MyLinkedListTester {
    public static void main(String[] args) {
        tester();
    }

    private static void tester() {
        MyLinkedList<Integer> oparations = new MyLinkedList<>();
        MyLinkedList<Integer> plularity1 = new MyLinkedList<>();
        MyLinkedList<Integer> plularity2 = new MyLinkedList<>();
        MyLinkedList<Integer> plularity3 = new MyLinkedList<>();
        MyLinkedList<Integer> plularity4 = new MyLinkedList<>();
        MyLinkedList<Integer> plularity5 = new MyLinkedList<>();
        MyLinkedList<Integer> plularity6 = new MyLinkedList<>();
        MyLinkedList<Integer> plularity7 = new MyLinkedList<>();
        MyLinkedList<Integer> plularity8 = new MyLinkedList<>();

        for (int i = 0; i < 10; i++) {
            plularity1.append(i + 1);
            plularity2.append(-i);
        }
        for (int i = 0; i < 10; i++) {
            plularity3.append(i * 2);
            plularity4.append(i);
            plularity5.append(i+100);
        }
        for (int i = 0; i < 10; i++) {
            plularity6.append(i+10);
            plularity7.append(i-10);
            plularity8.append(i+40);
        }
        System.out.println("START TEST");
        System.out.println();

        System.out.println("1.Union");
        System.out.println();
        System.out.print("Plularuty 1: ");
        System.out.println(plularity1);
        System.out.print("Plularuty 2: ");
        System.out.println(plularity2);
        System.out.println("Plularity 1 + Plularity 2: ");
        System.out.println(oparations.union(plularity1, plularity2));
        System.out.println();

        System.out.println("2.Intersection");
        System.out.println();
        System.out.print("Plularuty 1: ");
        System.out.println(plularity3);
        System.out.print("Plularuty 2: ");
        System.out.println(plularity4);
        System.out.println("Plularity 1 (intersection) Plularity 2: ");
        System.out.println(oparations.intersection(plularity3, plularity4));
        System.out.println();

        System.out.println("3.Difference");
        System.out.println();
        System.out.print("Plularuty 1: ");
        System.out.println(plularity3);
        System.out.print("Plularuty 2: ");
        System.out.println(plularity4);
        System.out.println("Plularity 1 \\ Plularity 2: ");
        System.out.println(oparations.difference(plularity3, plularity4));
        System.out.println();

        System.out.println("4.Merge");
        System.out.println();
        System.out.print("Plularuty 1: ");
        System.out.println(plularity3);
        System.out.print("Plularuty 2: ");
        System.out.println(plularity4);
        System.out.println("Plularity 1 (merge) Plularity 2: ");
        System.out.println(oparations.merge(plularity3, plularity4));
        System.out.println();
        System.out.print("Plularuty 3: ");
        System.out.println(plularity1);
        System.out.print("Plularuty 4: ");
        System.out.println(plularity2);
        System.out.println("Plularity 3 (merge) Plularity 4: ");
        System.out.println(oparations.merge(plularity1, plularity2));
        System.out.println();

        System.out.println("5.Member");
        System.out.println();
        System.out.print("Member: ");
        System.out.println(3);
        System.out.print("Plularuty: ");
        System.out.println(plularity4);
        System.out.print("Answer: ");
        System.out.println(oparations.member(3, plularity4));
        System.out.println();

        System.out.println("6.Makenull");
        System.out.println();
        System.out.print("Plularuty: ");
        System.out.println(plularity5);
        System.out.println("Plularity(after makenull): ");
        oparations.makenull(plularity5);
        try {
            System.out.println(plularity5);
        }catch (NullPointerException x){
            System.out.println("Plularity is null");
        }
        System.out.println();

        System.out.println("7.Insert");
        System.out.println();
        System.out.print("Plularuty : ");
        System.out.println(plularity1);
        System.out.print("value x = ");
        System.out.println(10);
        System.out.println("x (insert) Plularity: ");
        System.out.println(oparations.insert(10, plularity1));
        System.out.println();
        System.out.print("Plularuty : ");
        System.out.println(plularity1);
        System.out.print("value x = ");
        System.out.println(15);
        System.out.println("x (insert) Plularity: ");
        System.out.println(oparations.insert(15, plularity1));
        System.out.println();

        System.out.println("8.Delete");
        System.out.println();
        System.out.print("Plularuty : ");
        System.out.println(plularity1);
        System.out.print("value x = ");
        System.out.println(15);
        System.out.println("x (delete) Plularity: ");
        System.out.println(oparations.delete(15, plularity1));
        System.out.println();
        System.out.print("Plularuty : ");
        System.out.println(plularity1);
        System.out.print("value x = ");
        System.out.println(10);
        System.out.println("x (delete) Plularity: ");
        System.out.println(oparations.delete(10, plularity1));
        System.out.println();

        System.out.println("9.Assign");
        System.out.println();
        System.out.print("Plularity 1: ");
        System.out.println(plularity1);
        System.out.print("Plularuty 2: ");
        System.out.println(plularity2);
        System.out.println("Assign(Plularity1,Plularity2): ");
        oparations.assign(plularity1,plularity2);
        System.out.print("Plularity 1: ");
        System.out.println(plularity1);
        System.out.println();

        System.out.println("10.Min");
        System.out.println("Plularity 1: ");
        System.out.print(plularity1);
        System.out.println();
        System.out.print("Min element: ");
        System.out.println(oparations.min(plularity1));
        System.out.println();


        System.out.println("11.Max");
        System.out.println("Plularity 1: ");
        System.out.print(plularity1);
        System.out.println();
        System.out.print("Max element: ");
        System.out.println(oparations.max(plularity1));
        System.out.println();

        System.out.println("12.Equal");
        System.out.print("Plularity 1: ");
        System.out.println(plularity1);
        System.out.print("Plularity 2: ");
        System.out.println(plularity3);
        System.out.print("Plularity1~Plularity2: ");
        System.out.println(oparations.equal(plularity1,plularity3));
        System.out.print("Plularity1~Plularity1: ");
        System.out.println(oparations.equal(plularity1,plularity1));
        System.out.println();

        System.out.println("13.Find");
        System.out.print("Plularity 1: ");
        System.out.println(plularity6);
        System.out.print("Plularity 2: ");
        System.out.println(plularity7);
        System.out.print("Plularity 3: ");
        System.out.println(plularity8);
        System.out.println("x = 10");
        System.out.print("x in : ");
        System.out.println(oparations.find(10,
                new MyLinkedList[]{plularity6,plularity7,plularity8}));
        System.out.println();
    }
}
