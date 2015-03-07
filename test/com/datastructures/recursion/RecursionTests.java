package com.datastructures.recursion;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;


/**
 * Created by nejasix on 2/8/15.
 */
public class RecursionTests {
    @Test
    public void testFibonacchi() {
        assertEquals(fib(3), 4);
    }

    public int fib(int n) {
        if (n < 2) {
            return 1;
        } else {
            return fib(n - 1) + fib(n - 2);
        }

    }


    @Test
    public void testSubSetOfSet() {
        List<String> list = new ArrayList<String>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        List<String> subsets = printSubsets(list);
        for (String i : subsets) {
            System.out.println(i);
        }

    }


    public List<String> printSubsets(List<String> list) {
        List<String> subsets = new ArrayList<String>();
        if (list.size() < 2) {
            subsets.add(list.get(0));
            subsets.add("");
            return subsets;
        } else {
            String first = list.remove(0);
            subsets = printSubsets(list);
            List<String> newSubset = new ArrayList<String>();
            for (String i : subsets) {
                newSubset.add(i + " " + first);
            }
            subsets.addAll(newSubset);
        }
        return subsets;

    }

//    public void printSubsets(Set<String> set,String preSet)
//    {
//        if ( set != null )
//        {
//            if ( !set.isEmpty())
//            {
//                if ( set.size() > 1) {
//                    String first = set.iterator().next();
//                    System.out.print(preSet + ",");
//                    set.remove(first);
//                    printSubsets(set);
//                }
//                else{
//                    System.out.println(set.iterator().next());
//                }
//                //System.out.println(list[0]+ printSubsets(list));
//            }
//        }
//    }
}
