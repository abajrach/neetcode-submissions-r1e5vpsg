class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numsSet = new HashSet<>();
        for(int n: nums) {
            numsSet.add(n);
        }

        int longestStreak = 0, streak = 0;
        for (int n: nums) {
            if (!numsSet.contains(n - 1)) { // beginning of seq found
                streak = 1;
                while(numsSet.contains(n + 1)) {
                    streak++;
                    n++;
                }
            }
            longestStreak = Math.max(longestStreak, streak);
        }

        return longestStreak;
    }
}
