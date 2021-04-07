package com.sparta.jakub.sort;

import com.sparta.jakub.exceptions.ArrayTooSmallException;
import com.sparta.jakub.interfaces.Sorter;
import com.sparta.jakub.type.SorterFactory;
import com.sparta.jakub.type.SorterType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MergeSortTest {
    private Sorter mergeSorter = null;

    @BeforeEach
    void setUp() {
        SorterFactory sorterFactory = new SorterFactory();
        mergeSorter = sorterFactory.getSorter(SorterType.MERGE);
    }

    @Test
    void mergeSortTest() throws ArrayTooSmallException {
        assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6}, mergeSorter.sortArray(new int[]{5, 2, 1, 4, 6, 3}));
    }

    @Test
    void nullArrayTest() {
        Exception exception = assertThrows(NullPointerException.class, () -> mergeSorter.sortArray(null));
        assertEquals("Array is null", exception.getMessage());
    }


    @Test
    void shortArrayTest() {
        Exception exception = assertThrows(ArrayTooSmallException.class, () -> mergeSorter.sortArray(new int[]{1}));
        assertEquals("Array too small!", exception.getMessage());
    }

    @Test
    void emptyArrayTest() {
        Exception exception = assertThrows(ArrayTooSmallException.class, () -> mergeSorter.sortArray(new int[]{}));
        assertEquals("Array too small!", exception.getMessage());
    }

}