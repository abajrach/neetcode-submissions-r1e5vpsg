class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        int i = 0, n = word1.length(), m = word2.length();

        while (i < n || i < m) {
            if (i < n) {
                sb.append(word1.charAt(i));
            }

            if (i < m) {
                sb.append(word2.charAt(i));
            }
            i++;
        }

        return sb.toString();
    }
}