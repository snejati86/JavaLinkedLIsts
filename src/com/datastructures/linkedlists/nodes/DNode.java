
package com.datastructures.linkedlists.nodes;

public class DNode<T>
{
    private T element;

    private DNode<T> next;

    private DNode<T> prev;

    public DNode(T elem)
    {
        element = elem;
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

    /**
     * @return the next
     */
    public DNode<T> getNext()
    {
        return next;
    }

    /**
     * @param next the next to set
     */
    public void setNext(DNode<T> next)
    {
        this.next = next;
    }

    /**
     * @return the prev
     */
    public DNode<T> getPrev()
    {
        return prev;
    }

    /**
     * @param prev the prev to set
     */
    public void setPrev(DNode<T> prev)
    {
        this.prev = prev;
    }

}
