class Solution {
    int timer=1;
    public void dfs(int index,int parent,int []vis,int []tin,int []low,ArrayList<ArrayList<Integer>> adj,List<List<Integer>> ans){
        vis[index]=1;
        tin[index]=timer;
        low[index]=timer;
        timer++;
        for(int it:adj.get(index)){
            if(parent==it) continue;
            if(vis[it]==0){
                dfs(it,index,vis,tin,low,adj,ans);
                low[index]=Math.min(low[index],low[it]);
                if(low[it]>tin[index]){
                    ans.add(Arrays.asList(it,index));
                }

            }else{
                low[index]=Math.min(low[index],low[it]);
            }
        }

    }
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        int tin[]=new int[n];
        int low[]=new int[n];
        int vis[]=new int [n];
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(List<Integer> it:connections){
            int a=it.get(0);
            int b=it.get(1);
            adj.get(a).add(b);
            adj.get(b).add(a);
        }
        List<List<Integer>> ans=new ArrayList<>();
        dfs(0,-1,vis,tin,low,adj,ans);
        return ans;
        
    }
}