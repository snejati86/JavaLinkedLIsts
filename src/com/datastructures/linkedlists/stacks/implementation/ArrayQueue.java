package com.datastructures.linkedlists.stacks.implementation;

import com.datastructures.linkedlists.stacks.exceptions.EmptyQueueException;
import com.datastructures.linkedlists.stacks.interfaces.Queue;

/**
 * Created by nejasix on 2/18/15.
 */
public class ArrayQueue<E> implements Queue<E> {
    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public E front() throws EmptyQueueException {
        return null;
    }

    @Override
    public void enqueue(E element) {

    }

    @Override
    public E dequeue() throws EmptyQueueException {
        return null;
    }
}
