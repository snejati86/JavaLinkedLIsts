package com.datastructures.linkedlists.stacks.interfaces;

import com.datastructures.linkedlists.stacks.exceptions.FullStackException;

import java.util.EmptyStackException;

/**
 * Created by nejasix on 2/8/15.
 */
public interface Stack<T> {
    public int size();

    public boolean isEmpty();

    public T top() throws EmptyStackException;

    public void push(T element) throws FullStackException;

    public T pop() throws EmptyStackException;
}
