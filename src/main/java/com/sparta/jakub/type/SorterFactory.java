package com.sparta.jakub.type;

import com.sparta.jakub.interfaces.Sorter;
import com.sparta.jakub.sort.BinaryTreeSort;
import com.sparta.jakub.sort.BubbleSort;
import com.sparta.jakub.sort.MergeSort;

public class SorterFactory {

    public Sorter getSorter(SorterType type){
        Sorter  sorterType = null;
        switch (type){
            case MERGE:
                sorterType = MergeSort.getInstance();
                break;
            case BINARY:
                sorterType = BinaryTreeSort.getInstance();

                break;
            case BUBBLE:
                sorterType = BubbleSort.getInstance();

                break;
        }
        return sorterType;
    }
}
