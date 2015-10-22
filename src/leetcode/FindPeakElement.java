public class FindPeakElement {
  public int findPeakElement(int[] nums) {
    if (nums.length == 0 || nums.length == 1) {
      return 0;
    }
    if (nums.length == 2) {
      return nums[0] > nums[1] ? 0 : 1;
    }
    for (int i = 0; i < nums.length; i++) {
      int prev = i - 1 < 0 ? Integer.MIN_VALUE : nums[i - 1];
      int post = i + 1 >= nums.length ? Integer.MIN_VALUE : nums[i + 1];
      if (prev < nums[i] && nums[i] > post) {
        return i;
      }
    }
    return Integer.MIN_VALUE;
  }
}
