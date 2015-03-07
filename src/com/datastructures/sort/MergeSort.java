package com.datastructures.sort;

import java.util.Arrays;

/**
 * Created by nejasix on 2/10/15.
 */
public class MergeSort<T> implements Sort<T> {

    private T[] mergeArray(T[] left, T[] right) {
        Integer[] aggregatedArray = new Integer[left.length + right.length];
        Integer[] leftArray = Arrays.copyOf(left, left.length, Integer[].class);
        Integer[] rightArray = Arrays.copyOf(right, right.length, Integer[].class);
        int cursorLeft = 0;
        int cursorRight = 0;
        int i = 0;
        while (cursorLeft < leftArray.length && cursorRight < rightArray.length) {
            if (leftArray[cursorLeft] < rightArray[cursorRight]) {
                aggregatedArray[i++] = leftArray[cursorLeft++];
            } else {
                aggregatedArray[i++] = rightArray[cursorRight++];
            }

        }
        while (cursorLeft < leftArray.length) {
            aggregatedArray[i++] = leftArray[cursorLeft++];
        }
        while (cursorRight < rightArray.length) {
            aggregatedArray[i++] = rightArray[cursorRight++];
        }
        return (T[]) aggregatedArray;

    }

    @Override
    public T[] sort(T[] list) {

        if (list.length < 2) {
            return list;
        } else {
            T[] leftArray;
            T[] rightArray;
            int middleIndex = Math.round(list.length / 2);
            leftArray = (T[]) new Object[middleIndex];
            rightArray = (T[]) new Object[list.length - middleIndex];
            for (int i = 0; i < list.length; ++i) {
                if (i < middleIndex) {
                    leftArray[i] = list[i];
                } else {
                    rightArray[i - middleIndex] = list[i];
                }
            }
            T[] left = this.sort(leftArray);
            T[] right = this.sort(rightArray);
            return mergeArray(left, right);
            //ONE OR BELOW ONE ELEMENT;
        }
    }
}
