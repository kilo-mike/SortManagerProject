package com.sparta.jakub.start;

import com.sparta.jakub.exception.MyException;
import com.sparta.jakub.sort.BubbleSort;
import com.sparta.jakub.sort.MergeSort;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Starter {

    public static final Logger logger = LogManager.getLogger(Starter.class);

    public static void start() {
        BubbleSort bubbleSort = new BubbleSort();
        int[] arrayToSort = {5, 7, 6, 3, 3, 88, 9, 1, 21, 2, 67, 91, 4};
        int[] arrayToSort2 = {1, 2, 3, 4};
        int[] arrayToSort3 = null;

        logger.error("errror message");


        try {
            bubbleSort.sortArray(arrayToSort3);
            for (int value : arrayToSort3) {
                System.out.print(value + " ");
            }
        } catch (MyException e) {
            logger.error(e.getMessage(), e);
        } catch (Exception e) {
            logger.error(e);
        }


//        MergeSort mergeSort = new MergeSort();
//        mergeSort.sortArray(arrayToSort3);
//        for (int value : arrayToSort3) {
//            System.out.print(value + " ");
//
//        }

    }

}
