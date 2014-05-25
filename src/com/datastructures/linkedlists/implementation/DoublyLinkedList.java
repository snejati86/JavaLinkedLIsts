package com.datastructures.linkedlists.implementation;

import com.datastructures.linkedlists.exception.LinkedListEmptyException;
import com.datastructures.linkedlists.interfaces.IDoublyList;
import com.datastructures.linkedlists.nodes.DNode;

public class DoublyLinkedList<T> implements IDoublyList<T> {

    /**
     * Head DNode.
     */
    private DNode<T> head;

    /**
     * Tail DNode.
     */
    private DNode<T> tail;

    /**
     * The size of this double linked list.
     */
    private int size;

    @Override
    public DNode<T> getHead() throws LinkedListEmptyException {
        if (size != 0) {
            return head;
        } else {
            throw new LinkedListEmptyException();
        }
    }

    @Override
    public void removeFirst() throws LinkedListEmptyException {
        if (size != 0) {

            DNode<T> newHead = head.getNext();
            if (newHead == null) {
                head = tail = null;
            } else {
                newHead.setPrev(null);
                head = newHead;
            }
            size--;
        } else {
            throw new LinkedListEmptyException();
        }

    }

    @Override
    public void removeLast() throws LinkedListEmptyException {
        if (size != 0) {
            DNode<T> newTail = tail.getPrev();
            if (newTail == null) {
                head = tail = null;
            } else {
                newTail.setNext(null);
                tail = newTail;
            }
            size--;
        } else {
            throw new LinkedListEmptyException();
        }

    }

    @Override
    public void addLast(DNode<T> node) {
        if (size != 0) {
            node.setPrev(tail);
            node.setNext(null);
            tail.setNext(node);
            tail = node;
        } else {
            tail = head = node;
            node.setNext(null);
            node.setPrev(null);
        }
        size++;
    }

    @Override
    public void addFirst(DNode<T> node) {
        if (size != 0) {
            node.setNext(head);
            node.setPrev(null);
            head = node;
        } else {
            head = tail = node;
            node.setNext(null);
            node.setPrev(null);
        }
        size++;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public DNode<T> getTail() throws LinkedListEmptyException {
        if (size != 0) {
            return tail;
        } else {
            throw new LinkedListEmptyException();
        }
    }

}
