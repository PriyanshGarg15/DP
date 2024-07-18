import java.util.Arrays;

public class a5_leetcode_746_min_cost_climbing_stairs {

    // Recursive Solution
    static class RecursiveSolution {
        public int minCostClimbingStairs(int[] cost) {
            return Math.min(minCost(cost, cost.length - 1), minCost(cost, cost.length - 2));
        }

        private int minCost(int[] cost, int n) {
            if (n == 0 || n == 1) return cost[n];
            return cost[n] + Math.min(minCost(cost, n - 1), minCost(cost, n - 2));
        }
    }

    // Memoization Solution
    static class MemoizationSolution {
        public int minCostClimbingStairs(int[] cost) {
            int n = cost.length;
            int[] memo = new int[n];
            Arrays.fill(memo, -1);
            return Math.min(minCostMemo(n - 1, cost, memo), minCostMemo(n - 2, cost, memo));
        }

        private int minCostMemo(int i, int[] cost, int[] memo) {
            if (i == 0 || i == 1) return cost[i];
            if (memo[i] != -1) return memo[i];
            memo[i] = cost[i] + Math.min(minCostMemo(i - 1, cost, memo), minCostMemo(i - 2, cost, memo));
            return memo[i];
        }
    }

    // Tabulation Solution
    static class TabulationSolution {
        public int minCostClimbingStairs(int[] cost) {
            int n = cost.length;
            if (n == 0) return cost[0];
            if (n == 1) return cost[1];
            
            int[] dp = new int[n];
            dp[0] = cost[0];
            dp[1] = cost[1];
            
            for (int i = 2; i < n; i++) {
                dp[i] = cost[i] + Math.min(dp[i - 1], dp[i - 2]);
            }
            
            return Math.min(dp[n - 1], dp[n - 2]);
        }
    }

    // Space Optimization Solution
    static class SpaceOptimizedSolution {
        public int minCostClimbingStairs(int[] cost) {
            int n = cost.length;
            if (n == 0) return cost[0];
            if (n == 1) return cost[1];

            int prev2 = cost[0];
            int prev1 = cost[1];
            int current = 0;

            for (int i = 2; i < n; i++) {
                current = cost[i] + Math.min(prev1, prev2);
                prev2 = prev1;
                prev1 = current;
            }

            return Math.min(prev1, prev2);
        }
    }

    // Main Class
    public static void main(String[] args) {
        int[] cost = {10, 15, 20}; // Example input

        RecursiveSolution recursiveSolution = new RecursiveSolution();
        System.out.println("Minimum cost (Recursive): " + recursiveSolution.minCostClimbingStairs(cost));

        MemoizationSolution memoizationSolution = new MemoizationSolution();
        System.out.println("Minimum cost (Memoization): " + memoizationSolution.minCostClimbingStairs(cost));

        TabulationSolution tabulationSolution = new TabulationSolution();
        System.out.println("Minimum cost (Tabulation): " + tabulationSolution.minCostClimbingStairs(cost));

        SpaceOptimizedSolution spaceOptimizedSolution = new SpaceOptimizedSolution();
        System.out.println("Minimum cost (Space Optimization): " + spaceOptimizedSolution.minCostClimbingStairs(cost));
    }
}
