package leetcode;

import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.Assert.assertEquals;

/**
 * User: huangd
 * Date: 1/29/13
 * Time: 9:53 PM
 */
public class TriangleTest {
    @Test
    public void testMinimumTotal() throws Exception {
        ArrayList<Integer> arrayListOne = new ArrayList<Integer>();
        arrayListOne.add(1);
        ArrayList<Integer> arrayListTwo = new ArrayList<Integer>();
        arrayListTwo.add(2);
        arrayListTwo.add(3);

        ArrayList<ArrayList<Integer>> arrayListArrayList = new ArrayList<ArrayList<Integer>>();
        arrayListArrayList.add(arrayListOne);
        arrayListArrayList.add(arrayListTwo);

        Triangle triangle = new Triangle();
        int minTotal = triangle.minimumTotal(arrayListArrayList);
        assertEquals(3, minTotal);
    }
}
