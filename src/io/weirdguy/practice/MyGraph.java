package io.weirdguy.practice;

import ua.princeton.lib.In;

import java.util.ArrayList;

/**
 * io.weirdguy.practice by laiko in practiceWork
 * Created on 29.03.2017
 */
public class MyGraph {

    private MyList<MyList> list;

    public MyGraph(int[][] adjacencyMatrix) {
        list = new MyList<MyList>();
        for(int i = 0; i < adjacencyMatrix.length; i++) {
            MyList<Integer> p = new MyList<Integer>();
            for(int j = 0; j < adjacencyMatrix[i].length; j++) {
                if(adjacencyMatrix[i][j] > 0) p.append(new Integer(j + 1), new Integer(i + 1).toString());
            }
            list.append(p, "");
        }
    }

    public String toString() {
        return list.toString();
    }

}
