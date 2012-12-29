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
        assertEquals(1, sqrt);
    }

    @Test
    public void testSqrt_epsilon() throws Exception {
        double maxDouble = Double.MAX_VALUE;
        double minDouble = Double.MIN_VALUE;

        double one = -1.0;
        String oneDoubleBit = Long.toBinaryString(Double.doubleToRawLongBits(one));
        System.out.println(one);
        System.out.println(oneDoubleBit);
        double nextOne = Double.longBitsToDouble(Double.doubleToRawLongBits(one) + 1);
        String nextOneDoubleBit = Long.toBinaryString(Double.doubleToRawLongBits(nextOne));
        System.out.println(nextOne);
        System.out.println(nextOneDoubleBit);
    }
}
