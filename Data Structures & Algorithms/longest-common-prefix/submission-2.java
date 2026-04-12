class Solution {
     // Horizontal scanning. O (m * n)
    public String longestCommonPrefix(String[] strs) {
        // bank, bat, bag, band
        //        i
        // prefix = bank
        String prefix = strs[0];

        for (int i = 1; i < strs.length; i++) {
            int j = 0;
            while (j < Math.min(prefix.length(), strs[i].length())) {
                if (strs[i].charAt(j) != prefix.charAt(j)) {
                    break;
                }
                j++;
            }
            prefix = prefix.substring(0, j);
        }
        return prefix;
    }
}