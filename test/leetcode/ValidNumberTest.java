package leetcode;

import org.junit.Test;

import static junit.framework.Assert.assertTrue;

/**
 * User: huangd
 * Date: 3/24/13
 * Time: 10:56 AM
 */
public class ValidNumberTest {
    @Test
    public void testIsNumber() throws Exception {
        ValidNumber validNumber = new ValidNumber();
        assertTrue(validNumber.isNumber("0.1"));
    }
}
