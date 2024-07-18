// public class a4_climbing_stairs {
//     public static int climbStairs(int n) {
//         int[] memo = new int[n + 1];
//         return climbStairsMemo(n, memo);
//     }

//     private static int climbStairsMemo(int n, int[] memo) {
//         if (n == 0) {
//             return 1;
//         }
//         if (n == 1) { //becz if standing on 1 then there will always be one way to climb up the stairs
//             return 1;
//         }
//         if (memo[n] != 0) {
//             return memo[n];
//         }
//         memo[n] = climbStairsMemo(n - 1, memo) + climbStairsMemo(n - 2, memo);
//         return memo[n];
//     }

//     public static void main(String[] args) {
//         int n = 10; // Example input, you can change this value to test with different numbers of steps
//         System.out.println("Number of ways to climb " + n + " stairs: " + climbStairs(n));
//     }
// }


//botoom up approach 

import java.util.*;
public class a4_climbing_stairs {
    public static int climbStairs(int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) { //becz if standing on 1 then there will always be one way to climb up the stairs
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

    public static void main(String[] args) {
        int n = 10; // Example input, you can change this value to test with different numbers of steps
        System.out.println("Number of ways to climb " + n + " stairs: " + climbStairs(n));
    }
}
