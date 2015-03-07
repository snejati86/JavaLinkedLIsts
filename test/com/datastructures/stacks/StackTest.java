package com.datastructures.stacks;

import com.datastructures.linkedlists.stacks.exceptions.FullStackException;
import com.datastructures.linkedlists.stacks.implementation.ArrayStack;
import com.datastructures.linkedlists.stacks.interfaces.Stack;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.EmptyStackException;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by nejasix on 2/8/15.
 */
public class StackTest {

    private Stack stack;

    @Before
    public void setUp() {
        stack = new ArrayStack<Integer>(5);
    }

    @After
    public void tearDown() {
        while (!stack.isEmpty()) {
            stack.pop();
        }
    }

    private boolean isMatchingTag(String tag, String tagTwo) {
        StringBuilder stringBuffer = new StringBuilder(tag);
        char[] toBeAppended = {'/'};
        stringBuffer.insert(1, toBeAppended);
        return tagTwo.equalsIgnoreCase(stringBuffer.toString());
    }

    private boolean isOpening(String tag) {
        return !(tag.charAt(1) == '/');
    }

    @Test
    public void testMatchingTag() {
        String test = "<body>";
        String test2 = "</body>";
        assertTrue(isMatchingTag(test, test2));
    }

    @Test
    public void testValidHtml() {
        String validHtml = "<body><h1>HELLO<h2></h2></h1></body>";
        String invalidHtml = "<body></h1>NO</h2></h1></body>";
        try {
            assertTrue(isValidHtml(validHtml.toCharArray()));
            assertFalse(isValidHtml(invalidHtml.toCharArray()));
        } catch (FullStackException e) {
            e.printStackTrace();
        }
    }

    private boolean isValidHtml(char[] htmlContent) throws FullStackException {
        Stack<String> stack = new ArrayStack<String>(100000);
        for (int i = 0; i < htmlContent.length - 1; ++i) {

            if (htmlContent[i] == '<') {
                StringBuilder st = new StringBuilder();
                while (htmlContent[i] != '>') {
                    st.append(htmlContent[i++]);
                }
                st.append(htmlContent[i]);
                if (isOpening(st.toString())) {
                    stack.push(st.toString());
                } else {
                    if (!stack.isEmpty()) {
                        String popped = stack.pop();
                        if (!isMatchingTag(popped, st.toString())) {
                            return false;
                        }
                    }
                }
            }
        }
        return stack.isEmpty();
    }

    @Test
    public void testStackIntegrity() throws Exception {
        stack.push(1);
        assertEquals(stack.pop(), 1);

    }

    @Test(expected = FullStackException.class)
    public void testFullStack() throws Exception {
        for (int i = 0; i < 7; ++i) {
            stack.push(i);
        }
    }

    @Test(expected = EmptyStackException.class)
    public void testEmptyStack() {
        stack.pop();
    }

}
