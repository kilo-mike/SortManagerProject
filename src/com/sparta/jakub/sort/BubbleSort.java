package com.sparta.jakub.sort;

public class BubbleSort {


    public static void sort(int[] arr) {
        int temprary = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j < arr.length; j++) {
                if (arr[j - 1] > arr[j]) {
                    temprary = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temprary;
                }
            }
        }
    }
}
