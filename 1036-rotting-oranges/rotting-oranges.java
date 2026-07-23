class pair{
    int row;
    int col;
    int t;
    public pair(int row,int col,int t){
        this.row=row;
        this.col=col;
        this.t=t;
    }
}
class Solution {

    public int orangesRotting(int[][] grid) {
        Queue<pair> q=new LinkedList<>();
         int n=grid.length;
         int m=grid[0].length;
        int vis[][]=new int[n][m];
        int cntfresh=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2){
                    q.add(new pair(i,j,0));
                    vis[i][j]=2;
                }
                if(grid[i][j]==1){
                    cntfresh++;
                }
            }
        }
        int drow[]={-1,0,1,0};
        int dcol[]={0,1,0,-1};
        int tm=0;
        int cnt=0;
        while(!q.isEmpty()){
            pair it=q.remove();
            int r=it.row;
            int c=it.col;
            int tt=it.t;
            tm=Math.max(tm,tt);
            for(int i=0;i<4;i++){
                int nrow=r+drow[i];
                int ncol=c+dcol[i];
                if(nrow>=0 && ncol>=0 && nrow<n && ncol<m && vis[nrow][ncol]==0 && grid[nrow][ncol]==1){
                    cnt++;
                    q.add(new pair(nrow,ncol,tt+1));
                    vis[nrow][ncol]=2;
                }
            }
            
        }
        if(cnt!=cntfresh) return -1;
        return tm;

    }
}