package com.datastructures.linkedlists.doubly;

import com.datastructures.linkedlists.exception.LinkedListEmptyException;
import com.datastructures.linkedlists.implementation.DoublyLinkedList;
import com.datastructures.linkedlists.interfaces.IDoublyList;
import com.datastructures.linkedlists.nodes.DNode;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.math.BigInteger;
import java.security.SecureRandom;

import static org.junit.Assert.*;

public class DoublyListTest {
    private IDoublyList<String> testList = new DoublyLinkedList<String>();

    private SecureRandom random = new SecureRandom();

    @Before
    public void setUp() throws Exception {
        for (int i = 0; i < 100; ++i) {
            if (i == 99) {
                testList.addLast(new DNode<String>("last"));
            } else if (i == 0) {
                testList.addLast(new DNode<String>("first"));
            } else {
                testList.addLast(new DNode<String>(new BigInteger(130, random)
                        .toString(32)));
            }
        }
    }

    @After
    public void tearDown() throws Exception {
        while (!testList.isEmpty()) {
            testList.removeFirst();
        }
    }

    @Test
    public void testAddition() throws Exception {
        assertEquals(100, testList.getSize());

        /**
         * Now lets add one element at tail and see the effect.
         */
        String NEW_LAST = "new last";
        testList.addLast(new DNode<String>(NEW_LAST));
        assertEquals(101, testList.getSize());
        assertEquals(NEW_LAST, testList.getTail().getElement());
        assertEquals("last", testList.getTail().getPrev().getElement());

        /**
         * Now lets add one element at the head and see the effect.
         */
        assertEquals("first", testList.getHead().getElement());
        String NEW_FIRST = "NEW FIRST";
        testList.addFirst(new DNode<String>(NEW_FIRST));
        assertEquals(NEW_FIRST, testList.getHead().getElement());
        assertEquals("first", testList.getHead().getNext().getElement());

        tearDown();

        /**
         * Testing with one element.
         */
        assertTrue(testList.isEmpty());
        testList.addFirst(new DNode<String>(NEW_FIRST));
        assertTrue(NEW_FIRST.equalsIgnoreCase(testList.getHead().getElement())
                & NEW_FIRST.equalsIgnoreCase(testList.getTail().getElement()));
        assertEquals(1, testList.getSize());

        tearDown();

        /**
         * Testing with one element.
         */
        assertTrue(testList.isEmpty());
        testList.addLast(new DNode<String>(NEW_FIRST));
        assertTrue(NEW_FIRST.equalsIgnoreCase(testList.getHead().getElement())
                & NEW_FIRST.equalsIgnoreCase(testList.getTail().getElement()));
        assertEquals(testList.getHead(), testList.getTail());
        assertEquals(1, testList.getSize());

        /**
         * Testing with two elements.
         */
        testList.addLast(new DNode<String>(NEW_LAST));
        assertTrue(NEW_FIRST.equalsIgnoreCase(testList.getHead().getElement())
                & NEW_LAST.equalsIgnoreCase(testList.getTail().getElement()));
        assertEquals(2, testList.getSize());
    }

    @Test
    public void testRemoval() throws Exception {
        assertEquals(100, testList.getSize());
        testList.removeFirst();
        assertEquals(99, testList.getSize());
        assertNotSame(testList.getHead().getElement(), "first");
        testList.removeLast();
        assertEquals(98, testList.getSize());
        assertNotSame(testList.getHead().getElement(), "last");

        /**
         * Try exception.
         */
        tearDown();
        assertTrue(testList.isEmpty());

        Throwable exception = null;
        try {
            testList.getHead();
        } catch (Exception e) {
            exception = e;
        }
        assertEquals(LinkedListEmptyException.class, exception.getClass());

        /**
         * Try the other one.
         */
        try {
            testList.getTail();
        } catch (Exception e) {
            exception = e;
        }
        assertEquals(LinkedListEmptyException.class, exception.getClass());
    }

}
