class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> index = new HashMap<>();
        
        // 3, 4, 5, 6
        /*
            3 -> 0 
        */
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (index.containsKey(diff)) {
                return new int[]{ index.get(diff), i};
            }
            index.put(nums[i], i);
        }

        return new int[0];
    }
}
