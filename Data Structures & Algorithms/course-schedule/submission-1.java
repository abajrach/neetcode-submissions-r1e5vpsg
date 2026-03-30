class Solution {
    Map<Integer, List<Integer>> adjList = new HashMap<>();
    Set<Integer> visiting = new HashSet<>();

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        for (int n = 0; n < numCourses; n++) {
            adjList.put(n, new ArrayList<>());
        }

        for (int[] req: prerequisites) {
            adjList.get(req[0]).add(req[1]);
        }

        for (int n = 0; n < numCourses; n++) {
            if (!dfs(n)) {
                return false;
            }
        }
        return true;
    }

    public boolean dfs(int course) {
        if(visiting.contains(course)) return false;


        List<Integer> preReqs = adjList.get(course);
        if (preReqs.isEmpty()) {
            return true;
        }

        visiting.add(course);

        for (int pre: preReqs) {
            if (!dfs(pre)) {
                return false;
            }
        }

        visiting.remove(course);

        return true;
    }
}
