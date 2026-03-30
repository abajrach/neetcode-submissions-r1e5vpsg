/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {

    // Using minHeap to store the endTimes.
    // Poll minHeap when we see an interval whose start time is after the minHeap's smallest value 
    public int minMeetingRooms(List<Interval> intervals) {
        Collections.sort(intervals, (i1, i2) -> i1.start - i2.start);
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        for (Interval interval: intervals) {
            if (!minHeap.isEmpty() && minHeap.peek() <= interval.start) {
                minHeap.poll();
            }
            minHeap.offer(interval.end);
        }

        return minHeap.size();

    }
}
