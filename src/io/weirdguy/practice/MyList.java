package io.weirdguy.practice;

/**
 * io.weirdguy.practice by laiko in practiceWork
 * Created on 02.04.2017
 */
public class MyList<T> {

    private Element<T> head;
    private int size;

    public MyList() {
        size = 0;
    }

    public int getSize() {
        return this.size;
    }

    public void prepend(T data, String name) {
        prepend(new Element<T>(data, name));
    }

    private void prepend(Element<T> el) {
        el.next = head;
        head = el;
        size++;
    }

    public void append(T data, String name) {
        append(new Element<T>(data, name));
    }

    private void append(Element<T> data) {
        if(size == 0) {
            prepend(data);
        } else {
            Element<T> p = head;

            while (p.next != null) {
                p = p.next;
            }

            p.next = data;
            p.next.prev = p;
            size++;
        }
    }

    private static class Element<T> {

        private T data;
        private String name;
        private Element<T> next;
        private Element<T> prev;

        public Element(T data, String name) {
            this.data = data;
            this.name = name;
        }

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

//        public int compareTo(Element<T> el) {
//            return data.compareTo(el.data);
//        }
    }

    public String toString() {
        if(size == 0) {
            return "List is empty";
        }

        StringBuilder res = new StringBuilder();

        Element<T> p = head;
        res.append(p.data);

        int i = 1;

        while (p.next != null) {
            res.append(", ");
            p = p.next;
            res.append(p.data);
        }

        if(p.name != "") return p.name + ": [" + res.toString() + "]";
        return "[" + res.toString() + "]";
    }
}
