class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        // 1, 3, 2, -3
        // 1 (->) .....2 (->), -3 (<-)
        for (int a: asteroids) {
            /*
                Observation: asteroids only collide when they are moving towards each other. Ex: 2 (->), -3 (<-)
                So, if 'a' is -ve and top of the stack is +ve, they collide and the bigger one wins (based upon 'diff')
            */
            while(!stack.isEmpty() && a < 0 && stack.peek() > 0) {
                int diff = a + stack.peek();
                if (diff < 0) {
                    stack.pop();    // top of the stack asteroid is obliterated
                } else if (diff > 0) {
                    a = 0;  // current asteroid is obliterated
                } else {
                    stack.pop();
                    a = 0;
                }
            }

            if (a != 0) {
                stack.push(a);
            }
        }

        return stack
                .stream()
                .mapToInt(i -> i)              
                .toArray();
    }
}