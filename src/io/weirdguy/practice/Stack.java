package io.weirdguy.practice;

import java.util.EmptyStackException;
import java.util.NoSuchElementException;

/**
 * io.weirdguy.practice by laiko in practiceWork
 * Created on 26.03.2017
 */
public class Stack<T extends Comparable<T>> {

    private Element<T> top;
    private int size;

    public Stack() {
        size = 0;
    }

    public T push(T item) {
        return push(new Element<T>(item));
    }

    private T push(Element<T> data) {
        data.next = top;
        top = data;
        size++;
        return data.data;
    }

    public T pop() {
        if(size == 0)
            throw new EmptyStackException();
        else {
            T el = top.data;
            top = top.next;
            size--;
            return el;
        }
    }

    public T peek() {
        if(size == 0) throw new EmptyStackException();
        return top.data;
    }

    public boolean empty() {
        if(size == 0) {
            return true;
        }
        return false;
    }

    public int search(T o) {
        Element<T> p = top;

        for(int i = 0; i < size; i++) {
            if(p.data.equals(o)) {
                return i + 1;
            }
            p = p.next;
        }
        return -1;
    }

    public String stackToString() {
        if(size == 0) {
            return "List is empty";
        }

        StringBuilder res = new StringBuilder();

        Element<T> p = top;
        res.append(p.data);

        while (p.next != null) {
            res.append(", ");
            p = p.next;
            res.append(p.data);
        }

        return "[" + res.toString() + "]";
    }


    private static class Element<T extends Comparable<T>> {

        private T data;
        private Element<T> next;

        public Element(T data) { this.data = data; }

        public boolean equals(Element<T> el) {
            if(el == null) return false;

            if ((el.data == null) && (this.data == null)) {
                return true;
            }

            if ((el.data == null) || (this.data == null)) {
                return false;
            }

            return (el.data.equals(this.data));
        }

        public int compareTo(Element<T> el) {
            return data.compareTo(el.data);
        }
    }

}
