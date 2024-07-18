import java.util.Arrays;

public class a6_frog_jump {

    public static void main(String[] args) {
        int[] a = {10, 30, 40, 20};  // Example input array
        int n = a.length;

        System.out.println("Recursive without memoization: " + recursiveWithoutMemo(n - 1, a));
        
        int[] memo = new int[n];
        Arrays.fill(memo, -1);  // Initialize the memo array with -1
        System.out.println("Recursive with memoization: " + recursiveWithMemo(n - 1, a, memo));
        
        System.out.println("Dynamic Programming (Bottom-Up): " + dpBottomUp(a));
        System.out.println("Dynamic Programming with Space Optimization: " + dpSpaceOptimized(a));
    }

    // 1. Recursive without memoization
    public static int recursiveWithoutMemo(int ind, int[] a) {
        if (ind == 0) {
            return 0;
        }
        int left = recursiveWithoutMemo(ind - 1, a) + Math.abs(a[ind] - a[ind - 1]);
        int right = (ind > 1) ? recursiveWithoutMemo(ind - 2, a) + Math.abs(a[ind] - a[ind - 2]) : Integer.MAX_VALUE;
        return Math.min(left, right);
    }

    // 2. Recursive with memoization
    public static int recursiveWithMemo(int ind, int[] a, int[] memo) {
        if (ind == 0) {
            return 0;
        }
        if (memo[ind] != -1) {
            return memo[ind];
        }
        int left = recursiveWithMemo(ind - 1, a, memo) + Math.abs(a[ind] - a[ind - 1]);
        int right = (ind > 1) ? recursiveWithMemo(ind - 2, a, memo) + Math.abs(a[ind] - a[ind - 2]) : Integer.MAX_VALUE;
        memo[ind] = Math.min(left, right);
        return memo[ind];
    }

    // 3. Dynamic Programming (Bottom-Up)
    public static int dpBottomUp(int[] a) {
        int n = a.length;
        int[] dp = new int[n];
        dp[0] = 0;

        for (int i = 1; i < n; i++) {
            int left = dp[i - 1] + Math.abs(a[i] - a[i - 1]);
            int right = (i > 1) ? dp[i - 2] + Math.abs(a[i] - a[i - 2]) : Integer.MAX_VALUE;
            dp[i] = Math.min(left, right);
        }

        return dp[n - 1];
    }

    // 4. Dynamic Programming with Space Optimization
    public static int dpSpaceOptimized(int[] a) {
        int n = a.length;
        int prev2 = 0, prev1 = 0;

        for (int i = 1; i < n; i++) {
            int left = prev1 + Math.abs(a[i] - a[i - 1]);
            int right = (i > 1) ? prev2 + Math.abs(a[i] - a[i - 2]) : Integer.MAX_VALUE;
            int curr = Math.min(left, right);
            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
    }
}
