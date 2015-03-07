package com.datastructures.trees.implementation;

/**
 * Created by nejasix on 2/26/15.
 */
public class BTNode {

    private int element;
    private BTNode left;
    private BTNode right;

    public BTNode(int el) {
        this.element = el;
    }

    public BTNode() {
        //Empty Constructor.
    }

    public BTNode getLeft() {
        return left;
    }

    public void setLeft(BTNode left) {
        this.left = left;
    }

    public int getElement() {
        return element;
    }

    public void setElement(int element) {
        this.element = element;
    }

    public BTNode getRight() {
        return right;
    }

    public void setRight(BTNode right) {
        this.right = right;
    }

}
