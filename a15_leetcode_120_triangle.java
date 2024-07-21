import java.util.Arrays;
import java.util.List;

public class a15_leetcode_120_triangle {

    // Recursive solution without memoization
    public int minimumTotalRecursive(List<List<Integer>> triangle) {
        return bestPathRecursive(0, 0, triangle);
    }

    public int bestPathRecursive(int i, int j, List<List<Integer>> triangle) {
        if (i == triangle.size() - 1) return triangle.get(i).get(j);
        int down = triangle.get(i).get(j) + bestPathRecursive(i + 1, j, triangle);
        int diagonal = triangle.get(i).get(j) + bestPathRecursive(i + 1, j + 1, triangle);
        return Math.min(down, diagonal);
    }

    // Memoization solution
    public int minimumTotalMemo(List<List<Integer>> triangle) {
        int[][] dp = new int[triangle.size()][triangle.size()];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return bestPathMemo(0, 0, triangle, dp);
    }

    public int bestPathMemo(int i, int j, List<List<Integer>> triangle, int[][] dp) {
        if (i == triangle.size() - 1) return triangle.get(i).get(j);
        if (dp[i][j] != -1) return dp[i][j];
        int down = triangle.get(i).get(j) + bestPathMemo(i + 1, j, triangle, dp);
        int diagonal = triangle.get(i).get(j) + bestPathMemo(i + 1, j + 1, triangle, dp);
        dp[i][j] = Math.min(down, diagonal);
        return dp[i][j];
    }

    // Tabulation solution
    public int minimumTotalTabulation(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][n];
        
        // Initialize the bottom row of dp
        for (int j = 0; j < n; j++) {
            dp[n-1][j] = triangle.get(n-1).get(j);
        }

        // Fill the dp table from bottom to top
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                 // Calculate down path
                 int down = triangle.get(i).get(j) + dp[i + 1][j];

                 // Calculate diagonal path
                 int diagonal = triangle.get(i).get(j) + dp[i + 1][j + 1];
 
                 // Get the minimum of down and diagonal paths
                 dp[i][j] = Math.min(down, diagonal);
            }
        }

        return dp[0][0];
    }

    public static void main(String[] args) {
        a15_leetcode_120_triangle solution = new a15_leetcode_120_triangle();

        List<List<Integer>> triangle1 = Arrays.asList(
            Arrays.asList(2),
            Arrays.asList(3, 4),
            Arrays.asList(6, 5, 7),
            Arrays.asList(4, 1, 8, 3)
        );

        List<List<Integer>> triangle2 = Arrays.asList(
            Arrays.asList(-10)
        );

        System.out.println("Minimum Total (Recursive) (Triangle 1): " + solution.minimumTotalRecursive(triangle1)); // Expected: 11
        System.out.println("Minimum Total (Memoization) (Triangle 1): " + solution.minimumTotalMemo(triangle1)); // Expected: 11
        System.out.println("Minimum Total (Tabulation) (Triangle 1): " + solution.minimumTotalTabulation(triangle1)); // Expected: 11

        System.out.println("Minimum Total (Recursive) (Triangle 2): " + solution.minimumTotalRecursive(triangle2)); // Expected: -10
        System.out.println("Minimum Total (Memoization) (Triangle 2): " + solution.minimumTotalMemo(triangle2)); // Expected: -10
        System.out.println("Minimum Total (Tabulation) (Triangle 2): " + solution.minimumTotalTabulation(triangle2)); // Expected: -10
    }
}
