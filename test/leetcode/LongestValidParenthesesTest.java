package leetcode;

import org.junit.Test;

/**
 * User: huangd
 * Date: 12/25/12
 * Time: 5:17 PM
 */
public class LongestValidParenthesesTest {
    @Test
    public void testLongestValidParentheses() throws Exception {
        LongestValidParentheses longestValidParentheses = new LongestValidParentheses();
        String s = ")(((((()())()()))()(()))(";
        int length = longestValidParentheses.longestValidParentheses(s);
    }
}
