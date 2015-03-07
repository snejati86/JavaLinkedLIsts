package com.datastructures.trees.interfaces;

/**
 * Created by nejasix on 2/26/15.
 */
public interface Heap {
    public int size();

    public boolean isEmpty();

    public int removeMin();

    public void insert(int number);
}
