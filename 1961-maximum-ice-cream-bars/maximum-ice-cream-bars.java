class Solution {
    public int maxIceCream(int[] costs, int coins) {
        PriorityQueue<Integer> q=new PriorityQueue<>();
        for(int it:costs){
            q.add(it);
        }
        int cnt=0;
        while(coins>0 && q.size()>0){
            int t=q.remove();
            if(t>coins) break;
            cnt++;
            coins=coins-t;
        }
        return cnt;
    }
}