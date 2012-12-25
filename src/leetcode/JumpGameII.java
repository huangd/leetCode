package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * User: huangd
 * Date: 12/25/12
 * Time: 2:09 PM
 */
public class JumpGameII {

    private Map<Integer, Integer> cache;

    public int jump(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        cache = new HashMap<Integer, Integer>();
        return process(A, 0);
    }

    private int process(int[] A, int index) {
        if (index >= A.length - 1) {
            return 0;
        }

        Integer minSteps = cache.get(index);
        if (minSteps == null) {
            minSteps = Integer.MAX_VALUE - 1;//Should pay attention to overflow
            int maxJumpNumber = A[index];
            for (int jumpNumber = maxJumpNumber; jumpNumber > 0; --jumpNumber) {
                int steps = process(A, index + jumpNumber) + 1;
                if (steps < minSteps) {
                    minSteps = steps;
                }
            }
        }
        cache.put(index, minSteps);
        return minSteps;
    }
}
