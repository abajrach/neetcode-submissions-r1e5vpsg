class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        // 1 4 3 2, h = 9
        // 1 2 2 1 
        int l = 1, r = Arrays.stream(piles).max().getAsInt(); // [1 2 3 4]
        int k = 1;
        while (l <= r) {
            int mid = l + (r - l) / 2; // possible eating speed (k)
            int totalTimeNeeded = 0;
            for (int p: piles) {
                totalTimeNeeded += (long) Math.ceil((double) p / mid);
            }

            if (totalTimeNeeded <= h) {
                r = mid - 1;
                k = mid;
            } else {
                l = mid + 1;
            }
        }

        return k;
    }
}
