package leetcode;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * User: huangd
 * Date: 3/1/13
 * Time: 9:34 PM
 */
public class ClimbingStairsTest {
    @Test
    public void testClimbStairs() throws Exception {
        int n = 2;
        ClimbingStairs climbingStairs = new ClimbingStairs();
        int sum = climbingStairs.climbStairs(n);
        assertEquals(2, sum);
    }
}
