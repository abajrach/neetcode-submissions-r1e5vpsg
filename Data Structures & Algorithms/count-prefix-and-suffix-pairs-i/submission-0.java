class Solution {
    public int countPrefixSuffixPairs(String[] words) {
        int count = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (isPrefix(words[i], words[j]) && isSuffix(words[i], words[j])) {
                    count++;
                }
            }
        }
        return count;
    }

    private boolean isPrefix(String s1, String s2) {
        if (s2.length() < s1.length()) return false;

        return s2.substring(0, s1.length()).equals(s1);
    }

    private boolean isSuffix(String s1, String s2) {
        if (s2.length() < s1.length()) return false;

        return s2.substring(s2.length() - s1.length(), s2.length()).equals(s1);
    }
}