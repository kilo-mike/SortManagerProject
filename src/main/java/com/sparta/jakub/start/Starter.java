package com.sparta.jakub.start;

import com.sparta.jakub.binaryTree.BinaryTreeImpl;
import com.sparta.jakub.exceptions.ArrayTooSmallException;
import com.sparta.jakub.interfaces.Sorter;
import com.sparta.jakub.type.SorterFactory;
import com.sparta.jakub.type.SorterType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

public class Starter {

    public static final Logger logger = LogManager.getLogger(Starter.class);

    public static void start() {
        SorterFactory sorterFactory = new SorterFactory();
        Sorter binaryTreeSort = sorterFactory.getSorter(SorterType.BINARY);
        Sorter mergeSort = sorterFactory.getSorter(SorterType.MERGE);
        Sorter bubbleSort = sorterFactory.getSorter(SorterType.BUBBLE);

        int[] arrayToSort = {6,7,4,2,8,99,41};
        try {
            System.out.println("binary tree " + Arrays.toString(binaryTreeSort.sortArray(arrayToSort)));
            System.out.println("merge sort " + Arrays.toString(mergeSort.sortArray(arrayToSort)));
            System.out.println("bubble sort " + Arrays.toString(bubbleSort.sortArray(arrayToSort)));
        }catch (ArrayTooSmallException e){
            logger.error(e);
        }
    }

}
