class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        Set<Integer> cycle = new HashSet<>();
        Set<Integer> visited = new HashSet<>();
        List<Integer> output = new ArrayList<>();

        for (int[] pre: prerequisites) {
            adjList
                .computeIfAbsent(pre[0], (k) -> new ArrayList<>())
                .add(pre[1]);
        }

        for (int n = 0; n < numCourses; n++) {
            if (!dfs(n, adjList, cycle, visited, output)) {
                return new int[0];
            }
        }

        int[] result = new int[numCourses];
        for (int n = 0; n < numCourses; n++) {
            result[n] = output.get(n);
        }
        return result;
    }

    private boolean dfs(int course,
                        Map<Integer, List<Integer>> adjList,
                        Set<Integer> cycle,
                        Set<Integer> visited,
                        List<Integer> output) {
        if (cycle.contains(course)) return false;
        
        if (visited.contains(course)) return true;
        cycle.add(course);


        for (int pre: adjList.getOrDefault(course, new ArrayList<>())) {
            if (!dfs(pre, adjList, cycle, visited, output)) {
                return false;
            }
        }

        visited.add(course);
        cycle.remove(course);
        output.add(course);

        return true;
    }
}
