class Solution {
    public boolean check(int [][]mat,int [][]tat){
        int n=mat.length;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j]!=tat[i][j]) return false;
            }
        }
        return true;
    }
    public void reverse(int temp[]){
        int i=0;
        int j=temp.length-1;
        while(i<j){
            int t=temp[i];
            temp[i]=temp[j];
            temp[j]=t;
            i++;
            j--;
        }
    }
    public boolean findRotation(int[][] mat, int[][] target) {
        int n = mat.length;

        if (check(mat, target)) return true;

        // -------- 90 degree --------
        int[][] temp = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                temp[i][j] = mat[j][i];
            }
        }
        for (int i = 0; i < n; i++) {
            reverse(temp[i]);
        }
        if (check(temp, target)) return true;

        // -------- 180 degree --------
        int[][] temp2 = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                temp2[i][j] = mat[n - 1 - i][n - 1 - j];
            }
        }
        if (check(temp2, target)) return true;

        // -------- 270 degree --------
        int[][] temp3 = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                temp3[i][j] = mat[j][n - 1 - i];
            }
        }
        if (check(temp3, target)) return true;

        return false;
    }
}