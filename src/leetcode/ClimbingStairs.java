package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * User: huangd
 * Date: 3/1/13
 * Time: 9:23 PM
 */
public class ClimbingStairs {

    private Map<Integer, Integer> stairNumberToClimbWayMap = new HashMap<Integer, Integer>();

    public int climbStairs(int n) {
        if (stairNumberToClimbWayMap.get(n) != null) {
            return stairNumberToClimbWayMap.get(n);
        }
        int climbWays;
        if (n == 0 || n == 1) {
            climbWays = 1;
        } else {
            climbWays = climbStairs(n - 1) + climbStairs(n - 2);
        }
        stairNumberToClimbWayMap.put(n, climbWays);
        return climbWays;
    }
}
