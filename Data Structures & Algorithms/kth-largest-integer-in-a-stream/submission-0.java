// Naive solution using ArrayList
class KthLargest {
    private int k;
    private List<Integer> arr;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        arr = new ArrayList<>();
        for(int n: nums) {
            arr.add(n);
        }
    }
    
    public int add(int val) {
        arr.add(val);
        Collections.sort(arr);
        return arr.get(arr.size() - k);
    }
}
