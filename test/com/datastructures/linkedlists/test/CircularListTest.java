package com.datastructures.linkedlists.test;

import com.datastructures.linkedlists.implementation.CircularLinkedList;
import com.datastructures.linkedlists.interfaces.ICircularList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.fail;

public class CircularListTest {

    private ICircularList<String> testList = new CircularLinkedList<String>("first");

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void test() {
        fail("Not yet implemented");
    }

}
