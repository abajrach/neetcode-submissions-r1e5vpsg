class Solution {
    public int compress(char[] chars) {
        int i = 0, j = 0, k = 0;
        int n = chars.length;

        while (i < n) {
            chars[k++] = chars[i];
            j = i + 1;
            while (j < n && chars[i] == chars[j]) {
                j++;
            }

            if (j - i > 1) {
                String cnt = String.valueOf(j - i);
                for (char ch: cnt.toCharArray()) {
                    chars[k++] = ch;
                }
            }

            i = j;
        }

        return k;
    }
}