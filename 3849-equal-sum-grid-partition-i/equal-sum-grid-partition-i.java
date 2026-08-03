class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        long[][] horizontal=new long[n][m];
        long sum=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                horizontal[i][j]=(sum+(long)grid[i][j]);
                sum+=(long)grid[i][j];
            }
        }
        for(int i=0;i<n-1;i++){
            long partialSum=horizontal[i][m-1] *2;
            if(partialSum==sum) return true;
        }
        long [][] vertical=new long[n][m];
        sum=0;
        for(int j=0;j<m;j++){
            for(int i=0;i<n;i++){
                vertical[i][j]=sum+(long)grid[i][j];
                sum+=(long)grid[i][j];
            }
        }
        for(int j=0;j<m-1;j++){
            long part=vertical[n-1][j]*2;
            if(part==sum) return true;
        }
        return false;
    }
}