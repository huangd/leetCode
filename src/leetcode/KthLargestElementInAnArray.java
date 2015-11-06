package leetcode;

public class KthLargestElementInAnArray {
    public int findKthLargest(int[] nums, int k) {
        // Should use a bounded priority queue to reduce the runtime to O(n) instead of sorting which is of course nLog(n).
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
}
