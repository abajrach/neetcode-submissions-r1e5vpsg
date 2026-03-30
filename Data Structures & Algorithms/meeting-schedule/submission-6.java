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
    /*
        0                   30
          5   10
                  15  20
    */
    public boolean canAttendMeetings(List<Interval> intervals) {
        Collections.sort(intervals, (i1, i2) -> i1.start - i2.start);  // Sort in ascending order of start time

        for (int i = 1; i < intervals.size(); i++) {
            Interval i1 = intervals.get(i - 1);
            Interval i2 = intervals.get(i);

            if (i1.end > i2.start) {
                return false;
            }
        }
        return true;
    }
}
