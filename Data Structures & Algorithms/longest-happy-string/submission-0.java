class Solution {
    public String longestDiverseString(int a, int b, int c) {
        // a = 3, b = 4, c = 2
        // bababcabc
        // ab

        StringBuilder res = new StringBuilder();
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((x,y) -> y[0] - x[0]);
        if (a > 0) maxHeap.offer(new int[] {a, 'a'});
        if (b > 0) maxHeap.offer(new int[] {b, 'b'});
        if (c > 0) maxHeap.offer(new int[] {c, 'c'});

        // a = 3, b = 2, c = 1
        while (!maxHeap.isEmpty()) {
            int[] first = maxHeap.poll();
            if (res.length() > 1 && res.charAt(res.length() - 1) == first[1] && res.charAt(res.length() - 2) == first[1]) {
                // Edge case: when we have last character left in maxHeap and if we try to poll() again, we get NPE
                if (maxHeap.isEmpty()) break;

                int[] second = maxHeap.poll();
                res.append((char) second[1]);
                second[0]--;
                if (second[0] > 0) {
                    maxHeap.offer(second);
                }
                maxHeap.offer(first);

            } else {
                res.append((char) first[1]);
                first[0]--;
                if (first[0] > 0) {
                    maxHeap.offer(first);
                }
            }
        }
        return res.toString();
    }
}