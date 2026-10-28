class Solution {
    public boolean canReach(int[] arr, int start) {
        int n=arr.length;
        if(n==1 && arr[0]==0) return true;
        boolean vis[]=new boolean[n];
        Queue<Integer> q=new LinkedList<>();
        q.offer(start);
        while(!q.isEmpty()){
            int t=q.poll();
            vis[t]=true;
            if(arr[t]==0) return true;
            if(t+arr[t]<n && !vis[t+arr[t]]){
                q.offer(t+arr[t]);
                vis[t+arr[t]]=true;
            }
            if(t-arr[t]>=0 && !vis[t-arr[t]]){
                q.offer(t-arr[t]);
                vis[t-arr[t]]=true;
            }
        }
        return false;
    }
}