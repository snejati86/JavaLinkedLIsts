package com.datastructures.sorts;

import com.datastructures.sort.MergeSort;
import com.datastructures.sort.Sort;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by nejasix on 2/10/15.
 */
public class SortTest {

    @Test
    public void testMergeSort() {
        Sort<Integer> sorter = new MergeSort<Integer>();
        Integer[] list = {2, 1, 6, 7, 22, 4};
        Integer[] sorted = sorter.sort(list);
        for (int i = 0; i < sorted.length; ++i) {
            if (i < sorted.length - 1)
                assertTrue(sorted[i] < sorted[i + 1]);
        }
    }
}
