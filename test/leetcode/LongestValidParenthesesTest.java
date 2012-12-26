package leetcode;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

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
        assertEquals(22, length);

        s = "()(()";
        length = longestValidParentheses.longestValidParentheses(s);
        assertEquals(2, length);

        s = "(()(((()";
        length = longestValidParentheses.longestValidParentheses(s);
        assertEquals(2, length);
    }
}
