class Solution {

    // Using maxHeap to throw out (poll()) bigger values (distances)
    public int[][] kClosest(int[][] points, int k) {

        // Integer.compare(a,b) -> if a < b, returns -1, else if a > b returns 1. else 0
        // we only need to do x^2 + y^2 to calculate distance. no need for sqrt.
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a,b) 
                -> Integer.compare(b[0]*b[0] + b[1]*b[1], a[0]*a[0] + a[1]*a[1]));

        for(int[] point: points) {
            maxHeap.offer(point);
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        /*
            res will be k X 2 matrix like: where k = 3
            1 2
            3 3
            1 6
        */
        int[][] res = new int[k][2];
        int i = 0;
        while(!maxHeap.isEmpty()) {
            res[i++] = maxHeap.poll();
        }

        return res;

    }


}
