package com.datastructures.linkedlists.singly;

import com.datastructures.linkedlists.exception.LinkedListEmptyException;
import com.datastructures.linkedlists.implementation.SinglyLinkedList;
import com.datastructures.linkedlists.implementation.Utils;
import com.datastructures.linkedlists.interfaces.ISinglyList;
import com.datastructures.linkedlists.nodes.SNode;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.junit.Assert.*;

public class SinglyListInterviewTest {

    private ISinglyList<Integer> testList = new SinglyLinkedList<Integer>();

    @Before
    public void setUp() throws Exception {
        /**
         * Empty Implementation.
         */
    }

    @After
    public void tearDown() throws Exception {
        while (!testList.isEmpty()) {
            testList.removeFirst();
        }
    }

    /**
     * Implement a method to remove duplicated nodes from a singly linked list. TODO : How would you
     * do it if temporary buffer is not allowed.
     *
     * @throws LinkedListEmptyException
     */
    @Test
    public void removeDuplicated() throws LinkedListEmptyException {
        /**
         * First we create a linked list with duplicated nodes in it. Let's make it fancy.
         */
        for (int i = 0; i < 1000; ++i) {
            if (i % 2 == 0) {
                testList.addLast(new SNode<Integer>(1));
            } else {
                testList.addLast(new SNode<Integer>(2));
            }
        }

        Map<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        SNode<Integer> cursor = null;
        SNode<Integer> prev = cursor;
        try {
            cursor = testList.getHead();
        } catch (LinkedListEmptyException e) {
            fail();
        }
        while (cursor != null) {
            if (!hashMap.containsKey(cursor.getElement())) {
                hashMap.put(cursor.getElement(), null);
            } else {
                SNode<Integer> next = cursor.getNext();
                prev.setNext(next);
            }
            prev = cursor;
            cursor = cursor.getNext();
        }
        SNode<Integer> printer = testList.getHead();
        while (printer != null) {
            System.out.println(printer.getElement());
            printer = printer.getNext();
        }
        assertSame(testList.getSize(), 500);
    }

    /**
     * Implement a method to find the n-th last element in a singly linked list.
     *
     * @throws LinkedListEmptyException
     */
    @Test
    public void findNthLastElement() throws LinkedListEmptyException {
        /**
         * Let's create the list.
         */
        for (int i = 1; i < 11; ++i) {
            testList.addLast(new SNode<Integer>(i));
        }
        /**
         * Now lets get the Nth last element.
         */
        SNode<Integer> result = null;
        result = Utils.findNthLastElements(testList, 7);
        assertSame(4, result.getElement());
        result = Utils.findNthLastElements(testList, 10);
        assertSame(1, result.getElement());
        /**
         * Now lets check something nasty!
         */
        Exception exception = null;
        try {
            result = Utils.findNthLastElements(testList, 11);
        } catch (Exception e) {
            exception = e;
        }
        assertSame(LinkedListEmptyException.class, exception.getClass());
    }

    /**
     * Implement a method to remove a node in the middle of singly linked list given the node is the
     * only node you have access to.
     */
    @Test
    public void removeNodeFromMiddle() throws Exception {
        /**
         * Let's create the list.
         */
        for (int i = 1; i < 12; ++i) {
            testList.addLast(new SNode<Integer>(i));
        }
        SNode<Integer> middleNode = returnMiddle(testList);
        assertEquals((int) middleNode.getElement(), 6);

    }

    private <T> SNode<T> returnMiddle(ISinglyList<T> list) throws Exception {
        if (list != null) {
            if (list.getSize() > 0) {
                int size = list.getSize();
                int middleElement = (int) Math.ceil(size / 2);
                SNode<T> cursor = list.getHead();
                for (int i = 0; i < middleElement; ++i) {
                    cursor = cursor.getNext();
                }
                return cursor;
            } else {
                //EMPTY LIST.
                throw new Exception("List empty");
            }
        } else {
            throw new Exception("Null list");
        }
    }

    /**
     * Implement a method that will take a singly linked list and a number and will return true if
     * two nodes in the list are added.
     */
    @Test
    public void detectIfTwoElementsAddUp() throws LinkedListEmptyException {
        /**
         * Let's create the list.
         */
        for (int i = 1; i < 11; ++i) {
            testList.addLast(new SNode<Integer>(i));
        }

        assertTrue(isSumPairPresent(3, testList));
        assertFalse(isSumPairPresent(50, testList));
    }

    private boolean isSumPairPresent(int number, ISinglyList<Integer> list) throws LinkedListEmptyException {

        Set<Integer> innerSet = new HashSet<Integer>(list.getSize());
        SNode<Integer> cursor = list.getHead();
        for (int i = 0; i < list.getSize(); ++i) {
            int pair = number - cursor.getElement();
            if (innerSet.contains(pair)) {
                return true;
            } else {
                innerSet.add(cursor.getElement());
                cursor = cursor.getNext();
            }
        }
        return false;
    }

    /**
     * Implement a method to merge to sorted singly linked lists.
     */
    @Test
    public void mergeSortedLists() {
        fail();
    }

    /**
     * Reverse a singly linked list.
     *
     * @throws LinkedListEmptyException
     */
    @Test
    public void reverseList() throws LinkedListEmptyException {
        /**
         * Let's create the list.
         */
        for (int i = 1; i < 11; ++i) {
            testList.addLast(new SNode<Integer>(i));
        }
        SNode<Integer> cursor = testList.getHead();
        while (cursor.getNext() != null) {
            System.out.println(cursor.getElement());
            assertTrue(cursor.getElement().compareTo(cursor.getNext().getElement()) < 0);
            cursor = cursor.getNext();
        }
        System.out.println(cursor.getElement());

        System.out.println("Reversed-");

        ISinglyList<Integer> reversedList = Utils.reverse(testList);
        cursor = reversedList.getHead();
        while (cursor.getNext() != null) {
            System.out.println(cursor.getElement());
            assertTrue(cursor.getElement().compareTo(cursor.getNext().getElement()) > 0);
            cursor = cursor.getNext();
        }
        System.out.println(cursor.getElement());

    }

    /**
     * Select a random node from a linked list.
     */
    @Test
    public void selectRandom() {
        fail();
    }

    @Test
    public void testRecursiveListFunction() throws Exception {
        /**
         * Let's create the list.
         */
        for (int i = 1; i < 11; ++i) {
            testList.addLast(new SNode<Integer>(i));
        }

        SNode<Integer> newHead = recursiveReverse(testList.getHead(), null);
        testList.setHead(newHead);
        SNode<Integer> head = testList.getHead();
        while (head.getNext() != null) {
            assertTrue(head.getElement().compareTo(head.getNext().getElement()) > 0);
            head = head.getNext();
        }
    }

    private SNode<Integer> recursiveReverse(SNode<Integer> head, SNode<Integer> prev) throws LinkedListEmptyException {
        SNode<Integer> result = null;
        if (head.getNext() != null) {
            SNode<Integer> cached = head.getNext();
            head.setNext(prev);
            result = recursiveReverse(cached, head);
        } else {
            head.setNext(prev);
            result = head;
        }
        return result;
    }
}
