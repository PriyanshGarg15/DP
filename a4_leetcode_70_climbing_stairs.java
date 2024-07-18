public class a4_leetcode_70_climbing_stairs {
    
    // Recursive solution without memoization
    public static int climbStairsRecursive(int n) {
        // Base cases
        if (n == 0 || n == 1) {
            return 1; // There is 1 way to reach the base case (0 steps or 1 step)
        }
        
        // Recursive calculation
        return climbStairsRecursive(n - 1) + climbStairsRecursive(n - 2);
    }

    // Recursive solution with memoization
    public static int climbStairsMemo(int n, int[] memo) {
        // Base cases
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return 1;
        }
        // Check memo array to avoid redundant calculations
        if (memo[n] != 0) {
            return memo[n];
        }
        // Calculate the result recursively and store it in memo array
        memo[n] = climbStairsMemo(n - 1, memo) + climbStairsMemo(n - 2, memo);
        return memo[n];
    }

    // Main function to call memoized solution
    public static int climbStairs(int n) {
        int[] memo = new int[n + 1];
        return climbStairsMemo(n, memo);
    }

    public static void main(String[] args) {
        int n = 4; // Example input, you can change this value to test with different numbers of steps

        // Testing the recursive solution without memoization
        System.out.println("Number of ways to climb " + n + " stairs (recursive): " + climbStairsRecursive(n));

        // Testing the recursive solution with memoization
        System.out.println("Number of ways to climb " + n + " stairs (memoized): " + climbStairs(n));
    }
}



//botoom up approach (tabulation way)

// import java.util.*;
// public class a4_climbing_stairs {
//     public static int climbStairs(int n) {
//         if (n == 0) {
//             return 1;
//         }
//         if (n == 1) { //becz if standing on 1 then there will always be one way to climb up the stairs
//             return 1;
//         }
//         int[] dp = new int[n + 1];
//         dp[0] = 1;
//         dp[1] = 1;

//         for (int i = 2; i <= n; i++) {
//             dp[i] = dp[i - 1] + dp[i - 2];
//         }

//         return dp[n];
//     }

//     public static void main(String[] args) {
//         int n = 10; // Example input, you can change this value to test with different numbers of steps
//         System.out.println("Number of ways to climb " + n + " stairs: " + climbStairs(n));
//     }
// }
