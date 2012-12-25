package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * User: huangd
 * Date: 12/25/12
 * Time: 1:46 PM
 */
public class JumpGame {

    private Map<Integer, Boolean> cache;

    public boolean canJump(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        cache = new HashMap<Integer, Boolean>();
        return process(A, 0);
    }

    private boolean process(int[] A, int index) {
        if (index >= A.length - 1) {
            return true;
        }

        Boolean isDoable = cache.get(index);
        if (isDoable == null) {
            isDoable = false;
            int maxJumpNumber = A[index];
            for (int jumpNumber = maxJumpNumber; jumpNumber > 0; --jumpNumber) {
                if (process(A, index + jumpNumber)) {
                    isDoable = true;
                    break;
                }
            }
        }
        cache.put(index, isDoable);
        return isDoable;
    }
}
