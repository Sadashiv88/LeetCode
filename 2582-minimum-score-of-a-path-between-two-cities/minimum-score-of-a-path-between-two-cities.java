class Solution {

    class Pair {
        int node, wt;
        Pair(int node, int wt) {
            this.node = node;
            this.wt = wt;
        }
    }

    int ans = Integer.MAX_VALUE;

    public void dfs(int node, ArrayList<ArrayList<Pair>> adj, boolean[] vis) {
        vis[node] = true;

        for (Pair p : adj.get(node)) {
            ans = Math.min(ans, p.wt);

            if (!vis[p.node]) {
                dfs(p.node, adj, vis);
            }
        }
    }

    public int minScore(int n, int[][] roads) {

        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        for (int i = 0; i <= n; i++)
            adj.add(new ArrayList<>());

        for (int[] road : roads) {
            int u = road[0];
            int v = road[1];
            int w = road[2];

            adj.get(u).add(new Pair(v, w));
            adj.get(v).add(new Pair(u, w));
        }

        boolean[] vis = new boolean[n + 1];

        dfs(1, adj, vis);

        return ans;
    }
}