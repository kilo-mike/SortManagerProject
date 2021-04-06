package com.sparta.jakub.start;

import com.sparta.jakub.binaryTree.BinaryTreeImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Starter {

    public static final Logger logger = LogManager.getLogger(Starter.class);

    public static void start() {
//        BubbleSort bubbleSort = new BubbleSort();
        int[] arrayToSort = {5, 7, 6, 3, 3, 88, 9, 1, 21, 2, 67, 91, 4};
        int[] arrayToSort2 = {1, 2, 3, 4, 3, 2, 1};
        int[] arrayToSort3 = null;

        BinaryTreeImpl binaryTree = new BinaryTreeImpl();
//        binaryTree.addElements(arrayToSort);
        binaryTree.addElement(67);
//        System.out.println(binaryTree.getRootElement());
        System.out.println(  binaryTree.findElement(68));
        System.out.println(binaryTree.findElement(9));


//        try {
//            bubbleSort.sortArray(arrayToSort2);
//            for (int value : arrayToSort2) {
//                System.out.print(value + " ");
//            }
//        } catch (MyException e) {
//            logger.error(e.getMessage(), e);
//        } catch (Exception e) {
//            logger.error(e);
//        }


//        MergeSort mergeSort = new MergeSort();
//        try {
//            mergeSort.sortArray(arrayToSort);
//            logger.info("test");
//            for (int value : arrayToSort) {
//                System.out.print(value + " ");
//            }
//        } catch (MyException e) {
//            logger.error(e.getMessage(), e);
//        } catch (Exception e) {
//            logger.error(e);
//        }


    }

}
