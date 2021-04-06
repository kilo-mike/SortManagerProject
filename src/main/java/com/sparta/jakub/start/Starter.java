package com.sparta.jakub.start;

import com.sparta.jakub.binaryTree.BinaryTreeImpl;
import com.sparta.jakub.exceptions.ArrayTooSmallException;
import com.sparta.jakub.interfaces.Sorter;
import com.sparta.jakub.type.SorterFactory;
import com.sparta.jakub.type.SorterType;
import com.sparta.jakub.util.Printer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Starter {

    public static final Logger logger = LogManager.getLogger(Starter.class);

    public static void start() {
        SorterFactory sorterFactory = new SorterFactory();
        Sorter binaryTreeSort = sorterFactory.getSorter(SorterType.BINARY);
        Sorter mergeSort = sorterFactory.getSorter(SorterType.MERGE);
        Sorter bubbleSort = sorterFactory.getSorter(SorterType.BUBBLE);

        double startBubble, stopBubble, startMerge, stopMerge, startBinary, stopBinary;

        Scanner scanner = new Scanner(System.in);
        int arraySize;
        while (true) {
            Printer.printer("Size of array to test: ");
            if (scanner.hasNextInt()) {
                arraySize = scanner.nextInt();
                break;
            } else {
                scanner.next();
                System.err.println("Please enter a number!!");
            }
        }
        int[] arrayToSort = new int[arraySize];

        Random random = new Random();
        for (int i = 0; i < arraySize; i++) {
            arrayToSort[i] = random.nextInt(1000);
        }
        try {
//            System.out.println("binary tree " + Arrays.toString(binaryTreeSort.sortArray(arrayToSort)));
//            System.out.println("merge sort " + Arrays.toString(mergeSort.sortArray(arrayToSort)));
//            System.out.println("bubble sort " + Arrays.toString(bubbleSort.sortArray(arrayToSort)));
//            ---------------------------------
            startBinary = System.nanoTime();
            binaryTreeSort.sortArray(arrayToSort);
            stopBinary = System.nanoTime();
//            ---------------------------------
            startBubble = System.nanoTime();
            bubbleSort.sortArray(arrayToSort);
            stopBubble = System.nanoTime();
//            ---------------------------------
            startMerge = System.nanoTime();
            mergeSort.sortArray(arrayToSort);
            stopMerge = System.nanoTime();
//            ---------------------------------
            Printer.printer("Time taken in nanoseconds to sort random generated Array with "+arraySize+"elements: ");
            logger.info("Time taken in nanoseconds: ");
            Printer.printer("BinaryTree time: " + (stopBinary - startBinary));
            logger.info("BinaryTree time: " + (stopBinary - startBinary));
            Printer.printer("BubbleSort time: " + (stopBubble - startBubble));
            logger.info("BubbleSort time: " + (stopBubble - startBubble));
            Printer.printer("MergeSort time: " + (stopMerge - startMerge));
            logger.info("MergeSort time: " + (stopMerge - startMerge));
        } catch (ArrayTooSmallException e) {
            logger.error(e.getMessage(), e);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }

    }

}
