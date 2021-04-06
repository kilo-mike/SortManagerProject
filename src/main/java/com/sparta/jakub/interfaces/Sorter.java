package com.sparta.jakub.interfaces;

import com.sparta.jakub.exceptions.ArrayTooSmallException;

public interface Sorter {

    int[] sortArray(int[] arrayToSort) throws ArrayTooSmallException;
}
