class Solution {

    // Brute force. time: O(n^2) space: O(m) where m = num of unique characters in s
    public int characterReplacement(String s, int k) {
        int res = 0;

        // A B A B B A
        // i.  j
        // 0.  2
        for (int i = 0; i < s.length(); i++) {
            Map<Character, Integer> count = new HashMap<>();
            int maxFreq = 0;

            for (int j = i; j < s.length(); j++) {
                count.put(s.charAt(j), count.getOrDefault(s.charAt(j), 0) + 1);
                maxFreq = Math.max(maxFreq, count.get(s.charAt(j)));
                if ((j - i + 1) - maxFreq <= k) {
                    res = Math.max(res, j - i + 1);
                }
            }
        }
        return res;
    }
}
