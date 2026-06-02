class Solution {
    public int leastInterval(char[] tasks, int n) {
        // [A A A B B C C]      n = 1
        /*
            time = 3
            maxHeap = []   q = [ {2,1+1}, {1, 2+1}, {1, 3 + 1}]
        */

        int[] count = new int[26];
        for (char ch: tasks) {
            count[ch - 'A']++;
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < 26; i++) {
            if (count[i] > 0) {
                maxHeap.offer(count[i]);
            }
        }

        Queue<int[]> queue = new LinkedList<>();
        int time = 0;
        while (!maxHeap.isEmpty() || !queue.isEmpty()) {
            time++;
            
            if (maxHeap.isEmpty()) {

            } else {
                int remaining = maxHeap.poll() - 1;
                if (remaining > 0) {
                    queue.offer(new int[]{remaining, time + n});
                }
            }

            if (!queue.isEmpty() && queue.peek()[1] == time) {
                maxHeap.offer(queue.poll()[0]);
            }
        }

        return time;
    }
}
