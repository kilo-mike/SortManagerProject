package com.sparta.jakub.binaryTree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeImplTest {
    BinaryTreeImpl binaryTree = new BinaryTreeImpl();

    @BeforeEach
    void setUp() {

        binaryTree.addElements(new int[]{4, 7, 3, 2, 9, 1, 6});
    }

    @Test
    void getRootElement() {

        assertEquals(4, binaryTree.getRootElement());
    }

    @Test
    void getNumberOfElements() {
        assertEquals(7,binaryTree.getNumberOfElements());

    }

    @Test
    void addElement() {
        binaryTree.addElement(12);
        assertTrue(binaryTree.findElement(12));
    }

    @Test
    void addElements() {
    }

    @Test
    void findElement() {
    }

    @Test
    void getLeftChild() {
    }

    @Test
    void getRightChild() {
    }

    @Test
    void getSortedTreeAsc() {
    }

    @Test
    void getSortedTreeDesc() {
    }
}