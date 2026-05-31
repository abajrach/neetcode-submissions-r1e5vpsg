class KthLargest {

    private List<Integer> store;
    private Integer k;
    
    public KthLargest(int k, int[] nums) {

        this.k = k;
        this.store = new ArrayList<>();

        for (int n: nums) {
            store.add(n);
        }
    }
    
    public int add(int val) {
        /*
            1 2 3 3 3 5 6 7 8

            1 2 3 3 3 5 6 7 8, k = 3,  [1 2 3 3 3 5 6 7 8]
        */
        store.add(val);
        store.sort(null);
        return store.get(store.size() - k);
    }
}
