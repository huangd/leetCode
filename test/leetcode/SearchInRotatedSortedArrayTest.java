package leetcode;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * User: huangd
 * Date: 1/1/13
 * Time: 6:37 PM
 */
public class SearchInRotatedSortedArrayTest {
    @Test
    public void testSearch() throws Exception {
        SearchInRotatedSortedArray searchInRotatedSortedArray = new SearchInRotatedSortedArray();
        int[] A = {1, 3, 5};
        int target = 4;
        int result = searchInRotatedSortedArray.search(A, target);
        assertEquals(-1, result);

        target = 5;
        result = searchInRotatedSortedArray.search(A, target);
        assertEquals(2, result);

        A = new int[]{4, 5, 6, 7, 0, 1, 2};
        target = 0;
        result = searchInRotatedSortedArray.search(A, target);
        assertEquals(4, result);
    }
}
