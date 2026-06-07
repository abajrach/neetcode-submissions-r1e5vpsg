class Solution {

    // Using two heaps to hold indexes
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        // Holds project indexes ordered by minimum capital
        PriorityQueue<Integer> minCapital = new PriorityQueue<>((a,b) -> capital[a] - capital[b]);

        // Holds potential profit that can be taken, sorted by maximum profit first
        PriorityQueue<Integer> maxProfit = new PriorityQueue<>((a,b) -> profits[b] - profits[a]);

        for (int i = 0; i < capital.length; i++) {
            minCapital.offer(i);
        }

        for (int i = 0; i < k; i++) {
            while (!minCapital.isEmpty() && capital[minCapital.peek()] <= w) {
                maxProfit.offer(minCapital.poll()); // Both heaps hold indexes only
            }

            if (maxProfit.isEmpty()) {
                break;
            }

            w += profits[maxProfit.poll()];
        }

        return w;
    }
}