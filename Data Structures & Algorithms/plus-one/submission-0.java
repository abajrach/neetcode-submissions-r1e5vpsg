class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;

        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                // we are done. 
                return digits;
            }
            digits[i] = 0;
        }

        // digits = 999. result = 1000
        int[] result = new int[n + 1];
        result[0] = 1;
        return result;
    }
}
