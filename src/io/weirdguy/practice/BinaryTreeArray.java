package io.weirdguy.practice;

import java.util.NoSuchElementException;

public class BinaryTreeArray<T> {

    private T[] treeArray;
    private int size;
    private int count;

    public BinaryTreeArray(){
    }

    public BinaryTreeArray(T[] arr,T data){
        this.treeArray = arr;
        size=arr.length;
        count=0;
        if(data==null){
            throw new NullPointerException();
        }else{
            treeArray[1]=data;
            count++;
        }
    }

    public boolean isEmpty(){
        return this.count==0 ? true : false;
    }

    public int getCountOfNodes(){
        return count;
    }

    public boolean find(T node) {
        if (node == null) {
            throw new NullPointerException();
        } else {
            for (int i = 1; i < this.size; i++)
                if (treeArray[i]!=null&&treeArray[i].equals(node)) return true;
        }
        return false;
    }

    public boolean addLeftSonAt(T node, T data){
        if(find(data)) return false;

        if(node == null) throw new NullPointerException();

        if(!find(node)) throw new NoSuchElementException();

        for (int i = 1; i < size; i++) {
            if(treeArray[i].equals(node)){
                if(treeArray[2*i] == null){
                    treeArray[2*i] = data;
                    count++;
                    return true;
                }else{
                    throw new IllegalArgumentException();
                }
            }
        }

        return false;
    }

    public boolean addRightSonAt(T node, T data){
        if(find(data)) return false;

        if(node == null) throw new NullPointerException();

        if(!find(node)) throw new NoSuchElementException();

        for (int i = 1; i < size; i++) {
            if(treeArray[i]!=null)
                if(treeArray[i].equals(node)){
                    if(treeArray[2*i+1] == null){
                        treeArray[2*i+1] = data;
                        count++;
                        return true;
                    }else{
                        throw new IllegalArgumentException();
                    }
                }
            }
        return false;
    }

    public void remove(T node){
        if(node!=null){
            if(find(node)){
                for (int i = 1; i < size; i++) {
                    if(treeArray[i]!=null&&treeArray[i].equals(node)){
                        treeArray[i]=null;
                        if(treeArray[2*i]!=null){
                            treeArray[i] = treeArray[2*i];
                            treeArray[2*i]=null;
                            if(treeArray[2*i+1]!=null){
                                treeArray[2*i] = treeArray[2*i+1];
                                treeArray[2*i+1] = null;
                            }
                        }
                        count--;
                    }
                }
            }else
                throw new NoSuchElementException();
        }else
            throw new NullPointerException();

    }

    public String toString(){
        if(count==0){
            return "Empty tree";
        }
        String res = "";
        for (int i = 1; i < size; i++) {
            if(treeArray[i]!=null){
                res += "root: " + treeArray[i] + " ";
                if(treeArray[i*2]!=null)
                    res+="left: " + treeArray[i*2]+ " ";
                if(treeArray[i*2+1]!=null)
                    res+="right: " + treeArray[i*2+1]+ " ";
                res+="\n";
            }
        }
        return res;
    }
}
