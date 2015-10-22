package leetcode;

public class SearchInRotatedSortedArrayII {
    public boolean search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] == target || nums[start] == target || nums[end] == target) return true;
            // Left side is already sorted
            if (nums[mid] > nums[start] && nums[mid] > nums[end]) {
                if (target < nums[mid] && target >= nums[start]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
                // Right side is already sorted
            } else if (nums[mid] < nums[start] && nums[mid] < nums[end]) {
                if (target > nums[mid] && target <= nums[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
                // Could not eliminate half of the list so only reduce end by 1
            } else {
                end -= 1;
            }
        }
        return false;
    }
}
