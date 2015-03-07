package com.datastructures.linkedlists.stacks.implementation;

import com.datastructures.linkedlists.stacks.exceptions.FullStackException;
import com.datastructures.linkedlists.stacks.interfaces.Stack;

import java.util.EmptyStackException;

/**
 * Created by nejasix on 2/8/15.
 */
public class ArrayStack<T> implements Stack<T> {
    private int mSize = 0;

    private int mCursor = -1;

    private T[] mArray;

    private int maxSize = 0;

    public ArrayStack(int size) {
        mArray = (T[]) new Object[size];
        maxSize = size;
    }

    @Override
    public int size() {
        return mSize;
    }

    @Override
    public boolean isEmpty() {
        return (mSize == 0);
    }

    @Override
    public T top() throws EmptyStackException {
        if (mSize == 0) {
            throw new EmptyStackException();
        } else {
            return mArray[mCursor];
        }
    }

    @Override
    public void push(T element) throws FullStackException {
        if (mSize < maxSize) {
            mArray[++mCursor] = element;
            mSize++;
        } else {
            throw new FullStackException();
        }

    }

    @Override
    public T pop() throws EmptyStackException {
        if (mSize == 0) {
            throw new EmptyStackException();
        } else {
            T current = mArray[mCursor];
            mArray[mCursor] = null;
            mCursor--;
            mSize--;
            return current;
        }
    }
}
