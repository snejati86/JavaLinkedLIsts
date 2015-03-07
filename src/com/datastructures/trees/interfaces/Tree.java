package com.datastructures.trees.interfaces;

import java.util.Iterator;

/**
 * Created by nejasix on 2/22/15.
 */
public interface Tree<E> {
    public int size();

    public boolean isEmpty();

    public Iterator<E> iterator();

    public TreeNode<E> getRoot();

    public E replace(TreeNode<E> node, E element);

}
