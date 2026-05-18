class Solution {
    public int shipWithinDays(int[] weights, int days) {
        // 2 4 6 1 3 10, days = 4
        // l = 10, r = 26
        int l = 0, r = 0;
        int minCap = 0;
        for (int w: weights) {
            l = Math.max(l, w);
            r += w;
        }

        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (canShipWithinDays(weights, days, mid)) {
                minCap = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return minCap;
    }

    private boolean canShipWithinDays(int[] weights, int days, int cap) {
        int ships = 1, curCap = cap;

        for (int w: weights) {
            if (curCap - w < 0) {
                ships++;
                if (ships > days) {
                    return false;
                }
                curCap = cap;
            }
            curCap -= w;
        }
        return true;
    }
}