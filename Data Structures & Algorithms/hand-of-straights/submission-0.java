class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) return false;

        // Keep frequency of each card
        Map<Integer, Integer> count = new HashMap<>();

        for (int n: hand) {
            count.put(n, count.getOrDefault(n, 0) + 1);
        }

        // Fill our minHeap with keys from hash map
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(count.keySet());

        while (!minHeap.isEmpty()) {
            int min = minHeap.peek();

            // form "group"
            for (int i = min; i < min + groupSize; i++) {
                if (!count.containsKey(i)) {
                    return false;
                }

                count.put(i, count.get(i) - 1);
                if (count.get(i) == 0) {
                    if (i != minHeap.peek()) {
                        return false;
                    }
                    minHeap.poll();
                }
            }
        }

        return true;
    }
}
