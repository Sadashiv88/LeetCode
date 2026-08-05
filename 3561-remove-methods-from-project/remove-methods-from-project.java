class Solution {

    public void dfs(int k, ArrayList<ArrayList<Integer>> adj, boolean vis[]) {
        vis[k] = true;

        for (int node : adj.get(k)) {
            if (!vis[node]) {
                dfs(node, adj, vis);
            }
        }
    }

    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] it : invocations) {
            adj.get(it[0]).add(it[1]);
        }

        // vis[i] = true means method i is suspicious
        boolean[] vis = new boolean[n];

        dfs(k, adj, vis);

        // If any safe method invokes a suspicious method,
        // we cannot remove anything.
        for (int[] it : invocations) {
            int u = it[0];
            int v = it[1];

            if (!vis[u] && vis[v]) {
                List<Integer> ans = new ArrayList<>();
                for (int i = 0; i < n; i++) {
                    ans.add(i);
                }
                return ans;
            }
        }

        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                ans.add(i);
            }
        }

        return ans;
    }
}