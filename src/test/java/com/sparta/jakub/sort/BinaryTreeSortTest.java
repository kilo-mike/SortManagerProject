package com.sparta.jakub.sort;

import com.sparta.jakub.exceptions.ArrayTooSmallException;
import com.sparta.jakub.interfaces.Sorter;
import com.sparta.jakub.type.SorterFactory;
import com.sparta.jakub.type.SorterType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeSortTest {

    private Sorter binaryTreeSorter = null;

    @BeforeEach
    void setUp() {
        SorterFactory sorterFactory = new SorterFactory();
        binaryTreeSorter = sorterFactory.getSorter(SorterType.BINARY);
    }

    @Test
    void binarySortTest() throws ArrayTooSmallException {
        assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6}, binaryTreeSorter.sortArray(new int[]{5, 2, 6, 1, 4, 3}));
    }

    @Test
    void nullArrayTest() {
        Exception exception = assertThrows(NullPointerException.class, () -> {
            binaryTreeSorter.sortArray(null);
        });
        assertEquals("Array is null", exception.getMessage());
    }


    @Test
    void shortArrayTest() {
        Exception exception = assertThrows(ArrayTooSmallException.class, () -> {
            binaryTreeSorter.sortArray(new int[]{1});
        });
        assertEquals("Array to small", exception.getMessage());
    }

    @Test
    void emptyArrayTest() {
        Exception exception = assertThrows(ArrayTooSmallException.class, () -> {
            binaryTreeSorter.sortArray(new int[]{});
        });
        assertEquals("Array to small", exception.getMessage());
    }

}