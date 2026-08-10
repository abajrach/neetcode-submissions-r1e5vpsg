class StockSpanner {

    // 100, 80, 60, 70, 60, 75, 85
    // 1.   1.  1.   2   1.  4.  6  

    /*
        100, 80 60 70
        0.          
    */
    List<Integer> list;
    public StockSpanner() {
        list = new ArrayList<>();
    }
    
    public int next(int price) {
        list.add(price);

        int span = 0;
        for (int i = list.size() - 1; i >= 0; i--) {
            if (list.get(i) > price) {
                break;
            }
            span++;
        }

        return span;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */