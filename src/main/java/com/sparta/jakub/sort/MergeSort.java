package com.sparta.jakub.sort;

import com.sparta.jakub.exceptions.ArrayTooSmallException;
import com.sparta.jakub.interfaces.Sorter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MergeSort implements Sorter {
    public static final Logger logger = LogManager.getLogger(MergeSort.class);

    private static MergeSort mergeSort = new MergeSort();

    private MergeSort() {
    }

    public static Sorter getInstance() {
        return mergeSort;
    }


    @Override
    public int[] sortArray(int[] arrayToSort) throws ArrayTooSmallException {
        if (arrayToSort == null) {
            throw new NullPointerException("Array is null");
        }else if (arrayToSort.length == 0 || arrayToSort.length == 1) {
            throw new ArrayTooSmallException("Array too small!");
        } else {
            mergeSort(arrayToSort);
        }
        return arrayToSort;
    }

    private void mergeSort(int[] arrayToSort) {
        if (arrayToSort.length < 2) {
            return;
        }
        int middle = arrayToSort.length / 2;
        int[] leftArray = new int[middle];
        int[] rightArray = new int[arrayToSort.length - middle];

        for (int i = 0; i < middle; i++) {
            leftArray[i] = arrayToSort[i];
        }
        for (int i = middle; i < arrayToSort.length; i++) {
            rightArray[i - middle] = arrayToSort[i];
        }
        mergeSort(leftArray);
        mergeSort(rightArray);
        merge(arrayToSort, leftArray, rightArray);
    }

    private void merge(int[] arrayToSort, int[] leftArray, int[] rightArray) {
        int temp1 = 0, temp2 = 0, temp3 = 0;
        while (temp1 < leftArray.length && temp2 < rightArray.length) {
            if (leftArray[temp1] <= rightArray[temp2]) {
                arrayToSort[temp3++] = leftArray[temp1++];
            } else {
                arrayToSort[temp3++] = rightArray[temp2++];
            }
        }
        while (temp1 < leftArray.length) {
            arrayToSort[temp3++] = leftArray[temp1++];
        }
        while (temp2 < rightArray.length) {
            arrayToSort[temp3++] = rightArray[temp2++];
        }
    }


}
