class Solution {

    // DFS. O (V+E)
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge: edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        int res = 0;
        for (int node = 0; node < n; node++) {
            if (!visited.contains(node)) {
                dfs(node, visited, adj);
                res++;
            }
        }

        return res;
    }

    private void dfs(int node, Set<Integer> visited, List<List<Integer>> adj) {
        if (visited.contains(node)) return;

        visited.add(node);
        for (int nei: adj.get(node)) {
            dfs(nei, visited, adj);
        }
    }
}
