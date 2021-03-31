package com.sparta.jakub.sort;

import com.sparta.jakub.exception.MyException;
import com.sparta.jakub.sortInterface.Sorter;

public class MergeSort implements Sorter {
    @Override
    public int[] sortArray(int[] arrayToSort) {

        if (arrayToSort.length < 2) {
            return arrayToSort;
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
        sortArray(leftArray);
        sortArray(rightArray);
        merge(arrayToSort, leftArray, rightArray);

//        int temp1 = 0, temp2 = 0, temp3 = 0;
//        while (temp1 < leftArray.length && temp2 < rightArray.length) {
//            if (leftArray[temp1] <= rightArray[temp2]) {
//                arrayToSort[temp3++] = leftArray[temp1++];
//            } else {
//                arrayToSort[temp3++] = rightArray[temp2++];
//            }
//        }
//        while (temp1 < leftArray.length) {
//            arrayToSort[temp3++] = leftArray[temp1++];
//        }
//        while (temp2 < rightArray.length) {
//            arrayToSort[temp3++] = rightArray[temp2++];
//        }
        return arrayToSort;
    }

    public void merge(int[] arrayToSort, int[] leftArray, int[] rightArray) {
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
