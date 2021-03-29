package com.sparta.jakub.sort;

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

        return arrayToSort;
    }

    private static void merge(int[] arrayToSort, int[] leftArray, int[] rightArray) {

        int leftArrLength = arrayToSort.length / 2;
        int rightArrLength =arrayToSort.length - leftArrLength;
        int temp1 = 0, temp2 = 0, temp3 = 0;
        while (temp1 < leftArrLength && temp2 < rightArrLength) {
            if (leftArray[temp1] <= rightArray[temp2]) {
                arrayToSort[temp3++] = leftArray[temp1++];
            } else {
                arrayToSort[temp3++] = rightArray[temp2++];
            }
        }
        while (temp1 < leftArrLength) {
            arrayToSort[temp3++] = leftArray[temp1++];
        }
        while (temp2 < rightArrLength) {
            arrayToSort[temp3++] = rightArray[temp2++];
        }
    }
}
