package com.datastructures.linkedlists.implementation;

import com.datastructures.linkedlists.exception.LinkedListEmptyException;
import com.datastructures.linkedlists.interfaces.ISinglyList;
import com.datastructures.linkedlists.nodes.SNode;

/**
 * This class includes the utility methods for solving interview questions about linked lists.
 */
public class Utils {
    /**
     * This utility function will return the last nth element from a singly linked list.
     *
     * @param list represents a singly linked list.
     * @param n    the number from the last element.
     * @return the node.
     * @throws LinkedListEmptyException if the list is empty.
     */
    public static <T> SNode<T> findNthLastElements(ISinglyList<T> list, int n)
            throws LinkedListEmptyException {
        if (list != null) {
            SNode<T> element = null;
            if (list.getSize() != 0) {
                SNode<T> iterator = list.getHead();
                element = list.getHead();
                for (int i = 0; i < n; ++i) {
                    if (iterator != null) {
                        iterator = iterator.getNext();
                    } else {
                        throw new LinkedListEmptyException();
                    }
                }
                while (iterator != null) {
                    iterator = iterator.getNext();
                    element = element.getNext();
                }

            }
            return element;
        } else {
            throw new LinkedListEmptyException();
        }
    }

    /**
     * Reverses a sinlgy linked list.
     *
     * @param list
     * @return
     * @throws LinkedListEmptyException
     */
    public static <T> ISinglyList<T> reverse(ISinglyList<T> list) throws LinkedListEmptyException {
        if (list != null) {
            if (list.getSize() > 0) {
                SNode<T> cursor = list.getHead();
                SNode<T> prev = null;
                while (cursor != null) {
                    SNode<T> temp = cursor.getNext();
                    cursor.setNext(prev);
                    prev = cursor;
                    cursor = temp;
                }
                list.setHead(prev);
                return list;
            }
        }
        throw new LinkedListEmptyException();
    }

}
