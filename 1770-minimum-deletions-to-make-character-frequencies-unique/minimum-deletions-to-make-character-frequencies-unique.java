class Solution {
    public int minDeletions(String s) {
        Map<Character,Integer> mp=new HashMap<>();
        int maxi=0;
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            mp.put(ch,mp.getOrDefault(ch,0)+1);
            maxi=Math.max(maxi,mp.get(ch));
        }
        boolean vis[]=new boolean[maxi+1];
        int cnt=0;
        for(int it:mp.values()){
            if(vis[it]==false){
                vis[it]=true;
            }
            else{
                while(it>0 ){
                    cnt++;
                    it--;
                    if(vis[it]==false){
                        vis[it]=true;
                        break;

                    }
                }
            }
        }
        return cnt;

    }
}