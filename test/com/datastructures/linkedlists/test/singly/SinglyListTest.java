package com.datastructures.linkedlists.test.singly;

import static org.junit.Assert.*;

import java.math.BigInteger;
import java.security.SecureRandom;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.datastructures.linkedlists.exception.LinkedListEmptyException;
import com.datastructures.linkedlists.implementation.SinglyLinkedList;
import com.datastructures.linkedlists.interfaces.ISinglyList;
import com.datastructures.linkedlists.nodes.SNode;

public class SinglyListTest
{
    private ISinglyList<String> testList = new SinglyLinkedList<String>();
    
    private SecureRandom random = new SecureRandom();
    
    @After
    public void tearDown() throws LinkedListEmptyException
    {
	while(!testList.isEmpty())
	{
	    testList.removeFirst();
	}
    }
    
    @Before
    public void setUp()
    {
	for ( int i = 0 ; i < 100 ; ++i )
	{
	    if ( i == 99)
	    {
		testList.addLast(new SNode<String>("last"));
	    }
	    else if ( i == 0)
	    {
		testList.addLast(new SNode<String>("first"));
	    }
	    else
	    {
		testList.addLast(new SNode<String>(new BigInteger(130, random).toString(32)));
	    }
	}
    }
    
    /**
     * Test addition.
     * @throws LinkedListEmptyException
     */
    @Test
    public void testAddition() throws LinkedListEmptyException
    {
	/**
	 * Testing pre setup.
	 */
	assertEquals(testList.getSize(),100);
	
	/**
	 * Global references.
	 */
	String NEW="new first";
	String LAST ="new last";
	
	/**
	 * Testing add first.
	 */
	testList.addFirst(new SNode<String>(NEW));
	assertEquals(testList.getHead().getElement(),NEW);
	
	/**
	 * Testing add last.
	 */
	SNode<String> cursor = testList.getHead();
	while ( cursor.getNext() != null )
	{
	    cursor = cursor.getNext();
	}
	assertEquals(cursor.getElement(),"last");
	testList.addLast(new SNode<String>(LAST));
	cursor = cursor.getNext();
	assertEquals(cursor.getElement(),LAST);
	
	tearDown();
	assertTrue(testList.isEmpty());
	testList.addFirst(new SNode<String>(NEW));
	assertEquals(NEW,testList.getHead().getElement());
	
	tearDown();
	assertTrue(testList.isEmpty());
	testList.addLast(new SNode<String>(NEW));
	assertEquals(NEW,testList.getHead().getElement());
	
	
    }
    
    /**
     * Tests removal.
     * @throws Exception
     */
    @Test
    public void testRemoval() throws Exception
    {
	/**
	 * Testing pre setup.
	 */
	assertEquals(testList.getSize(),100);
	/**
	 * Assert last node is last.
	 */
	SNode<String> cursor = testList.getHead();
	while ( cursor.getNext() != null )
	{
	    cursor = cursor.getNext();
	}
	
	/**
	 * Last element is "last".
	 */
	assertEquals("last",cursor.getElement());
	testList.removeLast();
	assertEquals(testList.getSize(),99);
	
	cursor = testList.getHead();
	while ( cursor.getNext() != null )
	{
	    cursor = cursor.getNext();
	}
	
	assertNotSame("last",cursor.getElement());
    }
    
    /**
     * Tests exception.
     * @throws Exception
     */
    @Test(expected=LinkedListEmptyException.class)
    public void testEmptyListException() throws Exception
    {
	tearDown();
	testList.removeFirst();
    }
    
    /**
     * Tests the size method.
     */
    @Test
    public void testSize()
    {
	assertSame(100,testList.getSize());
    }
    
    /**
     * Tests the isEmpty
     * @throws LinkedListEmptyException 
     */
    @Test
    public void testIsEmpty() throws LinkedListEmptyException
    {
	assertFalse(testList.isEmpty());
	tearDown();
	assertTrue(testList.isEmpty());
    }

}
