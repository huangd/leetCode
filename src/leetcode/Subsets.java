package leetcode;

public class Subsets {
    List<List<Integer>> results = new ArrayList<>(Arrays.asList(new ArrayList<>()));

    public List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(nums);
        if (nums.length == 0) return results;

        List<List<Integer>> addedResults = new ArrayList<>();
        for (List<Integer> result : results) {
            List<Integer> newResult = new ArrayList<>(result);
            newResult.add(nums[0]);
            addedResults.add(newResult);
        }
        results.addAll(addedResults);
        return subsets(Arrays.copyOfRange(nums, 1, nums.length));
    }
}
