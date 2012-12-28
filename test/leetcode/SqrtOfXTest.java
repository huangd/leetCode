package leetcode;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * User: huangd
 * Date: 12/27/12
 * Time: 10:04 PM
 */
public class SqrtOfXTest {
    @Test
    public void testSqrt() throws Exception {
        SqrtOfX sqrtOfX = new SqrtOfX();
        int x = 2;
        int sqrt = sqrtOfX.sqrt(x);

        int maxInt = Integer.MAX_VALUE;
        int minInt = Integer.MIN_VALUE;
        double maxDouble = Double.MAX_VALUE;
        double minDouble = Double.MIN_VALUE;
        double maxIntDouble = (double) maxInt;
        assertEquals(1, sqrt);
    }
}
