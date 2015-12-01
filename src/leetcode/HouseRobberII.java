package leetcode;

public class HouseRobberII {
    Map<String, Integer> cache;
    public int rob(int[] nums) {
        cache = new HashMap<String, Integer>();        
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);
        return Math.max(robCore(nums, 0, nums.length - 1), robCore(nums, 1, nums.length));

    }

    int robCore(int[] nums, int from, int to) {
        if (to - from < 0) throw new RuntimeException();
        if (to - from == 0) return 0;
        if (to - from == 1) return nums[from];
        if (to - from == 2) return Math.max(nums[from], nums[from + 1]);
        String cacheKey = from + "" + to;
        if (cache.get(cacheKey) != null) return cache.get(cacheKey);
        int money = Math.max(robCore(nums, from, to - 1), robCore(nums, from, to - 2) + nums[to - 1]);
        cache.put(cacheKey, money);
        return money;
    }
}
