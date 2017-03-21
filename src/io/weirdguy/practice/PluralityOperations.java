package io.weirdguy.practice;

import java.util.Comparator;

/**
 * io.weirdguy.practice by laiko in practiceWork
 * Created on 21.03.2017
 */
public class PluralityOperations {
    private static Integer[] basicPlurality;

    public PluralityOperations(){
        Integer[] basicArray = new Integer[100];
        for (int i = 0; i < 100; i++) basicArray[i]=i+1;
        this.basicPlurality = basicArray;
    }

    public Plurality find(Integer x, Plurality[] a){
        for (int i = 0; i < a.length; i++)
            if(member(x,a[i]))
                return a[i];
        return null;
    }

    public boolean equal(Plurality a, Plurality b){
        for (int i = 0; i < 100; i++)
            if( !a.vector[i].equals(b.vector[i]) )
                return false;

        return true;
    }

    public Integer min(Plurality a){
        for (int i = 0; i < 100; i++)
            if(a.vector[i] == 1)
                return i+1;

        return -1;
    }

    public Integer max(Plurality a){
        for (int i = 99; i >= 0; i--)
            if(a.vector[i] == 1)
                return i+1;

        return -1;
    }

    public Integer min(Plurality a, Comparator comparator){
        Integer min=0;
        for (int i = 99; i > 0; i--) {
            if (comparator.compare(basicPlurality[i], basicPlurality[i - 1]) < 0)
                min = basicPlurality[i];
            else min = basicPlurality[i];
        }
        return min;
    }

    public Integer max(Plurality a, Comparator comparator){
        Integer max=0;
        for (int i = 99; i > 0; i--) {
            if(comparator.compare(basicPlurality[i],basicPlurality[i-1]) > 0)
                max = basicPlurality[i];
            else max = basicPlurality[i];
        }
        return max;
    }

    public Plurality assign(Plurality a, Plurality b){
        a=b;
        return a;
    }

    public void delete(Integer x, Plurality a){
        a.vector[x-1]=0;
    }

    public void insert(Integer x, Plurality a){
        a.vector[x-1]=1;
    }

    public Plurality makeNull(Plurality a){
        a=null;
        return a;
    }

    public boolean member(Integer x, Plurality a){
        return a.vector[x+1]==1 ? true : false;
    }

    public Plurality merge(Plurality a, Plurality b){
        boolean intersection = false;
        for (int i = 0; i < 100; i++) {
            if(a.vector[i] == 1 && b.vector[i] == 1) intersection = true;
        }
        if(!intersection){
            return union(a,b);
        }else{
            return null;
        }
    }

    public Plurality difference(Plurality a, Plurality b){
        Plurality c = new Plurality();
        for (int i = 0; i < 100; i++) {
            if(a.vector[i] == 1 && b.vector[i] == 0){
                c.vector[i] = 1;
            }else{
                c.vector[i] = 0;
            }
        }

        return c;
    }

    public Plurality intersection(Plurality a, Plurality b){
        Plurality c = new Plurality();
        for (int i = 0; i < 100; i++) {
            if(a.vector[i] == 1 && b.vector[i] == 1){
                c.vector[i] = 1;
            }else{
                c.vector[i] = 0;
            }
        }
        return c;
    }

    public Plurality union(Plurality a, Plurality b){
        Plurality c = new Plurality();
        for (int i = 0; i < 100; i++) {
            if(a.vector[i] == 1 || b.vector[i] == 1){
                c.vector[i] = 1;
            }else{
                c.vector[i] = 0;
            }
        }
        return c;
    }

    public static class Plurality {
        Integer[] vector;
        int power=0;

        public Plurality() {
            Integer[] resVector = new Integer[basicPlurality.length];

            for (int i = 0; i < 100; i++) resVector[i]=0;

            this.vector = resVector;
        }

        public Plurality(Integer[] vector) {
            Integer[] resVector = new Integer[basicPlurality.length];

            if(vector!=null) {
                for (int i = 0; i < basicPlurality.length; i++) {
                    for (int j = 0; j < vector.length; j++) {
                        if (basicPlurality[i].equals(vector[j])) {
                            resVector[i] = 1;
                            power++;
                            break;
                        } else {
                            resVector[i] = 0;
                        }
                    }
                }
            }else{
                for (int i = 0; i < 99; i++) resVector[i]=0;
            }
            this.vector = resVector;
        }

        public String toString() {
            String res = new String();
            for (int i = 0; i < vector.length; i++) {
                res+=(vector[i] + " ");
            }
            return res;
        }
    }
}
