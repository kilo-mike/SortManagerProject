package com.sparta.jakub.sort;

import com.sparta.jakub.binaryTree.BinaryTreeImpl;
import com.sparta.jakub.exceptions.MyException;
import com.sparta.jakub.interfaces.Sorter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BinaryTreeSort implements Sorter {
    public static final Logger logger = LogManager.getLogger(BinaryTreeSort.class);

    private static BinaryTreeSort binaryTreeSort = new BinaryTreeSort();

    public static BinaryTreeSort getInstance() {
        return binaryTreeSort;
    }

    @Override
    public int[] sortArray(int[] arrayToSort) throws MyException {
        if (arrayToSort == null) {
            throw new NullPointerException("Array is null");
        }else if (arrayToSort.length == 0 || arrayToSort.length == 1){
            throw new MyException("Array to small");
        }else{
            BinaryTreeImpl binaryTree = new BinaryTreeImpl();
            binaryTree.addElements(arrayToSort);
            return binaryTree.getSortedTreeAsc();
        }
    }
}
