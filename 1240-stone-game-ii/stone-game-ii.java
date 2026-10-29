
class Solution {
    public int stoneGameII(int[] piles) {
        int n = piles.length;
        int[] suffixSum = new int[n];

        suffixSum[n - 1] = piles[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            suffixSum[i] = piles[i] + suffixSum[i + 1];
        }

        Integer[][] dp = new Integer[n][n + 1];

        return solve(0, 1, piles, suffixSum, dp);
    }

    private int solve(int i, int M, int[] piles,
                      int[] suffixSum, Integer[][] dp) {
        int n = piles.length;

        if (i >= n) {
            return 0;
        }

        if (2 * M >= n - i) {
            return suffixSum[i];
        }

        if (dp[i][M] != null) {
            return dp[i][M];
        }

        int maxStones = 0;

        for (int X = 1; X <= 2 * M; X++) {
            int opponent = solve(
                i + X,
                Math.max(M, X),
                piles,
                suffixSum,
                dp
            );

            int current = suffixSum[i] - opponent;

            maxStones = Math.max(maxStones, current);
        }

        return dp[i][M] = maxStones;
    }
}
