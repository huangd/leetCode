package leetcode;

import java.util.Arrays;

/**
 * User: huangd
 * Date: 1/28/13
 * Time: 8:33 PM
 */
public class ThreeSumClosest {
    public int threeSumClosest(int[] num, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        Arrays.sort(num);
        return process(num, target);
    }

    private int process(int[] num, int target) {
        //NOT use Integer.MAX_VALUE to prevent overflow
        int closetSum = num[0] + num[1] + num[2];
        for (int i = 0; i < num.length; ++i) {
            int j = i + 1;
            int k = num.length - 1;
            while (j < k) {
                int currentSum = num[i] + num[j] + num[k];
                if (Math.abs(currentSum - target) < Math.abs(closetSum - target)) {
                    closetSum = currentSum;
                }
                if (currentSum < target) {
                    j++;
                } else if (currentSum > target) {
                    k--;
                } else {
                    j++;
                    k--;
                }
            }
        }
        return closetSum;
    }
}
