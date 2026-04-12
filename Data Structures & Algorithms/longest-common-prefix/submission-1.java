class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 1) return strs[0];

        Arrays.sort(strs);  // O(nlogn * m)

        int shortestLen = Math.min(strs[0].length(), strs[strs.length - 1].length());

        // bat, bag, bank, band
        //   i               i
        // shortestLen = 3
        for (int i = 0; i < shortestLen; i++) {
            if (strs[0].charAt(i) != strs[strs.length - 1].charAt(i)) {
                return strs[0].substring(0, i);
            }
        }

        return strs[0];
    }
}