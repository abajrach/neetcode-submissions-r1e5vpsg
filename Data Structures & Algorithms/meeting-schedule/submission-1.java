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

    // By Sorting input. O(nlogn)
    public boolean canAttendMeetings(List<Interval> intervals) {
        Collections.sort(intervals, Comparator.comparingInt(i -> i.start));

        for (int i = 1; i < intervals.size(); i++) {
            Interval A = intervals.get(i - 1);
            Interval B = intervals.get(i);
            if (A.end > B.start) {
                return false;
            }
        }

        return true;
    }
}
