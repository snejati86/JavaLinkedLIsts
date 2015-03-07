package com.datastructures.trees.implementation;

import com.datastructures.trees.interfaces.Tree;
import com.datastructures.trees.interfaces.TreeNode;

import java.util.Iterator;

/**
 * Created by nejasix on 2/22/15.
 */
public class GeneralTree<E> implements Tree<E> {
    private int mSize;

    private TreeNode<E> root;

    @Override
    public int size() {
        return mSize;
    }

    @Override
    public boolean isEmpty() {
        return (mSize == 0);
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public TreeNode<E> getRoot() {
        return root;
    }

    public void setRoot(TreeNode<E> root) {
        this.root = root;
    }

    @Override
    public E replace(TreeNode<E> node, E element) {
        return null;
    }

    private TreeNode<E> searchNode(TreeNode<E> current, TreeNode<E> node) {
        TreeNode<E> goal = null;
        if (node.equals(current)) {
            return current;
        } else {
            for (TreeNode<E> iterator : current.getChildren()) {
                TreeNode<E> result = searchNode(iterator, node);
                if (result != null) {
                    goal = result;
                    break;
                }
            }
        }
        return goal;
    }

    public boolean add(E element, TreeNode<E> placement) {
        boolean result = false;
        TreeNode<E> eTreeNode = searchNode(root, placement);
        if (eTreeNode != null) {
            eTreeNode.setElement(element);
            result = true;
        }
        return result;
    }
}
