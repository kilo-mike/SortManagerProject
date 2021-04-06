package com.sparta.jakub.sort;

import com.sparta.jakub.exceptions.ArrayTooSmallException;
import com.sparta.jakub.interfaces.Sorter;
import com.sparta.jakub.type.SorterFactory;
import com.sparta.jakub.type.SorterType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BubbleSortTest {

    private Sorter bubbleSorter = null;

    @BeforeEach
    void setup() {
        SorterFactory sorterFactory = new SorterFactory();
        bubbleSorter = sorterFactory.getSorter(SorterType.BUBBLE);
    }

    @Test
    void sortTest() throws ArrayTooSmallException {
        assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6}, bubbleSorter.sortArray(new int[]{5, 2, 6, 1, 4, 3}));
    }

    @Test
    void nullTest() {
        Exception exception = assertThrows(NullPointerException.class, () -> bubbleSorter.sortArray(null));
        assertEquals("Array is null", exception.getMessage());
    }

    @Test
    void shortArrayTest() {
        Exception exception = assertThrows(ArrayTooSmallException.class, () -> bubbleSorter.sortArray(new int[]{1}));
        assertEquals("Array too small", exception.getMessage());
    }

    @Test
    void emptyArrayTest() {
        Exception exception = assertThrows(ArrayTooSmallException.class, () -> bubbleSorter.sortArray(new int[]{0}));
        assertEquals("Array too small", exception.getMessage());
    }
}