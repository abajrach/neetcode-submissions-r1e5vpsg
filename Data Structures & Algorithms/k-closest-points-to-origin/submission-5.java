class Solution {
    // Using maxHeap
    public int[][] kClosest(int[][] points, int k) {
        /*
            [[0,2],[2,0],[2,2]], k = 2
              4.     4.   8
        */
        // (x1, y1) (x2, y2)
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a,b) -> Integer.compare(
            b[0]*b[0] + b[1]*b[1],
            a[0]*a[0] + a[1]*a[1]));

        for (int[] point: points) {
            maxHeap.offer(point);
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        int[][] res = new int[k][2];
        for (int i = 0; i < k; i++) {
            res[i] = maxHeap.poll();
        }
        return res;

    }
}
