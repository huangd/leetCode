package leetcode;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * User: huangd
 * Date: 12/25/12
 * Time: 3:29 PM
 */
public class LongestCommonPrefixTest {
    @Test
    public void testLongestCommonPrefix() throws Exception {
        LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();
        String[] strs = {"aa", "aa"};
        String prefix = longestCommonPrefix.longestCommonPrefix(strs);
        assertEquals("aa", prefix);

        strs = new String[]{"abab", "aba", "abc"};
        prefix = longestCommonPrefix.longestCommonPrefix(strs);
        assertEquals("ab", prefix);
    }
}
