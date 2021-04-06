package com.sparta.jakub.interfaces;


import com.sparta.jakub.exceptions.ChildNotFoundException;
import com.sparta.jakub.exceptions.RootNullException;

public interface BinaryTree {
    int getRootElement();

    int getNumberOfElements();

    void addElement(int element);

    void addElements(int[] elements);

    boolean findElement(int value);

    int getLeftChild(int element) throws ChildNotFoundException, RootNullException;

    int getRightChild(int element)throws ChildNotFoundException, RootNullException;

    int[] getSortedTreeAsc();

    int[] getSortedTreeDesc();
}
