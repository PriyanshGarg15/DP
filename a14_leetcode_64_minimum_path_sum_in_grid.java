import java.util.Arrays;

public class a14_leetcode_64_minimum_path_sum_in_grid {
    // Recursive solution without memoization
    public int minPathSumRecursive(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        return getMinPathRecursive(m - 1, n - 1, grid);
    }

    private int getMinPathRecursive(int m, int n, int[][] grid) {
        if (m == 0 && n == 0) return grid[0][0];
        if (m < 0 || n < 0) return (int) Math.pow(10, 9);
        int up = grid[m][n] + getMinPathRecursive(m - 1, n, grid);
        int left = grid[m][n] + getMinPathRecursive(m, n - 1, grid);
        return Math.min(up, left);
    }

    // Memoization solution
    public int minPathSumMemo(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return getMinPathMemo(m - 1, n - 1, grid, dp);
    }

    private int getMinPathMemo(int m, int n, int[][] grid, int[][] dp) {
        if (m == 0 && n == 0) return grid[0][0];
        if (m < 0 || n < 0) return (int) Math.pow(10, 9);
        if (dp[m][n] != -1) return dp[m][n];
        int up = grid[m][n] + getMinPathMemo(m - 1, n, grid, dp);
        int left = grid[m][n] + getMinPathMemo(m, n - 1, grid, dp);
        dp[m][n] = Math.min(up, left);
        return dp[m][n];
    }

    // Tabulation solution
    public int minPathSumTab(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int dp[][] = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 && j == 0) dp[i][j] = matrix[i][j];
                else {
                    int up = matrix[i][j];
                    if (i > 0) up += dp[i - 1][j];
                    else up += (int) Math.pow(10, 9);
                    int left = matrix[i][j];
                    if (j > 0) left += dp[i][j - 1];
                    else left += (int) Math.pow(10, 9);
                    dp[i][j] = Math.min(up, left);
                }
            }
        }
        return dp[n - 1][m - 1];
    }

    public static void main(String[] args) {
        a14_leetcode_64_minimum_path_sum_in_grid solution = new a14_leetcode_64_minimum_path_sum_in_grid();
        
        int[][] grid1 = {
            {1, 3, 1},
            {1, 5, 1},
            {4, 2, 1}
        };
        
        int[][] grid2 = {
            {1, 2, 3},
            {4, 5, 6}
        };

        System.out.println("Minimum Path Sum (Recursive) (Grid 1): " + solution.minPathSumRecursive(grid1)); // Expected: 7
        System.out.println("Minimum Path Sum (Memoization) (Grid 1): " + solution.minPathSumMemo(grid1)); // Expected: 7
        System.out.println("Minimum Path Sum (Tabulation) (Grid 1): " + solution.minPathSumTab(grid1)); // Expected: 7

        System.out.println("Minimum Path Sum (Recursive) (Grid 2): " + solution.minPathSumRecursive(grid2)); // Expected: 12
        System.out.println("Minimum Path Sum (Memoization) (Grid 2): " + solution.minPathSumMemo(grid2)); // Expected: 12
        System.out.println("Minimum Path Sum (Tabulation) (Grid 2): " + solution.minPathSumTab(grid2)); // Expected: 12
    }
}
