
package com.datastructures.linkedlists.nodes;

public class SNode<T>
{
    /**
     * Default constructor.
     * 
     * @param e
     */
    public SNode(T e)
    {
        element = e;
    }

    private T element;

    private SNode<T> next;

    /**
     * @return the next
     */
    public SNode<T> getNext()
    {
        return next;
    }

    /**
     * @param next the next to set
     */
    public void setNext(SNode<T> next)
    {
        this.next = next;
    }

    /**
     * @return the element
     */
    public T getElement()
    {
        return element;
    }

    /**
     * @param element the element to set
     */
    public void setElement(T element)
    {
        this.element = element;
    }
}
