
package com.datastructures.linkedlists.implementation;

import com.datastructures.linkedlists.exception.LinkedListEmptyException;
import com.datastructures.linkedlists.interfaces.ISinglyList;
import com.datastructures.linkedlists.nodes.SNode;

/**
 * This class represent a singly linked list.
 * 
 * @author SinSin
 * 
 */
public class SinglyLinkedList<T> implements ISinglyList<T>
{
    private SNode<T> head;

    private int size;

    @Override
    public int getSize()
    {
        return size;
    }

    @Override
    public SNode<T> getHead()
    {
        return head;
    }

    @Override
    public void removeFirst() throws LinkedListEmptyException
    {
        if (size != 0)
        {
            SNode<T> newHead = head.getNext();
            head = newHead;
            size--;
        }
        else
        {
            throw new LinkedListEmptyException();
        }
    }

    @Override
    public void removeLast() throws LinkedListEmptyException
    {
        if (size != 0)
        {
            SNode<T> cursor = head;
            SNode<T> prev = cursor;
            while (cursor.getNext() != null)
            {
                prev = cursor;
                cursor = cursor.getNext();
            }
            prev.setNext(null);
            cursor = null;
            size--;
        }
        else
        {
            throw new LinkedListEmptyException();
        }

    }

    @Override
    public void addLast(SNode<T> node)
    {
        if (node != null)
        {
            if (size == 0)
            {
                head = node;
            }
            else
            {
                SNode<T> cursor = head;
                SNode<T> prev = cursor;
                while (cursor != null)
                {
                    prev = cursor;
                    cursor = cursor.getNext();
                }
                node.setNext(null);
                prev.setNext(node);
            }
            size++;
        }
        else
        {
            System.err.println("The node provided is null.");
        }
    }

    @Override
    public void addFirst(SNode<T> node)
    {
        if (node != null)
        {
            if (size == 0)
            {
                head = node;
            }
            else
            {
                node.setNext(head);
                head = node;
            }
            size++;
        }

    }

    @Override
    public boolean isEmpty()
    {
        return (size == 0);
    }

    /* (non-Javadoc)
     * @see com.datastructures.linkedlists.interfaces.ISinglyList#setHead()
     */
    @Override
    public void setHead(SNode<T> newHead) throws LinkedListEmptyException
    {
        head = newHead;
    }

}
