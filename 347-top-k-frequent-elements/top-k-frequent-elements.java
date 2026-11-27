class Solution {
    public static  class pair implements Comparable<pair>{
        int num;
        int count;
        public pair(int num,int count){
            this.num=num;
            this.count=count;
        }
        public int compareTo(pair p2){
            return p2.count-this.count;
        }
    }
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int it:nums){
            if(!map.containsKey(it)){
                map.put(it,1);
            }else{
                int level=map.get(it);
                map.put(it,level+1);
            }
        }
        PriorityQueue<pair> q=new PriorityQueue<>();
        for(int it:map.keySet()){
            q.add(new pair(it,map.get(it)));
        }
        // Integer[]arr=map.keySet().toArray(new Integer[0]);
        // for(int i=0;i<arr.length;i++){
        //     q.add(new pair(arr[i],map.get(arr[i])));
        // }
        int ans[]=new int[k];
        for(int i=0;i<k;i++){
            ans[i]=q.remove().num;
        }
        return ans;
        
    }
}