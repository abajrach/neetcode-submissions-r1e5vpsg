class Solution {
    public boolean isHappy(int n) {
        Set<Integer> seen = new HashSet<>();

        while (seen.add(n)) {
            int sum = 0;

            while (n != 0) {
                int lastDigit = n % 10; // 102 % 10 = 2
                sum += lastDigit * lastDigit;
                n = n / 10;             // Trim away last digit. 102 / 10 = 10
            }

            if (sum == 1) {
                return true;
            } else {
                n = sum;
            }
        }

        return false;
    }
}
