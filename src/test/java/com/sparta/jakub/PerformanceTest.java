package com.sparta.jakub;

import com.sparta.jakub.exceptions.ArrayTooSmallException;
import com.sparta.jakub.interfaces.Sorter;
import com.sparta.jakub.start.Starter;
import com.sparta.jakub.type.SorterFactory;
import com.sparta.jakub.type.SorterType;
import com.sparta.jakub.util.Printer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

public class PerformanceTest {

    public static final Logger logger = LogManager.getLogger(PerformanceTest.class);


    private static Sorter bubbleSort;
    private static Sorter mergeSort;
    private static Sorter binaryTreeSort;

    private static int[] testArraySmall;
    private static int[] testArrayBig;

    private double startBubble, stopBubble, startMerge, stopMerge, startBinary, stopBinary;


    @BeforeAll
    static void init() {
        SorterFactory sortFactory = new SorterFactory();
        bubbleSort = sortFactory.getSorter(SorterType.BUBBLE);
        mergeSort = sortFactory.getSorter(SorterType.MERGE);
        binaryTreeSort = sortFactory.getSorter(SorterType.BINARY);

        Random random = new Random();
        testArraySmall = new int[50];
        testArrayBig = new int[5000];


        for (int i = 0; i < (testArraySmall.length); i++) {
            testArraySmall[i] = random.nextInt(200);
        }
        for (int i = 0; i < testArrayBig.length; i++) {
            testArrayBig[i] = random.nextInt(200);
        }
    }

    @Test
    void smallArrayTest() throws ArrayTooSmallException {
        startBinary = System.nanoTime();
        binaryTreeSort.sortArray(testArraySmall);
        stopBinary = System.nanoTime();
//            ---------------------------------
        startBubble = System.nanoTime();
        bubbleSort.sortArray(testArraySmall);
        stopBubble = System.nanoTime();
//            ---------------------------------
        startMerge = System.nanoTime();

        mergeSort.sortArray(testArraySmall);
        stopMerge = System.nanoTime();
//            ---------------------------------
        logger.info("Time taken in nanoseconds  to sort 50 elements array: ");
        Printer.printer("BinaryTree time: " + (stopBinary - startBinary));
        logger.info("BinaryTree time: " + (stopBinary - startBinary));
        Printer.printer("BubbleSort time: " + (stopBubble - startBubble));
        logger.info("BubbleSort time: " + (stopBubble - startBubble));
        Printer.printer("MergeSort time: " + (stopMerge - startMerge));
        logger.info("MergeSort time: " + (stopMerge - startMerge));
    }

    @Test
    void bigArrayTest() throws ArrayTooSmallException {
        startBinary = System.nanoTime();
        binaryTreeSort.sortArray(testArrayBig);
        stopBinary = System.nanoTime();
//            ---------------------------------
        startBubble = System.nanoTime();
        bubbleSort.sortArray(testArrayBig);
        stopBubble = System.nanoTime();
//            ---------------------------------
        startMerge = System.nanoTime();

        mergeSort.sortArray(testArrayBig);
        stopMerge = System.nanoTime();
//            ---------------------------------
        logger.info("Time taken in nanoseconds  to sort 5000 elements array: ");
        Printer.printer("BinaryTree time: " + (stopBinary - startBinary));
        logger.info("BinaryTree time: " + (stopBinary - startBinary));
        Printer.printer("BubbleSort time: " + (stopBubble - startBubble));
        logger.info("BubbleSort time: " + (stopBubble - startBubble));
        Printer.printer("MergeSort time: " + (stopMerge - startMerge));
        logger.info("MergeSort time: " + (stopMerge - startMerge));
    }

}
