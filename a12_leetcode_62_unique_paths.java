import java.util.Arrays;

public class a12_leetcode_62_unique_paths {

    // Recursive Solution
    public int getPathsRec(int m, int n) {
        if (m < 0 || n < 0) return 0;
        if (m == 0 || n == 0) return 1;
        return getPathsRec(m - 1, n) + getPathsRec(m, n - 1);
    }

    // Memoization Solution
    public int getPathsMemo(int m, int n, int[][] dp) {
        if (m < 0 || n < 0) return 0;
        if (m == 0 && n == 0) return 1;
        if (dp[m][n] != -1) {
            return dp[m][n];
        }
        int up = getPathsMemo(m - 1, n, dp);
        int left = getPathsMemo(m, n - 1, dp);
        dp[m][n] = up + left;
        return dp[m][n];
    }

    // Tabulation Solution
    public int getPathsTab(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        a12_leetcode_62_unique_paths solution = new a12_leetcode_62_unique_paths();
        int m = 3, n = 3;

        // Recursive solution
        System.out.println("Recursive Solution: " + solution.getPathsRec(m - 1, n - 1));

        // Memoization solution
        int[][] dp = new int[m][n];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        System.out.println("Memoization Solution: " + solution.getPathsMemo(m - 1, n - 1, dp));

        // Tabulation solution
        System.out.println("Tabulation Solution: " + solution.getPathsTab(m, n));
    }
}
