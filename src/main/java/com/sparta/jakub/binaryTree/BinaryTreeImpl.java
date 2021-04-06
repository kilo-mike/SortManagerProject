package com.sparta.jakub.binaryTree;

import com.sparta.jakub.exceptions.ChildNotFoundException;
import com.sparta.jakub.exceptions.RootNullException;
import com.sparta.jakub.interfaces.BinaryTree;

public class BinaryTreeImpl implements BinaryTree {



    static class Node {
        int element;
        Node left;
        Node right;

        private Node(int key) {
            this.element = key;
            left = null;
            right = null;
        }
    }

  private  Node root;

    public BinaryTreeImpl() {
        root = null;
    }

    private int countElement = 0;
    private int AscCount = 0;
    private int DescCount = 0;
    private int[] sortedArrayAsc;
    private int[] sortedArrayDesc;


    @Override
    public int getRootElement() {
        return root.element;
    }

    @Override
    public int getNumberOfElements() {
        return countElement;
    }

    @Override
    public void addElement(int element) {

        root = addElement(root, element);
        countElement++;
    }

    @Override
    public void addElements(int[] elements) {

        for (int element : elements) {
            root = addElement(root, element);
            countElement++;
        }
//        for (int i = 0; i < elements.length; i++) {
//            root = addElement(root, elements[i]);
//            countElement++;
//        }
    }

    private Node addElement(Node root, int element) {
        if (root == null) {
            root = new Node(element);
        } else if (element < root.element) {
            root.left = addElement(root.left, element);
        } else if (element > root.element) {
            root.right = addElement(root.right, element);
        }
        return root;
    }

    @Override
    public boolean findElement(int value) {
        root = findElement(root, value);
        if (root != null)
            return true;
        else
            return false;
    }

    private Node findElement(Node node, int value) {
        if (root == null) {
            return root;
        } else if (root.element == value) {
            return root;
        } else if (root.element > value) {
            return findElement(root.left, value);
        }
        return findElement(root.right, value);
    }


    @Override
    public int getLeftChild(int element) throws ChildNotFoundException, RootNullException {
        root = getChild(root, element);
        if (root == null) {
            throw new RootNullException("root is null"); // to do
        } else if (root.left == null) {
            throw new ChildNotFoundException("Left child not found"); // to do
        }
        return root.left.element;
    }


    @Override
    public int getRightChild(int element) throws ChildNotFoundException, RootNullException {
        root = getChild(root, element);
        if (root == null) {
            throw new RootNullException("root is null"); // to do
        } else if (root.right == null) {
            throw new ChildNotFoundException("Right child not found"); // to do
        }
        return root.right.element;
    }

    private Node getChild(Node node, int element) throws ChildNotFoundException {
        if (root == null) {
            return root;
        } else if (root.element == element) {
            return root;
        } else if (root.element > element) {
            return findElement(root.left, element);
        }
        return findElement(root.right, element);
    }

    @Override
    public int[] getSortedTreeAsc() {
        sortedArrayAsc = new int[countElement - 1];

        getSortedAsc(root);
        return sortedArrayAsc;
    }

    @Override
    public int[] getSortedTreeDesc() {
        sortedArrayDesc = new int[countElement - 1];
        getSortedDesc(root);
        return sortedArrayDesc;
    }

    private void getSortedAsc(Node root) {
        if (root != null) {
            getSortedAsc(root.left);
            sortedArrayAsc[AscCount] = root.element;
            AscCount++;
            getSortedAsc(root.right);
        }

    }

    private void getSortedDesc(Node root) {
        if (root != null) {
            getSortedAsc(root.right);
            sortedArrayDesc[DescCount] = root.element;
            DescCount++;
            getSortedAsc(root.left);
        }

    }

}
