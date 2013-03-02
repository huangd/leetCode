package leetcode;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * User: huangd
 * Date: 3/1/13
 * Time: 10:38 PM
 */
public class CountAndSayTest {
    @Test
    public void testCountAndSay() throws Exception {
        int n = 3;
        CountAndSay countAndSay = new CountAndSay();
        String say = countAndSay.countAndSay(n);
        assertEquals("21", say);
    }
}
