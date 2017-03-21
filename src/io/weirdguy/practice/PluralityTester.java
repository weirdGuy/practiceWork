package io.weirdguy.practice;

/**
 * io.weirdguy.practice by laiko in practiceWork
 * Created on 21.03.2017
 */
public class PluralityTester {
    public static void main(String[] args) {
        tester();
    }

    private static void tester() {
        PluralityOperations oparations = new PluralityOperations();
        PluralityOperations.Plurality plularity1 = new PluralityOperations.Plurality();
        PluralityOperations.Plurality plularity2 = new PluralityOperations.Plurality();
        PluralityOperations.Plurality plularity3 = new PluralityOperations.Plurality();
        PluralityOperations.Plurality plularity4 = new PluralityOperations.Plurality();
        PluralityOperations.Plurality plularity5 = new PluralityOperations.Plurality();
        PluralityOperations.Plurality plularity6 = new PluralityOperations.Plurality();

        for (int i = 1; i <= 100; i++) {
            if(i%2==0){
                oparations.insert(i, plularity5);
            }else
                oparations.insert(i, plularity6);
            if(i%2==0) {
                oparations.insert(i, plularity1);
                oparations.insert(i, plularity4);
            }else
                oparations.insert(i, plularity2);
            oparations.insert(i,plularity3);
        }

        System.out.println("START TEST");
        System.out.println();

        System.out.println("1.Union");
        System.out.println();
        System.out.print("Plularuty 1: ");
        System.out.println(plularity1);
        System.out.print("Plularuty 2: ");
        System.out.println(plularity2);
        System.out.print("Plul1 + Pl2: ");
        System.out.println(oparations.union(plularity1, plularity2));
        System.out.println();

        System.out.println("2.Intersection");
        System.out.println();
        System.out.print("Plularuty 1: ");
        System.out.println(plularity1);
        System.out.print("Plularuty 2: ");
        System.out.println(plularity3);
        System.out.print("Pl1 (i) Pl2: ");
        System.out.println(oparations.intersection(plularity1, plularity3));
        System.out.println();

        System.out.println("3.Difference");
        System.out.println();
        System.out.print("Plularuty 1: ");
        System.out.println(plularity3);
        System.out.print("Plularuty 2: ");
        System.out.println(plularity1);
        System.out.print("Pl1  \\  Pl2: ");
        System.out.println(oparations.difference(plularity3, plularity1));
        System.out.println();

        System.out.println("4.Merge");
        System.out.println();
        System.out.print("Plularuty 1: ");
        System.out.println(plularity1);
        System.out.print("Plularuty 2: ");
        System.out.println(plularity2);
        System.out.print("Pl1 (m) Pl2: ");
        System.out.println(oparations.merge(plularity3, plularity4));
        System.out.println();
        System.out.print("Plularuty 1: ");
        System.out.println(plularity1);
        System.out.print("Plularuty 2: ");
        System.out.println(plularity3);
        System.out.print("Pl1 (m) Pl2: ");
        System.out.println(oparations.merge(plularity1, plularity3));
        System.out.println();

        System.out.println("5.Member");
        System.out.println();
        System.out.print("Member: ");
        System.out.println(4);
        System.out.print("Plularuty: ");
        System.out.println(plularity1);
        System.out.print("Answer: ");
        System.out.println(oparations.member(4, plularity1));
        System.out.println();
        System.out.print("Member: ");
        System.out.println(3);
        System.out.print("Plularuty: ");
        System.out.println(plularity1);
        System.out.print("Answer: ");
        System.out.println(oparations.member(3, plularity1));
        System.out.println();

        System.out.println("6.Makenull");
        System.out.println();
        System.out.print("Plularuty: ");
        System.out.println(plularity4);
        System.out.print("Plularity(after makenull): ");
        plularity4=oparations.makeNull(plularity4);
        System.out.println(plularity4);
        System.out.println();

        System.out.println("7.Insert");
        System.out.println();
        System.out.print("Plularuty : ");
        System.out.println(plularity1);
        System.out.print("value x = ");
        System.out.println(10);
        System.out.print("x (i) Plur: ");
        oparations.insert(10, plularity1);
        System.out.println(plularity1);
        System.out.println();
        System.out.print("Plularuty : ");
        System.out.println(plularity1);
        System.out.print("value x = ");
        System.out.println(3);
        System.out.print("x (i) Plur: ");
        oparations.insert(3, plularity1);
        System.out.println(plularity1);
        System.out.println();

        System.out.println("8.Delete");
        System.out.println();
        System.out.print("Plularuty : ");
        System.out.println(plularity1);
        System.out.print("value x = ");
        System.out.println(2);
        System.out.print("x (del) Pl: ");
        oparations.delete(2, plularity1);
        System.out.println(plularity1);
        System.out.println();
        System.out.print("Plularuty : ");
        System.out.println(plularity1);
        System.out.print("value x = ");
        System.out.println(3);
        System.out.print("x (del) Pl: ");
        oparations.delete(3, plularity1);
        System.out.println(plularity1);
        System.out.println();

        System.out.println("9.Assign");
        System.out.println();
        System.out.print("Plularity 1: ");
        System.out.println(plularity1);
        System.out.print("Plularuty 2: ");
        System.out.println(plularity2);
        System.out.println("Assign(Plularity1,Plularity2) ");
        plularity1 = oparations.assign(plularity1,plularity2);
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
        System.out.println(plularity5);
        System.out.print("Plularity 2: ");
        System.out.println(plularity6);
        System.out.println("x = 10");
        System.out.print("x in : ");
        System.out.println(oparations.find(10,
                new PluralityOperations.Plurality[]{plularity5,plularity6}));
        System.out.println();

    }
}
