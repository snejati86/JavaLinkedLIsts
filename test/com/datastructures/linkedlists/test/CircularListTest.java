package com.datastructures.linkedlists.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.datastructures.linkedlists.implementation.CircularLinkedList;
import com.datastructures.linkedlists.interfaces.ICircularList;
import com.datastructures.linkedlists.nodes.DNode;

public class CircularListTest
{
    
    private ICircularList<String> testList = new CircularLinkedList<String>("first");
    
    @Before
    public void setUp() throws Exception
    {

    }

    @After
    public void tearDown() throws Exception
    {
    }

    @Test
    public void test()
    {
	fail("Not yet implemented");
    }

}
