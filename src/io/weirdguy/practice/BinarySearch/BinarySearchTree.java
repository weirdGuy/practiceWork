package io.weirdguy.practice.BinarySearch;

import java.util.LinkedList;

public class BinarySearchTree<T> {
    private Node root;

    public BinarySearchTree() {
        this.root = null;
    }

    boolean isEmpty() {
        return root == null ? true : false;
    }

    public boolean contains(T id) {
        Node current = root;
        while (current != null) {
            if (current.compareTo(id)==0) {
                return true;
            } else if (current.compareTo(id) > 0) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
        return false;
    }

    public boolean remove(T id) {
        Node parent = root;
        Node current = root;
        boolean isLeftChild = false;
        while (current.data != id) {
            parent = current;
            if (current.compareTo(id) > 0) {
                isLeftChild = true;
                current = current.left;
            } else {
                isLeftChild = false;
                current = current.right;
            }
            if (current == null) {
                return false;
            }
        }

        if (current.left == null && current.right == null) {
            if (current == root) {
                root = null;
            }
            if (isLeftChild == true) {
                parent.left = null;
            } else {
                parent.right = null;
            }
        }
        else if (current.right == null) {
            if (current == root) {
                root = current.left;
            } else if (isLeftChild) {
                parent.left = current.left;
            } else {
                parent.right = current.left;
            }
        } else if (current.left == null) {
            if (current == root) {
                root = current.right;
            } else if (isLeftChild) {
                parent.left = current.right;
            } else {
                parent.right = current.right;
            }
        } else if (current.left != null && current.right != null) {

            Node successor = getSuccessor(current);
            if (current == root) {
                root = successor;
            } else if (isLeftChild) {
                parent.left = successor;
            } else {
                parent.right = successor;
            }
            successor.left = current.left;
        }
        return true;
    }

    public void add(T id) {
        Node newNode = new Node(id);
        if (root == null) {
            root = newNode;
            return;
        }
        Node current = root;
        Node parent = null;
        while (true) {
            parent = current;
            if (current.compareTo(id)>0) {
                current = current.left;
                if (current == null) {
                    parent.left = newNode;
                    return;
                }
            } else {
                current = current.right;
                if (current == null) {
                    parent.right = newNode;
                    return;
                }
            }
        }
    }

    @Override
    public String toString(){
        String res=""+myDisplay(root);

        return res;
    }

    private String myDisplay(Node root) {
        String res="";
        if (root != null) {
            res+="" + root.data+ " ";
            res+=myDisplay(root.left)+"";
            res+=myDisplay(root.right)+"";
        }
        return res;
    }

    public LinkedList<T> getElementsAsc(){
        return getElementsAsc(root);
    }

    public LinkedList<T> getElementsDesc(){
        return getElementsDesc(root);
    }


    private LinkedList<T> getElementsAsc(Node root){
        LinkedList<T> list = new LinkedList<>();
        if(root!=null){
            if(root.left!=null)
            list.addAll(getElementsAsc(root.left));
            list.add(root.data);
            if(root.right!=null)
            list.addAll(getElementsAsc(root.right));

        }
        return list;
    }

    private LinkedList<T> getElementsDesc(Node root){
        LinkedList<T> list = new LinkedList<>();
        if(root!=null){
            if(root.right!=null)
                list.addAll(getElementsDesc(root.right));
            list.add(root.data);
            if(root.left!=null)
                list.addAll(getElementsDesc(root.left));

        }
        return list;
    }

    private Node getSuccessor(Node deleleNode) {
        Node successsor = null;
        Node successsorParent = null;
        Node current = deleleNode.right;
        while (current != null) {
            successsorParent = successsor;
            successsor = current;
            current = current.left;
        }
        if (successsor != deleleNode.right) {
            successsorParent.left = successsor.right;
            successsor.right = deleleNode.right;
        }
        return successsor;
    }

    class Node {
        T data;
        Node left;
        Node right;

        public Node(T data) {
            this.data = data;
            left = null;
            right = null;
        }

        public int compareTo(Node node){
            return (Integer)this.data - (Integer)node.data;
        }
        public int compareTo(T data){
         return (Integer)this.data - (Integer)data;
        }
    }
}