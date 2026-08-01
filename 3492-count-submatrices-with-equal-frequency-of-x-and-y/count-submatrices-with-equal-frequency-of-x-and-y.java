class Solution {
    public int numberOfSubmatrices(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] px = new int[m + 1][n + 1];
        int[][] py = new int[m + 1][n + 1];

        int ans = 0;

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {

                px[i][j] = px[i - 1][j] + px[i][j - 1] - px[i - 1][j - 1];
                py[i][j] = py[i - 1][j] + py[i][j - 1] - py[i - 1][j - 1];

                if (grid[i - 1][j - 1] == 'X')
                    px[i][j]++;
                else if (grid[i - 1][j - 1] == 'Y')
                    py[i][j]++;

                if (px[i][j] > 0 && px[i][j] == py[i][j])
                    ans++;
            }
        }

        return ans;
    }
}