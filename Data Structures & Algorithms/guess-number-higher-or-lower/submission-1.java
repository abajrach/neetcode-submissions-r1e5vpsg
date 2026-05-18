/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int l = 1, r = n;
        while (l <= r) {
            int num = l + (r - l) / 2; // mid

            int resp = guess(num);

            if (resp == 0) {
                return num;
            }

            if (guess(num) == 1) {
                // 1 2 4 ... 10
                l = num + 1;
            } else if (guess (num) == -1) {
                r = num - 1;
            }
        }

        return -1;
    }
}