class Solution {

    // maxHeap
    public int findKthLargest(int[] nums, int k) {
        // [1,1,2,3,4,5,5] k = 3, ans = 4

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> Integer.compare(b,a));

        for (int n: nums) {
            maxHeap.offer(n);
        }

        for (int i = 0; i < k - 1; i++) {
            maxHeap.poll();
        }

        return maxHeap.peek();

    }
}
