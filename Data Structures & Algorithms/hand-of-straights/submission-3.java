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
            for (int n = min; n < min + groupSize; n++) {

                // Edge case: when there is a "hole". Ex: 6,7,9
                if (!count.containsKey(n)) {
                    return false;
                }

                count.put(n, count.get(n) - 1);
                if (count.get(n) == 0) {

                    // Edge case: smallest value isn't the one.....
                    if (n != minHeap.peek()) {
                        return false;
                    }
                    minHeap.poll();
                }
            }
        }

        return true;
    }
}
