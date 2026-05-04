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
        int l = 0, r = n;

        while (l <= r) {
            int pick = l + (r - l)/2;
            int ans = guess(pick);
            // 1 2 3 4 5
            if (ans == -1) {
                r = pick - 1;
            } else if (ans == 1) {
                l = pick + 1;
            } else {
                return pick;
            }
        }

        return -1;
    }
}