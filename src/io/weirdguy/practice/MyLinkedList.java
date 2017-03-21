package io.weirdguy.practice;

import java.util.Arrays;
import java.util.Comparator;
import java.util.NoSuchElementException;

/**
 * io.weirdguy.practice by laiko in practiceWork
 * Created on 21.03.2017
 */
public class MyLinkedList<Integer> {
    public MyLinkedList find(Integer x, MyLinkedList[] arr){
        MyLinkedList res = new MyLinkedList();
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                if (i!=j && (intersection(arr[i], arr[j]).getSize() != 0))
                    return null;
            }
        }

        for (int i = 0; i < arr.length; i++)
            if(member(x,arr[i])) {
                return arr[i];
            }

        return res;
    }

    public boolean equal(MyLinkedList aInput, MyLinkedList bInput){
        if(aInput.size-bInput.size==0) {
            for (MyLinkedList a = new MyLinkedList(aInput), b = new MyLinkedList(bInput);
                 a.head != null; a.head = a.head.next, b.head = b.head.next)
                if (a.head.compareTo(b.head) != 0)
                    return false;
        }else
            return false;

        return true;
    }

    public Integer max(MyLinkedList aInput){
        java.lang.Integer max= java.lang.Integer.MIN_VALUE;
        MyLinkedList a = new MyLinkedList(aInput);
        for (int i = 0; a.head!=null; i++, a.head=a.head.next){
            if(new Element<>(max).compareTo(a.head) < 0){
                max = (java.lang.Integer)a.head.data;
            }
        }
        return (Integer) max;
    }
    public Integer max(MyLinkedList aInput, Comparator comparator){
        java.lang.Integer max= java.lang.Integer.MIN_VALUE;
        MyLinkedList a = new MyLinkedList(aInput);
        for (int i = 0; a.head!=null; i++, a.head=a.head.next){
            if(comparator.compare(new Element<>(max),a.head) < 0){
                max = (java.lang.Integer)a.head.data;
            }
        }
        return (Integer) max;
    }
    public Integer min(MyLinkedList aInput){
        java.lang.Integer min = java.lang.Integer.MAX_VALUE;
        MyLinkedList a = new MyLinkedList(aInput);
        for (int i = 0; a.head!=null; i++, a.head=a.head.next){
            if(a.head.compareTo(new Element<>(min)) < 0){
                min = (java.lang.Integer)a.head.data;
            }
        }
        return (Integer) min;
    }
    public Integer min(MyLinkedList aInput, Comparator comparator){
        java.lang.Integer min = java.lang.Integer.MAX_VALUE;
        MyLinkedList a = new MyLinkedList(aInput);
        for (int i = 0; a.head!=null; i++, a.head=a.head.next){
            if(comparator.compare(a.head,new Element<>(min)) < 0){
                min = (java.lang.Integer)a.head.data;
            }
        }
        return (Integer) min;
    }

    public void assign(MyLinkedList a, MyLinkedList b){
        a.head = b.head;
    }

    public MyLinkedList delete(Integer x, MyLinkedList aInput){
        MyLinkedList a = new MyLinkedList(aInput);
        if(!member(x,a)){
            return a;
        }else return difference(a,new MyLinkedList(x));
    }

    public MyLinkedList insert(Integer x, MyLinkedList aInput){
        MyLinkedList a = new MyLinkedList(aInput);
        if(member(x,a)){
            return a;
        }else return union(a,new MyLinkedList(x));
    }

    public void makenull(MyLinkedList aInput){
        aInput.head = null;
    }

    public boolean member(Integer x, MyLinkedList aInput){
        for (MyLinkedList a = new MyLinkedList(aInput);
             a.head!=null; a.head=a.head.next)
            if(x.equals(a.head.data))
                return true;

        return false;
    }

    public MyLinkedList merge(MyLinkedList aInput, MyLinkedList bInput){
        MyLinkedList res = new MyLinkedList();
        if(intersection(aInput,bInput).getSize()==0)
            res = union(aInput,bInput);
        return res;
    }

    public MyLinkedList difference(MyLinkedList aInput, MyLinkedList bInput){
        int point=aInput.size;
        MyLinkedList a = new MyLinkedList(aInput);
        MyLinkedList b = new MyLinkedList(bInput);
        MyLinkedList c = new MyLinkedList();
        java.lang.Integer[] array1 = new java.lang.Integer[a.size];
        java.lang.Integer[] array2 = new java.lang.Integer[b.size];
        for (int i = 0; a.head!=null; i++, a.head=a.head.next)
            array1[i] = (java.lang.Integer) a.head.data;
        for (int i = 0; b.head!=null; i++, b.head=b.head.next)
            array2[i] = (java.lang.Integer) b.head.data;


        for (int i = 0; i < array1.length; i++)
            for (int j = 0; j < array2.length; j++)
                if (array1[i].equals(array2[j])) {
                    point--;
                    break;
                }

        java.lang.Integer[] array3 = new java.lang.Integer[point];
        for (int i = 0, k=0; i < array1.length; i++) {
            boolean can = true;
            for (int j = 0; j < array2.length; j++)
                if (array1[i].equals(array2[j])) {
                    can=false;
                    break;
                }
            if(can){
                array3[k++] = array1[i];
            }
        }

        Arrays.sort(array3);
        for (int i = 0; i < array3.length; i++) c.append(array3[i]);

        return c;
    }

    public MyLinkedList intersection(MyLinkedList aInput, MyLinkedList bInput){
        int point=0;
        MyLinkedList a = new MyLinkedList(aInput);
        MyLinkedList b = new MyLinkedList(bInput);
        MyLinkedList c = new MyLinkedList();
        java.lang.Integer[] array1 = new java.lang.Integer[a.size];
        java.lang.Integer[] array2 = new java.lang.Integer[b.size];
        for (int i = 0; a.head!=null; i++, a.head=a.head.next)
            array1[i] = (java.lang.Integer) a.head.data;

        for (int i = point; b.head!=null; i++, b.head=b.head.next)
            array2[i] = (java.lang.Integer) b.head.data;

        for (int i = 0; i < array1.length; i++) {
            for (int j = 0; j < array2.length; j++) {
                if (array1[i].equals(array2[j])) {
                    point++;
                    break;
                }
            }
        }
        java.lang.Integer[] array3 = new java.lang.Integer[point];
        for (int j = 0, k=0; j < array1.length; j++) {
            for (int i = 0; i < array2.length; i++) {
                if(array1[j].equals(array2[i])){
                    array3[k++] = array1[j];
                    break;
                }
            }
        }

        Arrays.sort(array3);
        for (int i = 0, k=0; i < array3.length; i++) {
            if(i==0||array3[i]!=k)
                c.append(array3[i]);
            k=array3[i];
        }

        return c;
    }

    public MyLinkedList union(MyLinkedList aInput, MyLinkedList bInput){
        int point=0;
        MyLinkedList a = new MyLinkedList(aInput);
        MyLinkedList b = new MyLinkedList(bInput);
        MyLinkedList c = new MyLinkedList();
        java.lang.Integer[] array = new java.lang.Integer[a.getSize()+b.getSize()];
        for (int i = 0; a.head!=null; i++, a.head=a.head.next) {
            array[i] = (java.lang.Integer) a.head.data;
            point = i+1;
        }
        for (int i = point; b.head!=null; i++, b.head=b.head.next)
            array[i] = (java.lang.Integer) b.head.data;

        Arrays.sort(array);
        for (int i = 0, k=0; i < array.length; i++) {
            if(i==0||array[i]!=k)
                c.append(array[i]);
            k=array[i];
        }

        return c;
    }

    private static class Element<Integer> {
        private Integer data;
        private Element<Integer> next;

        public Element(Integer data) {
            this.data = data;
        }

        public boolean equals(Element<Integer> el) {
            if (el == null) {
                return false;
            }

            if ((el.data == null) && (this.data == null)) {
                return true;
            }

            if ((el.data == null) || (this.data == null)) {
                return false;
            }

            return (el.data.equals(this.data));
        }

        public int compareTo(Element that) {
            return java.lang.Integer.compare((java.lang.Integer)this.data,(java.lang.Integer)that.data);
        }

    }

    private Element<Integer> head;

    private int size;

    public MyLinkedList() {
        size = 0;
    }

    public MyLinkedList(Integer data) {
        this(new Element<>(data));
    }

    private MyLinkedList(Element<Integer> head) {
        this.head = head;
        size = 1;
    }

    public MyLinkedList(MyLinkedList<Integer> list) {
        this.head = list.head;
        this.size = list.size;
    }

    public int getSize() {
        return size;
    }

    public void prepend(Integer data) {
        prepend(new Element<>(data));
    }

    private void prepend(Element<Integer> el) {
        el.next = head;
        head = el;
        size++;
    }

    public void append(Integer data) {
        append(new Element<>(data));
    }

    private void append(Element<Integer> el) {
        if (size == 0) {
            prepend(el);
        } else {
            Element<Integer> p = head;

            while (p.next != null) {
                p = p.next;
            }

            p.next = el;
            size++;
        }
    }

    public void insert(Integer data, int position) {
        insert(new Element<>(data), position);
    }

    private void insert(Element<Integer> el, int position) {
        if (size == 0 || position <= 0) {
            prepend(el);
        } else if (position >= size) {
            append(el);
        } else {
            Element<Integer> p = head;
            for (int i = 1; i < position; i++, p = p.next);

            el.next = p.next;
            p.next = el;
            size++;
        }
    }

    public void remove(int position) {
        if (size == 0 || position < 0 || position >= size)
            throw new NoSuchElementException();

        if (position == 0) {
            head = head.next;
            size--;
        } else {
            Element<Integer> p = head;
            for (int i = 1; i < position - 1 && p.next != null; i++, p = p.next);

            Element<Integer> q = p.next.next;
            p.next.next = null;
            p.next = q;
            size--;
        }
    }

    public boolean contains(Integer data) {
        return contains(new Element<>(data));
    }

    private boolean contains(Element<Integer> el) {
        if (size == 0) {
            return false;
        }

        Element<Integer> p = head;

        while (p.next != null) {
            if (p.equals(el)) {
                return true;
            }

            p = p.next;
        }

        return p.equals(el);
    }

    public String toString() {
        if (size == 0) {
            return "List is empty";
        }

        StringBuilder res = new StringBuilder();

        Element<Integer> p = head;
        res.append(p.data);

        while (p.next != null) {
            res.append("; ");
            p = p.next;
            res.append(p.data);
        }

        return res.toString();
    }
}
