package leetcode;

import org.junit.Test;

import static junit.framework.Assert.assertTrue;

/**
 * User: huangd
 * Date: 2/15/13
 * Time: 10:23 PM
 */
public class SearchA2DMatrixTest {
    @Test
    public void testSearchMatrix() throws Exception {
        int[][] matrix = {{1, 3}};
        int target = 1;
        SearchA2DMatrix searchA2DMatrix = new SearchA2DMatrix();
        assertTrue(searchA2DMatrix.searchMatrix(matrix, target));
    }
}
