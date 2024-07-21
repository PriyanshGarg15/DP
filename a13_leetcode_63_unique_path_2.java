import java.util.Arrays;

public class a13_leetcode_63_unique_path_2 {

    // Recursive Solution
    public int uniquePathsWithObstaclesRec(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        return getPathsRec(m - 1, n - 1, obstacleGrid);
    }

    private int getPathsRec(int m, int n, int[][] mat) {
        if (m < 0 || n < 0) return 0;
        if (mat[m][n] == 1) return 0;
        if (m == 0 && n == 0) return 1;
        return getPathsRec(m - 1, n, mat) + getPathsRec(m, n - 1, mat);
    }

    // Memoization Solution
    public int uniquePathsWithObstaclesMemo(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return getPathsMemo(m - 1, n - 1, obstacleGrid, dp);
    }

    private int getPathsMemo(int m, int n, int[][] mat, int[][] dp) {
        if (m < 0 || n < 0) return 0;
        if (mat[m][n] == 1) return 0;
        if (m == 0 && n == 0) return 1;
        if (dp[m][n] != -1) return dp[m][n];
        int up = getPathsMemo(m - 1, n, mat, dp);
        int left = getPathsMemo(m, n - 1, mat, dp);
        dp[m][n] = up + left;
        return dp[m][n];
    }

    // Tabulation Solution
    public int uniquePathsWithObstaclesTab(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];

        if (obstacleGrid[0][0] == 1) return 0;
        dp[0][0] = 1;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                } else {
                    if (i > 0) dp[i][j] += dp[i - 1][j];
                    if (j > 0) dp[i][j] += dp[i][j - 1];
                }
            }
        }

        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        a13_leetcode_63_unique_path_2 solution = new a13_leetcode_63_unique_path_2();
        int[][] obstacleGrid1 = {
            {0, 0, 0},
            {0, 1, 0},
            {0, 0, 0}
        };

        int[][] obstacleGrid2 = {
            {0, 1},
            {0, 0}
        };

        // Test Recursive Solution
        System.out.println("Recursive Solution (Grid 1): " + solution.uniquePathsWithObstaclesRec(obstacleGrid1)); // Expected: 2
        System.out.println("Recursive Solution (Grid 2): " + solution.uniquePathsWithObstaclesRec(obstacleGrid2)); // Expected: 1

        // Test Memoization Solution
        System.out.println("Memoization Solution (Grid 1): " + solution.uniquePathsWithObstaclesMemo(obstacleGrid1)); // Expected: 2
        System.out.println("Memoization Solution (Grid 2): " + solution.uniquePathsWithObstaclesMemo(obstacleGrid2)); // Expected: 1

        // Test Tabulation Solution
        System.out.println("Tabulation Solution (Grid 1): " + solution.uniquePathsWithObstaclesTab(obstacleGrid1)); // Expected: 2
        System.out.println("Tabulation Solution (Grid 2): " + solution.uniquePathsWithObstaclesTab(obstacleGrid2)); // Expected: 1
    }
}
