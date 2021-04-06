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

    private Node root;

    public BinaryTreeImpl() {
        root = null;
    }

    private int countElement = 0;
    private int AscCount;
    private int DescCount;
    public int[] sortedArrayAsc;
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

        for (int i = 0; i < elements.length; i++) {
            root = addElement(root, elements[i]);
            countElement++;
        }
    }

    private Node addElement(Node node, int element) {
        if (node == null) {
            node = new Node(element);
            return node;
        } else if (element < node.element) {
            node.left = addElement(node.left, element);
        } else if (element > node.element) {
            node.right = addElement(node.right, element);
        }
        return node;
    }

    @Override
    public boolean findElement(int value) {
        root = findElement(root, value);
        if (root != null)
            return true;
        else
            return false;
    }

    private Node findElement(Node root, int value) {
        if (root == null || root.element == value) {
            return root;
        }
        if (root.element > value) {
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
        if (node == null) {
            return node;
        } else if (node.element == element) {
            return node;
        } else if (node.element > element) {
            return findElement(node.left, element);
        }
        return findElement(node.right, element);
    }

    @Override
    public int[] getSortedTreeAsc() {
        AscCount = 0;
        sortedArrayAsc = new int[getNumberOfElements()];
        getSortedAsc(root);
        return sortedArrayAsc;
    }

    @Override
    public int[] getSortedTreeDesc() {
        DescCount = 0;
        sortedArrayDesc = new int[getNumberOfElements()];
        getSortedDesc(root);
        return sortedArrayDesc;
    }

    private void getSortedAsc(Node node) {
        if (node != null) {
            getSortedAsc(node.left);
            sortedArrayAsc[AscCount] = node.element;
            AscCount++;
            getSortedAsc(node.right);
        }

    }

    private void getSortedDesc(Node node) {
        if (node != null) {
            getSortedDesc(node.right);
            sortedArrayDesc[DescCount] = node.element;
            DescCount++;
            getSortedDesc(node.left);
        }

    }

}
