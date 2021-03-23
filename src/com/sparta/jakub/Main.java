package com.sparta.jakub;

import com.sparta.jakub.sort.BubbleSort;

public class Main {

    public static void main(String[] args) {
        BubbleSort bubbleSort= new BubbleSort();
        int[] arr= {5,7,6,3,88,9,1,21,2};
        BubbleSort.sort(arr);

        for (int a: arr) {
            System.out.println(a);

        }


    }
}
