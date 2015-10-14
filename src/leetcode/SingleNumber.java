package leetcode;

import java.util.Arrays;

/**
 * Created by huangd on 10/13/15.
 */
public class SingleNumber {
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        int single = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                single = nums[i];
            } else {
                if (nums[i] != single) {
                    return single;
                }
            }
        }
        return single;
    }
}
