package io.weirdguy.practice;

import java.util.NoSuchElementException;

public class BinaryTreeLinkedList<T> {
    private T data;
    private BinaryTreeLinkedList left;
    private BinaryTreeLinkedList right;
    private int size;

    public BinaryTreeLinkedList(){
        size = 0;
        data = null;
    }

    public BinaryTreeLinkedList(T data){
        if(data==null)
            throw new NullPointerException();
        this.data = data;
        size = 1;
    }

    public boolean isEmpty(){
        return size==0 ? true : false;
    }

    public int getSize(){
        return this.size;
    }

    public boolean find(T data){
     if(data == null)
         throw new NullPointerException();
     BinaryTreeLinkedList temp = this;
     return check(temp) ? true : false;
    }

    private boolean check(BinaryTreeLinkedList tree){
        if(data == null)
            throw new NullPointerException();
        boolean res1, res2;
        if(tree.data == data){
            return true;
        }else {
            res1 = check(tree.left);
            res2 = check(tree.right);
        }

        return res1||res2 ? true : false;
    }

    private BinaryTreeLinkedList findRoot(T data){
        BinaryTreeLinkedList pointer1=null;
        BinaryTreeLinkedList pointer2=null;
        if(this.data == data){
            return this;
        }else {
            if(this.left!=null)
            pointer1 = this.left.findRoot(data);
            if(this.right!=null)
            pointer2 = this.right.findRoot(data);
        }

        return pointer1==null ? pointer2==null ? null : pointer2 : pointer1;
    }

    public void addLeftSonAt(T root, T data){
        if(!find(root))
            throw new NoSuchElementException();
        if(data==null)
            throw new NullPointerException();

        this.findRoot(root).left = new BinaryTreeLinkedList();
        if(this.findRoot(root).left.data==null) {
            this.findRoot(root).left.data = data;
            size++;
        }else
            throw new IllegalArgumentException();
    }

    public void addRightSonAt(T root, T data){
        if(!find(root))
            throw new NoSuchElementException();
        if(data==null)
            throw new NullPointerException();

        this.findRoot(root).right = new BinaryTreeLinkedList();
        if(this.findRoot(root).right.data==null) {
            this.findRoot(root).right.data = data;
            size++;
        }else
            throw new IllegalArgumentException();
    }

    public void remove(T data) {
    if (!find(data))
        throw new NoSuchElementException();
    if (data == null)
        throw new NullPointerException();

    BinaryTreeLinkedList pointer = this.findRoot(data);

    pointer.data=null;
    if(pointer.left!=null) {
        pointer.data = pointer.left.data;
        if(pointer.right!=null){
            pointer.left.data = pointer.right.data;
            pointer.right.data = null;
        }else {
            pointer.left.data=null;
        }
    }
    }

    public String toString(){
        return size == 0 ? "Empty tree" : this.findRootStr();
    }

    private String findRootStr(){
        String res="";
            res+= "root: " + this.data;
            if(this.left==null&&this.right==null)
            res+="\n";

            if(this.left!=null)
            res+= " left: " + this.left.data+" ";
            if(this.right!=null)
            res+= " right: " + this.right.data+"\n";
            if(this.left!=null)
            res += this.left.findRootStr();
            if(this.right!=null)
            res += this.right.findRootStr();

        return res;
    }

}