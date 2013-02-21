package leetcode;

import org.junit.Test;

import static junit.framework.Assert.assertFalse;

/**
 * User: huangd
 * Date: 2/20/13
 * Time: 8:45 PM
 */
public class WordSearchTest {
    @Test
    public void testExist() throws Exception {
        char[][] board = {{'a'}};
        String word = "ab";
        WordSearch wordSearch = new WordSearch();
        assertFalse(wordSearch.exist(board, word));
    }
}
