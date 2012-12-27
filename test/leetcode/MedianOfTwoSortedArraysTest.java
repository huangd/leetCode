package leetcode;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * User: huangd
 * Date: 12/26/12
 * Time: 1:00 PM
 */
public class MedianOfTwoSortedArraysTest {
    @Test
    public void testFindMedianSortedArrays() throws Exception {
        int[] A = {1, 6, 7};
        int[] B = {2, 3, 4, 5, 8, 9};
        MedianOfTwoSortedArrays medianOfTwoSortedArrays = new MedianOfTwoSortedArrays();
        double median = medianOfTwoSortedArrays.findMedianSortedArrays(A, B);
        assertEquals(5.0, median);

        A = new int[]{5, 6, 7, 8};
        B = new int[]{1, 2, 3, 4};

        median = medianOfTwoSortedArrays.findMedianSortedArrays(A, B);
        assertEquals(4.5, median);
    }
}
