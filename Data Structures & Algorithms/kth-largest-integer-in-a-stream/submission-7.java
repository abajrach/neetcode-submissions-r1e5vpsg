class KthLargest {

    private List<Integer> store;
    private Integer k;
    
    public KthLargest(int k, int[] nums) {

        this.k = k;
        this.store = new ArrayList<>();

        for (int n: nums) {
            store.add(n);
        }
        store.sort(null);

        while (store.size() > k) {
            store.remove(0);
        }
    }
    
    public int add(int val) {
        /*
           3 -2 , k = 1,  [-2 3]
        */
        store.add(val);
        store.sort(null);
        if (store.size() > k) {
            store.remove(0);
        }
        return store.get(0);
    }
}
