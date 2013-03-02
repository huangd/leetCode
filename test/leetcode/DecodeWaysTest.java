package leetcode;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * User: huangd
 * Date: 3/2/13
 * Time: 1:56 PM
 */
public class DecodeWaysTest {
    @Test
    public void testNumDecodings() throws Exception {
        String s = "10";
        DecodeWays decodeWays = new DecodeWays();
        int ways = decodeWays.numDecodings(s);
        assertEquals(1, ways);
    }
}
