package com.datastructures.trees.interfaces;

import com.datastructures.trees.implementation.Node;

/**
 * Created by nejasix on 2/22/15.
 */
public interface TreeNode<E> {
    public boolean isExternal();

    public boolean isInternal();

    public TreeNode<E> getParent();

    public Iterable<Node<E>> getChildren();

    public E getElement();

    public TreeNode<E> setElement(E element);
}
