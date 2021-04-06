package com.sparta.jakub.sort;

import com.sparta.jakub.exceptions.ArrayTooSmallException;
import com.sparta.jakub.interfaces.Sorter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BubbleSort implements Sorter {



    private static BubbleSort bubbleSort = new BubbleSort();

    private BubbleSort() {
    }

    public static Sorter getInstance() {
        return bubbleSort;

    }

    @Override
    public int[] sortArray(int[] arrayToSort) throws ArrayTooSmallException {
        if (arrayToSort == null) {
            throw new NullPointerException("Array is null");
        }else if (arrayToSort.length == 0 || arrayToSort.length == 1) {
            throw new ArrayTooSmallException("Array too small");
        }
        int lastIndexSwap = arrayToSort.length - 1;
        for (int i = 1; i < arrayToSort.length; i++) {
            boolean isSorted = true;
            int currentIndexSwap = -1;

            for (int j = 0; j < lastIndexSwap; j++) {
                if (arrayToSort[j] > arrayToSort[j + 1]) {
                    int temp = arrayToSort[j];
                    arrayToSort[j] = arrayToSort[j + 1];
                    arrayToSort[j + 1] = temp;
                    isSorted = false;
                    currentIndexSwap = j;
                }
            }
            if (isSorted) {
                return arrayToSort;
            }
            lastIndexSwap = currentIndexSwap;
        }
        return arrayToSort;
    }
}
