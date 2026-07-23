class Solution {
    public boolean canFinish(int n, int[][] arr) {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int it[]:arr){
            int u=it[0];
            int v=it[1];
            adj.get(u).add(v);
        }
        List<Integer> ans=new ArrayList<>();
        Queue<Integer> q=new LinkedList<>();
        int vis[]=new int[n];
        for(int i=0;i<n;i++){
            for(int it:adj.get(i)){
                vis[it]++;
            }
        }
        for(int i=0;i<n;i++){
            if(vis[i]==0) q.add(i);
        }
        while(!q.isEmpty()){
            int node =q.remove();
            ans.add(node);
            for(int i=0;i<adj.get(node).size();i++){
                int it=adj.get(node).get(i);
                vis[it]--;
                if(vis[it]==0) q.add(it);
            }
        }
        if(ans.size()==n) return true;
        return false;

    }
}