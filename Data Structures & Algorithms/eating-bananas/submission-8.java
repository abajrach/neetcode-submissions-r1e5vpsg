class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        // 1 4 3 2, h = 9
        int l = 1, r = Arrays.stream(piles).max().getAsInt();
        int k = 1;
        while (l <= r) {
            int mid = l + (r - l) / 2; // Eating speed
            long totalTime = 0;
            for (int p: piles) {
                totalTime += (long) Math.ceil((double) p / mid);
            }
            if (totalTime <= h) {
                r = mid - 1;
                k = mid;
            } else {
                l = mid + 1;
            }
        }
        return k;
    }
}
