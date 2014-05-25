package com.datastructures.linkedlists.interfaces;

import com.datastructures.linkedlists.exception.LinkedListEmptyException;
import com.datastructures.linkedlists.nodes.DNode;

public interface IDoublyList<T> {
    public DNode<T> getHead() throws LinkedListEmptyException;

    public DNode<T> getTail() throws LinkedListEmptyException;

    public void removeFirst() throws LinkedListEmptyException;

    public void removeLast() throws LinkedListEmptyException;

    public void addLast(DNode<T> node);

    public void addFirst(DNode<T> node);

    public boolean isEmpty();

    public int getSize();
}
