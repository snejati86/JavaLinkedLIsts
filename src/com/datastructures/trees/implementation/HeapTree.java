package com.datastructures.trees.implementation;

import com.datastructures.trees.interfaces.Heap;

/**
 * Created by nejasix on 2/26/15.
 */
public class HeapTree implements Heap {
    private int size;

    private BTNode innerTree;

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return (innerTree == null);
    }

    @Override
    public int removeMin() {
        if (innerTree != null) {
            int el = innerTree.getElement();
            BTNode current = innerTree;
            while (current != null) {
                if (current.getRight() != null) {
                    current = current.getRight();
                } else if (current.getLeft() != null) {
                    current = current.getLeft();
                }
            }
            innerTree.setElement(current.getElement());
            current = innerTree;
            while (current != null) {
                if (current.getLeft() != null) {
                    if (current.getElement() > current.getLeft().getElement()) {
                        current.getLeft().setElement(current.getElement());
                        current = current.getLeft();
                    }
                } else if (current.getRight() != null) {
                    if (current.getElement() > current.getRight().getElement()) {
                        current.getRight().setElement(current.getElement());
                        current = current.getRight();
                    }
                }
            }
            return el;
        } else {
            return 0;
        }
    }

    @Override
    public void insert(int number) {

    }
}
