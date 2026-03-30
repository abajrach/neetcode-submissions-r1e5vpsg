class Solution {
    public int maxProfit(int[] prices) {

        if (prices == null || prices.length < 2) return 0;
        int min = prices[0], maxP = 0;

        for (int i = 1; i < prices.length; i++) {
            maxP = Math.max(maxP, prices[i] - min);
            min = Math.min(prices[i], min);
        }

        return maxP;
    }
}
