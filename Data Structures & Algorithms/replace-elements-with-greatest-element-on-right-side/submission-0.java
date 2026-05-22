class Solution {
    public int[] replaceElements(int[] arr) {
        // 2,4,5,3,1,2
        int max = -1, cur = -1;

        for (int i = arr.length - 1; i >= 0; i--) {
            cur = arr[i];
            arr[i] = max;
            max = Math.max(max, cur);
        }

        return arr;
    }
}