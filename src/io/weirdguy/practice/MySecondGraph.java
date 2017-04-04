package io.weirdguy.practice;

/**
 * io.weirdguy.practice by laiko in practiceWork
 * Created on 04.04.2017
 */
public class MySecondGraph {

    private MyList<MyList> list;

    public MySecondGraph(int[][] incidenceMatrix) {
        list = new MyList<MyList>();

        for(int i = 0; i < incidenceMatrix[1].length; i++) {
            boolean first = true;
            MyList<Integer> p = new MyList<Integer>();
            for(int j = 0; j < incidenceMatrix.length; j++) {
                if(first && incidenceMatrix[j][i] > 0) {
                    p.append(new Integer(j + 1), new Integer(i + 1).toString());
                    first = false;
                } else if(incidenceMatrix[j][i] > 0) {
                    p.append(new Integer(j + 1), new Integer(i + 1).toString());
                }
            }
            list.append(p, "");
        }
    }

    public String toString() {
        return list.toString();
    }
}
