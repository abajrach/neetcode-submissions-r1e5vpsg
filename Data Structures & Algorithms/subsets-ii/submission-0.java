class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);
        backtrack(0, nums, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int idx, int[] nums, List<Integer> subset, List<List<Integer>> result) {
        if (idx == nums.length) {
            result.add(new ArrayList<>(subset));
            return;
        }

        subset.add(nums[idx]);
        backtrack(idx + 1, nums, subset, result);
        subset.remove(subset.size() - 1);

        while (idx + 1 < nums.length && nums[idx] == nums[idx + 1]) {
            idx++;
        }
        backtrack(idx + 1, nums, subset, result);
    }
}
