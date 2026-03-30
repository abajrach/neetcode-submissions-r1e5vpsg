class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> b - a);
        for (int n: nums) {
            maxHeap.offer(n);
        }

        int res = 0;
        while (k > 0) {
            res = maxHeap.poll();
            k--;
        }
        return res;
    }
}
