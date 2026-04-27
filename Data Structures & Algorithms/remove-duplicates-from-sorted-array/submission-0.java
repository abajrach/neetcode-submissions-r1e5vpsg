class Solution {
    public int removeDuplicates(int[] nums) {
        // int i = 0;

        // while (i < nums.length - 1) {
        //     while(nums[i] == nums[i + 1]) {
        //         i++;
        //     }
        //     i++;

        // }

        TreeSet<Integer> unique = new TreeSet<>();
        for (int n: nums) {
            unique.add(n);
        }

        int i = 0;
        for (int n: unique) {
            nums[i++] = n;
        }
        
        return unique.size();
    }
}