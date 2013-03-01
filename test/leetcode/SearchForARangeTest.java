package leetcode;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * User: huangd
 * Date: 2/28/13
 * Time: 10:11 PM
 */
public class SearchForARangeTest {
    @Test
    public void testSearchRange() throws Exception {
        int[] A = new int[]{1};
        SearchForARange searchForARange = new SearchForARange();
        int[] range = searchForARange.searchRange(A, 1);
        assertEquals(0, range[0]);
        assertEquals(0, range[1]);
    }
}
