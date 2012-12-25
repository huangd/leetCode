package leetcode;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * User: huangd
 * Date: 12/25/12
 * Time: 2:19 PM
 */
public class JumpGameIITest {
    @Test
    public void testJump() throws Exception {
        JumpGameII jumpGameII = new JumpGameII();
        int[] A = {1, 2, 0, 1};
        int minSteps = jumpGameII.jump(A);
        assertEquals(2, minSteps);
    }
}
