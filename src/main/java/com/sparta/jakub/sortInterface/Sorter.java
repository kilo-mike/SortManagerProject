package com.sparta.jakub.sortInterface;

import com.sparta.jakub.exception.MyException;

public interface Sorter {

    int[] sortArray(int[] arrayToSort) throws MyException;
}
