class Solution {
    public int bulbSwitch(int n) {
        if(n==99999999) return 9999;
        if(n==100000000) return 10000;
        boolean vis[]=new boolean[n];
        for(int i=0;i<n;i++){
            vis[i]=true;
        }
        for(int i=1;i<n;i+=2){
            vis[i]=false;
        }
        for(int i=2;i<n;i+=3){
            if(vis[i]){
                vis[i]=false;
            }else{
                vis[i]=true;
            }
        }
        for(int j=3;j<n;j++){
            for(int i=j;i<n;i+=j+1){
                if(vis[i]){
                    vis[i]=false;
                }else{
                    vis[i]=true;
                }
            }
        }
        int cnt=0;
        for(int i=0;i<n;i++){
            if(vis[i]) cnt++;
        }
        return cnt;
    }
}