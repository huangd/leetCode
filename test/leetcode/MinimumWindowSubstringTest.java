package leetcode;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * User: huangd
 * Date: 12/27/12
 * Time: 12:15 PM
 */
public class MinimumWindowSubstringTest {
    @Test
    public void testMinWindow() throws Exception {
        String S = "aaabdabcefaecbef";
        String T = "abc";
        MinimumWindowSubstring minimumWindowSubstring = new MinimumWindowSubstring();
        String min = minimumWindowSubstring.minWindow(S, T);
        assertEquals("abc", min);
    }
}
