class Solution {
    // Same logic but without stack. O(n) time and O(1) space
    public int[] asteroidCollision(int[] asteroids) {
        int j = -1;

        for (int a : asteroids) {
            // 1 3 2 -3
            while (j >= 0 && asteroids[j] > 0 && a < 0) {
                if (Math.abs(a) > asteroids[j]) {
                    j--;    // Mark the previous (top of the stack) as destroyed
                } else if (Math.abs(a) < asteroids[j]) {
                    a = 0;  // Mark current asteroid as destroyed
                    break;
                } else {
                    j--;
                    a = 0;  // Mark current asteroid as destroyed
                    break;
                }
            }

            if (a != 0) {
                asteroids[++j] = a;
            }
        }

        return Arrays.copyOfRange(asteroids, 0, j + 1);
    }
}