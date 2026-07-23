class DSU {

    int[] parent;
    int[] size;

    DSU(int n) {
        parent = new int[n];
        size = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    int find(int x) {
        if (parent[x] == x){
            return x;
        }
        int ul=find(parent[x]);
        parent[x]=ul;
               // Path Compression

        return parent[x];
    }

    boolean union(int u, int v) {

        int pu = find(u);
        int pv = find(v);

        if (pu == pv)
            return false;

        // Attach smaller set under larger set
        if (size[pu] < size[pv]) {
            parent[pu] = pv;
            size[pv] += size[pu];
        } else {
            parent[pv] = pu;
            size[pu] += size[pv];
        }

        return true;
    }
}

class Solution {
    public int minCostConnectPoints(int[][] points) {

        int n = points.length;

        List<int[]> edges = new ArrayList<>();

        // Create all edges
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){

                int dist = Math.abs(points[i][0]-points[j][0])
                         + Math.abs(points[i][1]-points[j][1]);

                edges.add(new int[]{dist,i,j});
            }
        }

        // Sort by weight
        Collections.sort(edges,(a,b)->a[0]-b[0]);

        DSU dsu = new DSU(n);

        int cost = 0;
        int edgesUsed = 0;

        for(int[] edge:edges){

            int wt=edge[0];
            int u=edge[1];
            int v=edge[2];

            if(dsu.union(u,v)){
                cost+=wt;
                // edgesUsed++;

                // if(edgesUsed==n-1)
                //     break;
            }
        }

        return cost;
    }
}