package leetcode;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * User: huangd
 * Date: 1/1/13
 * Time: 1:15 PM
 */
public class ContainerWithMostWaterTest {
    @Test
    public void testMaxArea() throws Exception {
        ContainerWithMostWater containerWithMostWater = new ContainerWithMostWater();
        int[] height = {1, 1};
        int max = containerWithMostWater.maxArea(height);
        assertEquals(1, max);

        height = new int[]{1, 2};
        max = containerWithMostWater.maxArea(height);
        assertEquals(1, max);
    }
}
