package com.datastructures.linkedlists.interfaces;

import com.datastructures.linkedlists.exception.LinkedListEmptyException;
import com.datastructures.linkedlists.nodes.SNode;

public interface ISinglyList<T>
{
    public SNode<T> getHead() throws LinkedListEmptyException;
    
    public void removeFirst() throws LinkedListEmptyException;
    
    public void removeLast() throws LinkedListEmptyException;
    
    public void addLast(SNode<T> node);
    
    public void addFirst(SNode<T> node);
    
    public boolean isEmpty();
    
    public int getSize();
}
