package com.sparta.jakub.sort;

import com.sparta.jakub.exception.MyException;
import com.sparta.jakub.sortInterface.Sorter;

public class BubbleSort implements Sorter {

    @Override
    public int[] sortArray(int[] arrayToSort) throws MyException {
        if (arrayToSort==null){
            throw new MyException("array is null");
        }
        int temp = 0;
        for (int i = 0; i < arrayToSort.length; i++) {
            for (int j = 1; j < arrayToSort.length; j++) {
                if (arrayToSort[j - 1] > arrayToSort[j]) {
                    temp = arrayToSort[j - 1];
                    arrayToSort[j - 1] = arrayToSort[j];
                    arrayToSort[j] = temp;
                }
            }
        }
        return arrayToSort;
    }
}
