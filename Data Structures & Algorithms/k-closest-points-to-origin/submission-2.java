class Solution {

    // MinHeap
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) 
            -> Integer.compare((a[0]*a[0] + a[1] * a[1]), (b[0]*b[0] + b[1]*b[1])));

        for (int[] point: points) {
            minHeap.offer(point);
        }

        int[][] res = new int[k][2];
        int i = 0;
        while(i < k) {
            res[i++] = minHeap.poll();
        }

        return res;
    }
}
