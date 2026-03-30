class Solution {

    Map<Integer, List<Integer>> adjList = new HashMap<>();
    Set<Integer> cycle = new HashSet<>();
    Set<Integer> visited = new HashSet<>();
    List<Integer> output = new ArrayList<>();

    public int[] findOrder(int numCourses, int[][] prerequisites) {

        for (int[] pre: prerequisites) {
            adjList
                .computeIfAbsent(pre[0], k -> new ArrayList<>())
                .add(pre[1]);
        }

        for (int n = 0; n < numCourses; n++) {
            if (!dfs(n)) {
                return new int[0];
            }
        }

        // return result.stream().mapToInt(i->i).toArray();
        int[] result = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            result[i] = output.get(i);
        }

        return result;
    }

    private boolean dfs(int course) {
        if (cycle.contains(course)) return false;
        if (visited.contains(course)) return true;

        cycle.add(course);

        // if (adjList.get(course).isEmpty()) {
        //     return;
        // }


        for (int pre: adjList.getOrDefault(course, new ArrayList<>())) {
            if (!dfs(pre)) {
                return false;
            };
        }

        cycle.remove(course);
        visited.add(course);
        output.add(course);

        return true;
    }
}
