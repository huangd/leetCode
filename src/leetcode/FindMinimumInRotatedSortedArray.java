package leetcode;

import java.util.Arrays;

/**
 * Created by huangd on 10/18/15.
 */
public class FindMinimumInRotatedSortedArray {
    public int findMin(int[] nums) {
        int mid = nums[nums.length / 2];
        int first = nums[0];
        int last = nums[nums.length - 1];

        if (mid > first && mid > last) {
            return findMin(Arrays.copyOfRange(nums, nums.length / 2 + 1, nums.length));
        }
        if (mid < first && mid < last) {
            return findMin(Arrays.copyOfRange(nums, 0, nums.length / 2 + 1));
        }

        return Math.min(first, last);
    }
}
