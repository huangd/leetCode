package leetcode;

import static junit.framework.Assert.assertTrue;

/**
 * User: huangd
 * Date: 2/15/13
 * Time: 9:19 PM
 */
public class ScrambleStringTest {
    @org.junit.Test
    public void testIsScramble() throws Exception {
        String s1 = "abb";
        String s2 = "bab";

        ScrambleString scrambleString = new ScrambleString();
        assertTrue(scrambleString.isScramble(s1, s2));
    }
}
