class Solution {
    public void dfs(int [][]ans,int sr,int sc,int color,boolean vis[][],int original){
        if( sr<0 || sc<0 || sr>=ans.length || sc>=ans[0].length||vis[sr][sc]==true || ans[sr][sc]!=original){
            return;
        }
        ans[sr][sc]=color;
        vis[sr][sc]=true;
        dfs(ans,sr+1,sc,color,vis,original);
        dfs(ans,sr-1,sc,color,vis,original);
        dfs(ans,sr,sc+1,color,vis,original);
        dfs(ans,sr,sc-1,color,vis,original);
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n=image.length;
        int m=image[0].length;
        boolean vis[][]=new boolean[n][m];
        // vis[sr][sc]=true;
        int original=image[sr][sc];
        int ans[][]=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                ans[i][j]=image[i][j];
            }
        }
        dfs(ans,sr,sc,color,vis,original);
        return ans;

    }
}