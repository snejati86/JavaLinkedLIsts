package com.datastructures.trees;

import com.datastructures.trees.implementation.BTNode;
import com.datastructures.trees.implementation.GeneralTree;
import com.datastructures.trees.implementation.Node;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 * Created by nejasix on 2/22/15.
 */
public class TreeTests {

    GeneralTree<String> tree;

    @Before
    public void setUp() {
        tree = new GeneralTree<String>();
        Node<String> node = new Node();
        node.setElement("A");
        List<Node<String>> children = new ArrayList<Node<String>>();
        children.add(new Node<String>().setElement("B"));
        children.add(new Node<String>().setElement("C"));
        children.add(new Node<String>().setElement("D"));

        node.setChildren(children);
    }

    @Test
    public void testInsert() {
        int[] testArray = {1, 2, 3, 4, 5, 6, 7};
        BTNode node = createNode(testArray);
        LinkedList<BTNode> current = new LinkedList<BTNode>();
        current.add(node);
        while (!current.isEmpty()) {
            BTNode pop = current.pop();
            System.out.println(pop.getElement());
            if (pop.getLeft() != null) {
                current.add(pop.getLeft());
            }
            if (pop.getRight() != null) {
                current.add(pop.getRight());
            }

        }
    }

    private BTNode createNode(int[] array) {
        BTNode currentNode = new BTNode();

        if (array.length > 1) {
            int mid = Math.round(array.length / 2);
            currentNode.setElement(array[mid]);
            int[] leftArray = Arrays.copyOfRange(array, 0, mid);
            int[] rightArray = Arrays.copyOfRange(array, mid + 1, array.length);
            currentNode.setLeft(createNode(leftArray));
            currentNode.setRight(createNode(rightArray));
        } else {
            currentNode.setElement(array[0]);
        }
        return currentNode;
    }

    private boolean isReflective(BTNode left, BTNode right) {
        boolean result = false;
        if (left == null && right == null) {
            result = true;
        } else {
            if (left.getElement() == right.getElement()) {
                result = (isReflective(left.getLeft(), right.getRight()) && isReflective(left.getRight(), left.getLeft()));
            }
        }
        return result;
    }

    @Test
    public void testReflectiveTrees() {
        BTNode leftTree = new BTNode();
        leftTree.setElement(1);
        leftTree.setRight(new BTNode(3));
        leftTree.setLeft(new BTNode(2));

        BTNode rightTree = new BTNode(1);
        rightTree.setLeft(new BTNode(3));
        rightTree.setRight(new BTNode(2));

        boolean reflective = isReflective(leftTree, rightTree);
        assertTrue(reflective);

    }
}
