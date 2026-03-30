class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // 1, 2, 2, 3, 3, 3

        // 1 -> 1
        // 2 -> 2
        Map<Integer, Integer> count = new HashMap<>();
        for (int n: nums) {
            count.put(n, count.getOrDefault(n, 0) + 1);
        }

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        for (Map.Entry<Integer, Integer> entry: count.entrySet()) {
            minHeap.offer(new int[] {entry.getValue(), entry.getKey()});

            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        int[] result = new int[k];
        int i = 0;
        while(!minHeap.isEmpty()){
            result[i++] = minHeap.poll()[1];
        }

        return result;
    }
}
