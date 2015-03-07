package com.datastructures.linkedlists.stacks.interfaces;

import com.datastructures.linkedlists.stacks.exceptions.EmptyQueueException;

/**
 * Created by nejasix on 2/18/15.
 */
public interface Queue<E> {
    public int size();

    public boolean isEmpty();

    public E front() throws EmptyQueueException;

    public void enqueue(E element);

    public E dequeue() throws EmptyQueueException;
}
