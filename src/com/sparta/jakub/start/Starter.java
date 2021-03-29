package com.sparta.jakub.start;

import com.sparta.jakub.sort.BubbleSort;
import com.sparta.jakub.sort.MergeSort;

public class Starter {

    public static void start() {
//        BubbleSort bubbleSort = new BubbleSort();
        int[] arrayToSort = {5, 7, 6, 3, 88, 9, 1, 21, 2, 67, 91, 4};
        int[] arrayToSort2 = {1, 2, 3, 4};

//        bubbleSort.sortArray(arrayToSort);
//        for (int value : arrayToSort) {
//            System.out.print(value + " ");
//
//        }

        MergeSort mergeSort = new MergeSort();
        mergeSort.sortArray(arrayToSort);
        for (int value : arrayToSort) {
            System.out.print(value + " ");

        }

    }

}
