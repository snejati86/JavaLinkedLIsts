package com.datastructures.strings;

import org.junit.Test;

/**
 * Created by nejasix on 3/2/15.
 */
public class StringTests {
    @Test
    public void reverseString() throws Exception {
        char[] first = {'a', 'b', 'c'};
        char[] second = {'c', 'b', 'a'};
        char[] reverse = reverseArray(first);

    }


    private char[] reverseArray(char[] input) throws Exception {

        if (input != null) {
            if (input.length > 2) {
                for (int i = 0; i < Math.round(input.length - 1 / 2); ++i) {
                    char temp = input[i];
                    input[i] = input[input.length - 1 - i];
                    input[input.length - 1 - i] = temp;
                }
                return input;
            } else {
                return input;
            }
        } else {
            throw new Exception("The input can not be null.");
        }
    }
}
