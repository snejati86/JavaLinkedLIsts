package com.datastructures.linkedlists.interfaces;

import com.datastructures.linkedlists.exception.LinkedListEmptyException;
import com.datastructures.linkedlists.nodes.DNode;

public interface ICircularList<T> {
    public void advance();

    public DNode<T> getCursor();

    public void add(DNode<T> node);

    public void remove() throws LinkedListEmptyException;

    public int getSize();

    public boolean isEmpty();
}
