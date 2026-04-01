class Solution {
    public int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            // Extract the bit at each position
            // Right shift (0-31) times and AND with 1 to determin 0/1
            int bit = (n >> i) & 1;

            // (bit << (31 - i)) is a way of placing the extracted bit to the reversed position
            // Todo: Understand why the result is being added to res
            res += (bit << (31 - i));
        }
        return res;
    }
}
