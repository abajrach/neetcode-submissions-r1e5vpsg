class Solution {
    public int[][] kClosest(int[][] points, int k) {
        /*
            [[0,2],[2,0],[2,2]], k = 2
              4.     4.   8
        */
        // (x1, y1) (x2, y2)

        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparing(a -> a[0]));
        for (int[] p: points) {
            // p = [0,2]
            int dist = p[0] * p[0] + p[1] * p[1];
            minHeap.offer(new int[]{ dist, p[0], p[1]});
        }

        int i = 0;
        int[][] res = new int[k][2];
        while (i < k) {
            int[] point = minHeap.poll();
            res[i++] = new int[] {point[1], point[2]};
        }
        
        return res;
    }
}
