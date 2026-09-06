class Solution {
    public boolean isSubsequence(String s, String t) {
        /*
            t: n e e t c o d e
               .
            s: n o d e
               .
        */

        int sIdx = 0, tIdx = 0;
        while (sIdx < s.length() && tIdx < t.length()) {
            char sChar = s.charAt(sIdx);
            char tChar = t.charAt(tIdx);

            if (sChar == tChar) {
                sIdx++;
            }
            tIdx++;

        }

        return sIdx == s.length();
    }
}