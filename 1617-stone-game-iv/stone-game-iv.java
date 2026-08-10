class Solution {
    public boolean winnerSquareGame(int n) {
        boolean[] dp = new boolean[n + 1];

        // dp[0] = false
        // No stones -> current player cannot move -> loses

        for (int i = 1; i <= n; i++) {

            for (int j = 1; j * j <= i; j++) {

                // If after removing j*j stones,
                // opponent reaches a losing state
                if (!dp[i - j * j]) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[n];
    }
}