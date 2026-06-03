class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        // [[4,1,2],[3,3,4]], capacity = 4
        // [1,2] 
        // [3,4]

        // Sort by "start"
        Arrays.sort(trips, (a,b) -> Integer.compare(a[1], b[1]));

        // Holds (end, passengers) of ALREADY picked up trip, ordered by 'end' 
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> Integer.compare(a[0], b[0]));
        int curPass = 0;

        for (int[] trip: trips) {
            int numPass = trip[0], start = trip[1], end = trip[2];

            // If the 'end' of previous trip is <= current trip's start, we have completed the previous
            // trip. Hence, we need to drop-off previous trip's passengers.
            while(!minHeap.isEmpty() && minHeap.peek()[0] <= start) {
                curPass -= minHeap.poll()[1];
            }

            curPass += numPass;
            if (curPass > capacity) {
                return false;
            }

            minHeap.offer(new int[]{end, numPass});
        }

        return true;
    }
}