class Solution {
    public int missingNumber(int[] nums) {
        int xorr = nums.length;

        // XOR'ing two same numbers cancels them out and leave 0.
        // XOR'ing any number with 0 results in the orig number. 
        // XOR is associative and commutative. So, order doesn't matter.
        // So, if we XOR nums's content with numbers in the range [0,n]
        //  we will be left with the missing number.
        for (int i = 0; i < nums.length; i++) {
            xorr ^= i ^ nums[i];
        }

        return xorr;
    }
}
