class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) break; // If the smallest number in the list is positive, then there is no answer

            if (i > 0 && nums[i] == nums[i - 1]) continue; // Skip duplicates
            int left = i + 1, right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum < 0) {
                    left++;
                } else if (sum > 0) {
                    right--;
                } else {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;

                    // We need to remove duplicate answer. Example: [-2, 0, 0, 2, 2]
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                }
            }
        }

        return result;
    }
}
