class Solution {
    // Input: target = 10, position = [4,1,0,7], speed = [2,2,1,1]
    // Output: 3
    public int carFleet(int target, int[] position, int[] speed) {
        int[][] pair = new int[position.length][2];

        // Generate (position,speed) pairs
        for (int i = 0; i < position.length; i++) {
            pair[i][0] = position[i];
            pair[i][1] = speed[i];
        }

        // Sort pairs in descending order of their positions. 
        // Process cars closest to the destination first.
        // After sort: (7,1), (4,2), (1,2), (0,1)
        Arrays.sort(pair, (a,b) -> Integer.compare(b[0], a[0]));
        Stack<Double> arrivalTimes = new Stack<>();

        for (int i = 0; i < pair.length; i++) {
            // Calculate time required for the car to arrive destination and push to stack.
            // If the car at the top of the stack arrives earlier than the one below in the stack, it
            // means the two cars have merged into a fleet. So, pop the top of the stack (car reaching dest earlier)
            arrivalTimes.push((double) (target - pair[i][0]) / pair[i][1]);
            if (arrivalTimes.size() >= 2 && arrivalTimes.peek() <= arrivalTimes.get(arrivalTimes.size() - 2)) {
                arrivalTimes.pop();
            }
        }

        return arrivalTimes.size();
    }
}
