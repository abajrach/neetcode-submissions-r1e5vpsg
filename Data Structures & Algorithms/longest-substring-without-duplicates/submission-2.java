class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();

        int l = 0, maxL = 0;
        for (int r = 0; r < s.length(); r++) {
            if (map.containsKey(s.charAt(r))) {
                // Math.max is important here so that we don't move the
                // left pointer backwards. example: abba
                l = Math.max(map.get(s.charAt(r)) + 1, l);
            }
            map.put(s.charAt(r), r);
            maxL = Math.max(maxL, r - l + 1);
        }

        return maxL;
    }
}
