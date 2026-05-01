class StockSpanner {

    private List<Integer> prices;

    // Brute force
    public StockSpanner() {
        prices = new ArrayList<>();    
    }
    
    public int next(int price) {
        int days = 1;
        for (int i = prices.size() - 1; i >= 0; i--) {
            if (prices.get(i) <= price) {
                days++;
            } else {
                break;
            }
        }
        prices.add(price);

        return days;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */