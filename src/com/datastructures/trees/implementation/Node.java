package com.datastructures.trees.implementation;

import com.datastructures.trees.interfaces.TreeNode;

import java.util.List;

/**
 * Created by nejasix on 2/22/15.
 */
public class Node<E> implements TreeNode<E> {
    private TreeNode<E> parent;
    private List<Node<E>> children;
    private E element;

    @Override
    public boolean isExternal() {
        return !this.getChildren().iterator().hasNext();
    }

    @Override
    public boolean isInternal() {
        return !isExternal();
    }

    @Override
    public TreeNode<E> getParent() {
        return parent;
    }

    public void setParent(TreeNode<E> parent) {
        this.parent = parent;
    }

    @Override
    public Iterable<Node<E>> getChildren() {
        return children;
    }

    public void setChildren(List<Node<E>> children) {
        this.children = children;
    }

    @Override
    public E getElement() {
        return element;
    }

    public Node<E> setElement(E element) {
        this.element = element;
        return this;
    }

}
