class Solution {

    Map<Integer, List<Integer>> adjList = new HashMap<>();
    Set<Integer> visiting = new HashSet<>();

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        // Edge case: input preq = [0,1], numCourses = 2. 
        // We need adjList to be 0:[1], 1:[]
        for (int n = 0; n < numCourses; n++) {
            adjList.put(n, new ArrayList<>());
        }

        // Build Adjacency list
        for (int[] pre: prerequisites) {
            adjList.get(pre[0]).add(pre[1]);
        }

        System.out.println(adjList);

        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i)) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(int n) {
        if (visiting.contains(n)) {
            return false;
        }

        if (adjList.get(n).isEmpty()) {
            return true;
        }

        visiting.add(n);

        for(int pre: adjList.get(n)) {
            if (!dfs(pre)) {
                return false;
            }
        }

        adjList.put(n, new ArrayList<>());
        visiting.remove(n);

        return true;
    }
}
