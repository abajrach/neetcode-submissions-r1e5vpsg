class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        dfs(nums, 0, subset, result);
        return result;
    }

    private void dfs(int[] nums, int idx, List<Integer> subset, List<List<Integer>> result) {
        if (idx >= nums.length) {
            result.add(new ArrayList<>(subset));
            return;
        }

        subset.add(nums[idx]);
        dfs(nums, idx + 1, subset, result);
        subset.remove(subset.size() - 1);
        dfs(nums, idx + 1, subset, result);
    }
}
