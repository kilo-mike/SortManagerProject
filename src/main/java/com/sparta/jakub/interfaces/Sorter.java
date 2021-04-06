package com.sparta.jakub.interfaces;

import com.sparta.jakub.exceptions.MyException;

public interface Sorter {

    int[] sortArray(int[] arrayToSort) throws MyException;
}
