package io.weirdguy.practice;

/**
 * io.weirdguy.practice by laiko in practiceWork
 * Created on 29.03.2017
 */
public class MyGraphTester {


    public static void main(String[] args) {

        int[][] matrix = new int[][]{
                {0, 1, 1, 0, 0, 0},
                {1, 0, 0, 1, 0, 0},
                {1, 0, 0, 1, 0, 0},
                {0, 1, 1, 0, 1, 1},
                {0, 0, 0, 0, 0, 1},
                {0, 0, 0, 0, 1, 0},
        };

        MySecondGraph graph = new MySecondGraph(matrix);
        System.out.println(graph.toString());
    }

}
