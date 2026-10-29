class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        ArrayList<Integer> ls=new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        for(int []it:prerequisites){
            int u=it[0];
            int v=it[1];
            adj.get(v).add(u);
        }
        int vis[]=new int[numCourses];
        for(int i=0;i<numCourses;i++){
            for(int it:adj.get(i)){
                vis[it]++;
            }
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(vis[i]==0) q.add(i);
        }
        while(!q.isEmpty()){
            int curr=q.poll();
            ls.add(curr);
            vis[curr]=0;
            for(int i=0;i<adj.get(curr).size();i++){
                int node=adj.get(curr).get(i);
                vis[node]--;
                if(vis[node]==0) q.add(node);
            }
        }
        int ans1[]={};
        int ans2[]=new int[numCourses];
        if(ls.size()==numCourses){
            for(int i=0;i<numCourses;i++){
                ans2[i]=ls.get(i);
            }
            return ans2;
        }
        return ans1;
    }
}