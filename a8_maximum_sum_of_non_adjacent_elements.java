import java.util.*;
public class a8_maximum_sum_of_non_adjacent_elements {

    // Non-Optimized Recursive Solution
    public int maxSum(int idx, int[] arr) {
        if (idx < 0) return 0;
        if (idx == 0) return arr[0];
        
        int pick = maxSum(idx - 2, arr) + arr[idx];
        int notpick = maxSum(idx - 1, arr);
        return Math.max(pick, notpick);
    }

    // Memoization Approach
    public int maxSumMemo(int idx, int[] arr, int[] dp) {
        if (idx < 0) return 0;
        if (idx == 0) return arr[0];

        if (dp[idx] != -1) return dp[idx];
        int pick = maxSumMemo(idx - 2, arr, dp) + arr[idx];
        int notpick = maxSumMemo(idx - 1, arr, dp);
        dp[idx] = Math.max(pick, notpick);
        return dp[idx];
    }

    // Tabulation Approach
    public int maxSumTab(int idx, int[] arr) {
        int[] dp = new int[idx + 1];
        dp[0] = arr[0];
        for (int i = 1; i < dp.length; i++) {
            int pick = arr[i];
            if (i > 1) pick += dp[i - 2];
            int notpick = dp[i - 1];
            dp[i] = Math.max(pick, notpick);
        }
        return dp[idx];
    }

    // Space Optimized Tabulation
    public int maxSumTabSO(int idx, int[] arr) {
        int prev2 = 0;
        int prev = arr[0];
        for (int i = 1; i <= idx; i++) {
            int pick = arr[i];
            if (i > 1) pick += prev2;
            int notpick = prev;
            int curr = Math.max(pick, notpick);
            prev2 = prev;
            prev = curr;
        }
        return prev;
    }

    public static void main(String[] args) {
        a8_maximum_sum_of_non_adjacent_elements maxSumSolver = new a8_maximum_sum_of_non_adjacent_elements();
        int[] arr = {2, 1, 4, 9};
        int n = arr.length;

        System.out.println("Maximum sum of non-adjacent elements (Recursive): " + maxSumSolver.maxSum(n - 1, arr));

        int[] dpMemo = new int[n];
        Arrays.fill(dpMemo, -1);
        System.out.println("Maximum sum of non-adjacent elements (Memoization): " + maxSumSolver.maxSumMemo(n - 1, arr, dpMemo));

        System.out.println("Maximum sum of non-adjacent elements (Tabulation): " + maxSumSolver.maxSumTab(n - 1, arr));

        System.out.println("Maximum sum of non-adjacent elements (Space Optimized): " + maxSumSolver.maxSumTabSO(n - 1, arr));
    }
}
