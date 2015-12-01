package leetcode;

/**
 * User: huangd
 * Date: 2/28/13
 * Time: 9:45 PM
 */
public class SearchForARange {
    int[] nums;
    int target;
    public int[] searchRange(int[] nums, int target) {
        this.nums = nums;
        this.target = target;
        int lower = getLowerBound(0, nums.length);
        if (lower == -1) {
            return new int[]{-1, -1};

        } else {
            int upper = getUpperBound(0, nums.length);
            return new int[]{lower, upper};

        }
    }

    int getLowerBound(int from, int to) {
        if (from >= to) {
            if (to < nums.length && nums[to] == target) {
                return to;

            } else {
                return -1;

            }

        } 
        int mid = (from + to) / 2;
        if (nums[mid] >= target) return getLowerBound(from, mid);
        if (nums[mid] < target) return getLowerBound(mid + 1, to);
        throw new RuntimeException();

    }

    int getUpperBound(int from, int to) {
        if (from >= to) return from - 1;
        int mid = (from + to) / 2;
        if (nums[mid] <= target) return getUpperBound(mid + 1, to);
        if (nums[mid] > target) return getUpperBound(from, mid);
        throw new RuntimeException();

    }
}
