package com.sparta.jakub.binaryTree;

import com.sparta.jakub.exceptions.ChildNotFoundException;
import com.sparta.jakub.exceptions.RootNullException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeImplTest {
    BinaryTreeImpl binaryTree = new BinaryTreeImpl();

    @BeforeEach
    void setUp() {

        binaryTree.addElements(new int[]{5, 2, 1, 4, 3});
    }

    @Test
    void getRootElement() {

        assertEquals(5, binaryTree.getRootElement());
    }

    @Test
    void getNumberOfElements() {
        assertEquals(5, binaryTree.getNumberOfElements());

    }

    @Test
    void addElement() {
        binaryTree.addElement(12);
        assertTrue(binaryTree.findElement(12));
    }

    @Test
    void addElements() {
        binaryTree.addElements(new int[]{23, 34, 52});
        assertTrue(binaryTree.findElement(23));
        assertTrue(binaryTree.findElement(34));
        assertTrue(binaryTree.findElement(52));
        assertEquals(8, binaryTree.getNumberOfElements());

    }

    @Test
    void findElement() {
        assertTrue(binaryTree.findElement(5));
        assertFalse(binaryTree.findElement(117));
        binaryTree.addElement(117);
        assertTrue(binaryTree.findElement(117));
    }

    @Test
    void getLeftChild() throws ChildNotFoundException, RootNullException {
        assertEquals(1, binaryTree.getLeftChild(2));

    }

    @Test
    void getRightChild() throws ChildNotFoundException, RootNullException {
        assertEquals(4, binaryTree.getRightChild(2));

    }

    @Test
    void getSortedTreeAsc() {
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, binaryTree.getSortedTreeAsc());

    }

    @Test
    void getSortedTreeDesc() {
        assertArrayEquals(new int[]{5, 4, 3, 2, 1}, binaryTree.getSortedTreeDesc());

    }
}