class Solution {
    public int minJumps(int[] arr) {
        int n=arr.length;
        if(n==1) return 0;
        HashMap<Integer,List<Integer> > map=new HashMap<>();
        for(int i=0;i<n;i++){
            if(!map.containsKey(arr[i])){
                map.put(arr[i],new ArrayList<>());
            }
             map.get(arr[i]).add(i);
        }
        boolean vis[]=new boolean[n];
        vis[0]=true;
        Queue<Integer> q=new LinkedList<>();
        q.add(0);
        int step=0;
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                int curr=q.poll();
                if(curr==n-1) return step;
                if(curr+1<n && !vis[curr+1]){
                    vis[curr+1]=true;
                    q.offer(curr+1);
                }
                if(curr-1>=0 && !vis[curr-1]){
                    vis[curr-1]=true;
                    q.offer(curr-1);
                }
                if(map.containsKey(arr[curr])){
                    for(int ind:map.get(arr[curr])){
                        if(!vis[ind]){
                            q.offer(ind);
                            vis[ind]=true;
                        }
                    }
                    map.remove(arr[curr]);
                }
                
            }
            step++;
        }
        return step;
    }
}