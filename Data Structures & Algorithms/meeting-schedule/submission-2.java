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

    // O(n^2)
    public boolean canAttendMeetings(List<Interval> intervals) {
        for (int i = 0; i < intervals.size(); i++) {
            Interval A = intervals.get(i);
            for (int j = i + 1; j < intervals.size(); j++) {
                Interval B = intervals.get(j);

                // If the meeting that ends earlier is greater than the meeting
                // that starts later.
                // Eg: (0, 30) and (10, 35)
                if (Math.min(A.end, B.end) > Math.max(A.start, B.start)) {
                    return false;
                }
            }
        }

        return true;
    }
}
