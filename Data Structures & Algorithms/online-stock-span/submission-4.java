class StockSpanner {

    // 100, 80, 60, 70, 60, 75, 85
    // 1.   1.  1.   2   1.  4.  6  

    /*
        100, 80, 60, 70, 60, 75

        (100,1), (80,1), (75,4)

        span = 1 + 1 + 2
    */

    // Holds [price, span]
    Stack<int[]> prices;
    public StockSpanner() {
        prices = new Stack<>();
    }
    
    public int next(int price) {
        int span = 1;
        while (!prices.isEmpty() && prices.peek()[0] <= price) {
            span += prices.pop()[1];
        }
        prices.push(new int[]{price, span});
        return span;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */