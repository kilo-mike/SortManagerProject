package com.sparta.jakub.binaryTree;

import com.sparta.jakub.exceptions.ChildNotFoundException;
import com.sparta.jakub.exceptions.RootNullException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeImplTest {
    BinaryTreeImpl binaryTree = new BinaryTreeImpl();

    @BeforeEach
    void setUp() {

        binaryTree.addElements(new int[]{9, 7, 11, 4, 8, 14, 21});
    }

    @Test
    void getRootElement() {

        assertEquals(9, binaryTree.getRootElement());
    }

    @Test
    void getNumberOfElements() {
        assertEquals(7, binaryTree.getNumberOfElements());

    }

    @Test
    void addElement() {
        binaryTree.addElement(1);
        assertTrue(binaryTree.findElement(1));
    }

    @Test
    void addElements() {
        binaryTree.addElements(new int[]{22, 27, 33});
        assertTrue(binaryTree.findElement(22));
        assertTrue(binaryTree.findElement(27));
        assertTrue(binaryTree.findElement(33));
        assertEquals(10, binaryTree.getNumberOfElements());

    }

    @Test
    void findElement() {
        assertTrue(binaryTree.findElement(21));

    }

    @Test
    void getLeftChild() throws ChildNotFoundException, RootNullException {
        assertEquals(4, binaryTree.getLeftChild(7));

    }

    @Test
    void getRightChild() throws ChildNotFoundException, RootNullException {
        assertEquals(8, binaryTree.getRightChild(7));

    }

    @Test
    void getSortedTreeAsc() {
        assertArrayEquals(new int[]{4, 7, 8, 9, 11, 14, 21}, binaryTree.getSortedTreeAsc());

    }

    @Test
    void getSortedTreeDesc() {
        assertArrayEquals(new int[]{21, 14, 11, 9, 8, 7, 4}, binaryTree.getSortedTreeDesc());

    }
}