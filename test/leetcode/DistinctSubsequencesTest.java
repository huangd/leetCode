package leetcode;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * User: huangd
 * Date: 12/23/12
 * Time: 9:50 PM
 */
public class DistinctSubsequencesTest {
    @Test
    public void testNumDistinctSmall() throws Exception {
        DistinctSubsequences distinctSubsequences = new DistinctSubsequences();
        int totalNumber = distinctSubsequences.numDistinct("ccc", "c");
        assertEquals(3, totalNumber);
        totalNumber = distinctSubsequences.numDistinct("ddd", "dd");
        assertEquals(3, totalNumber);
    }

    @Test
    public void testNumDistinctLarge() throws Exception {
        DistinctSubsequences distinctSubsequences = new DistinctSubsequences();
        int totalNumber = distinctSubsequences.numDistinct("aabdbaabeeadcbbdedacbbeecbabebaeeecaeabaedadcbdbcdaabebdadbbaeabdadeaabbabbecebbebcaddaacccebeaeedababedeacdeaaaeeaecbe", "bddabdcae");
        System.out.print(totalNumber);
    }
}
