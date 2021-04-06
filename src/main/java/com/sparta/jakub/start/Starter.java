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

        Scanner scanner = new Scanner(System.in);
        int arraySize;
        while (true) {
            Printer.printer("Size of array to test: ");
            if (scanner.hasNextInt()) {
                arraySize = scanner.nextInt();
                break;
            } else {
                scanner.next();
                Printer.printer("Please enter a number!!");
            }
        }
        int[] arrayToSort = new int[arraySize];

        Random random = new Random();
        for (int i = 0; i < arraySize; i++) {
            arrayToSort[i] = random.nextInt(1000);
        }
        try {
            Printer.printer("binary tree " + Arrays.toString(binaryTreeSort.sortArray(arrayToSort)));
            Printer.printer("bubble sort " + Arrays.toString(bubbleSort.sortArray(arrayToSort)));
            Printer.printer("merge sort " + Arrays.toString(mergeSort.sortArray(arrayToSort)));

        } catch (ArrayTooSmallException e) {
            logger.error(e.getMessage(), e);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }

    }

}
