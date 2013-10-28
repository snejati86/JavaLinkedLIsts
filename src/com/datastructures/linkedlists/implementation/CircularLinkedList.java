package com.datastructures.linkedlists.implementation;

import com.datastructures.linkedlists.exception.LinkedListEmptyException;
import com.datastructures.linkedlists.interfaces.ICircularList;
import com.datastructures.linkedlists.nodes.DNode;

public class CircularLinkedList<T> implements ICircularList<T>
{
    private int size;
    
    private DNode<T> cursor;
    
    public CircularLinkedList(T element)
    {
	cursor = new DNode<T>(element);
	cursor.setNext(null);
	cursor.setPrev(null);
    }
    
    @Override
    public int getSize()
    {
	return size;
    }

    @Override
    public void advance()
    {
	cursor = cursor.getNext();
    }

    @Override
    public DNode<T> getCursor()
    {
	return cursor;
    }

    @Override
    public void add(DNode<T> node)
    {
	if ( cursor == null )
	{
	    node.setNext(node);
	    cursor = node;
	}
	else
	{
	    node.setNext(cursor.getNext());
	    cursor.setNext(node);
	}
	size++;
    }

    @Override
    public void remove() throws LinkedListEmptyException
    {
	if ( size == 0 )
	{
	    throw new LinkedListEmptyException();
	}
	else
	{
	    DNode<T> afterCursor = cursor.getNext();
	    if ( afterCursor == cursor.getPrev() )
	    {
		cursor = null;
	    }
	    else
	    {
		
		cursor.setNext(afterCursor.getNext());
		afterCursor.setNext(null);
	    }
	    size--;
	}
    }

    @Override
    public boolean isEmpty()
    {
	return size == 0 ;
    }

}
