package com.datastructures.linkedlists.implementation;

import com.datastructures.linkedlists.exception.LinkedListEmptyException;
import com.datastructures.linkedlists.interfaces.ISinglyList;
import com.datastructures.linkedlists.nodes.SNode;

public class Utils
{
    public static SNode<?> findNthLastElements(ISinglyList<?> list,int n) throws LinkedListEmptyException
    {
	if ( list != null )
	{
	    SNode<?> element = null;
	    if ( list.getSize() != 0 )
	    {
		
	    }
	    return element;
	}
	else
	{
	    throw new LinkedListEmptyException();
	}
    }

}
