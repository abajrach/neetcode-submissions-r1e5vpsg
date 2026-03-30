class Solution {
    public int longestConsecutive(int[] nums) {

        // Set helps us check for num in O(1)
        Set<Integer> numsSet = new HashSet<>();
        for(int n: nums) {
            numsSet.add(n);
        }

        int longestStreak = 0;
        
        // Make sure to iterate over the set and not the list to account for duplicates
        for (int n: numsSet) {
            if (!numsSet.contains(n - 1)) { // beginning of seq found
                int streak = 1;
                while(numsSet.contains(n + streak)) {
                    streak++;
                }
                longestStreak = Math.max(longestStreak, streak);
            }
        }

        return longestStreak;
    }
}
