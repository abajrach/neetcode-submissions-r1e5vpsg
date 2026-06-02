class Solution {
    public String reorganizeString(String s) {
        int[] freq = new int[26];
        for (char ch: s.toCharArray()) {
            freq[ch - 'a']++;
        }

        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a,b) -> b[0] - a[0]);
        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) {
                maxHeap.offer(new int[] {freq[i], i}); // 'i' is index and used to derive character
            }
        }

        StringBuilder res = new StringBuilder();
        int[] prev = null;
        while (!maxHeap.isEmpty() || prev != null) {

            /* 
                aaab -> aba

            */
            if (prev != null && maxHeap.isEmpty()) {
                return "";
            }

            int[] cur = maxHeap.poll(); // [2, 1] -> 2 b's
            res.append((char) (cur[1] + 'a'));
            cur[0]--;

            if (prev != null) {
                maxHeap.offer(prev);
                prev = null;
            }

            if (cur[0] > 0){
                prev = cur;
            }
        }

        return res.toString();
    }
}