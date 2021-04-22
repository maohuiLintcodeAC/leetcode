package T0064;

public class Solution {
    public int minPathSum(int[][] grid) {
        if (grid == null) {
            return 0;
        }
        int n = grid[0].length;
        int m = grid.length;

        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = grid[i][j];
                    continue;
                }
                if (i == 0) {
                    dp[i][j] = dp[i][j-1] + grid[i][j];
                    continue;
                }
                if (j == 0) {
                    dp[i][j] = dp[i-1][j] + grid[i][j];
                    continue;
                }
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }

        return dp[m - 1][n - 1];
    }
}
