class Solution {
    private int solve(int[] nums, int left, int right,
                      int turn, int[][][] dp) {

        if (left > right) {
            return 0;
        }

        if (dp[left][right][turn] != Integer.MIN_VALUE) {
            return dp[left][right][turn];
        }

        int result=0;

        if (turn == 0) {
            // Player 1 maximizes their score
            int pickLeft = nums[left]
                    + solve(nums, left + 1, right, 1, dp);

            int pickRight = nums[right]
                    + solve(nums, left, right - 1, 1, dp);

            result = Math.max(pickLeft, pickRight);

        } else {
            // Player 2 minimizes Player 1's final score
            int pickLeft = solve(nums, left + 1, right, 0, dp);
            int pickRight = solve(nums, left, right - 1, 0, dp);

            result = Math.min(pickLeft, pickRight);
        }

        return dp[left][right][turn] = result;
    }
    public boolean stoneGame(int[] nums) {
          int n = nums.length;
        int totalSum = 0;

        for (int num : nums) {
            totalSum += num;
        }

        int[][][] dp = new int[n][n][2];

        for (int[][] matrix : dp) {
            for (int[] row : matrix) {
                Arrays.fill(row, Integer.MIN_VALUE);
            }
        }

        int player1 = solve(nums, 0, n - 1, 0, dp);
        int player2 = totalSum - player1;

        return player1 >= player2;
    }
}