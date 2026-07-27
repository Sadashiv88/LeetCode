class Solution {
    static boolean flag=false;
    public boolean helper(String word,char[][]board,boolean [][]vis,int i,int j,int n){
        if(n==word.length()) return true;
        if(i<0 || j<0 || i>=board.length || j>=board[0].length){
            return false;
        }
        if(vis[i][j] || board[i][j]!=word.charAt(n)){
            return false;
        }
        vis[i][j]=true;
        boolean found=helper(word,board,vis,i+1,j,n+1) || helper(word,board,vis,i-1,j,n+1) || helper(word,board,vis,i,j+1,n+1) || helper(word,board,vis,i,j-1,n+1);
        vis[i][j]=false;
        return found;


    }
    public boolean exist(char[][] board, String word) {
        flag=false;
        int n=board.length;
        int m=board[0].length;
        boolean vis[][]=new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(word.charAt(0) == board[i][j]) {
                    
                    if (helper(word, board, vis, i, j, 0))
                     return true;
                    
                }
            }
        }
        return false;
    }
}