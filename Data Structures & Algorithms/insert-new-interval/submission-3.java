class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        for (int[] interval: intervals) {
            if (newInterval == null || interval[1] < newInterval[0]) { // No overlap. interval is before newInterval
                result.add(interval);
            } else if (interval[0] > newInterval[1]) { // No overlap. interval is after newInterval
                result.add(newInterval);
                result.add(interval);
                newInterval = null;
            } else {    // Has overlap
                newInterval[0] = Math.min(interval[0], newInterval[0]);
                newInterval[1] = Math.max(interval[1], newInterval[1]);
            }
        }
        if (newInterval != null) {
            result.add(newInterval);
        }
        return result.toArray(new int[result.size()][]);
    }
}
