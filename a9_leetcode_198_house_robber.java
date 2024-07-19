//same previous one with difeernt name on leetcode !!
import java.util.*;
public class a9_leetcode_198_house_robber {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1); // Initialize memoization array with -1
        return rob2(nums, n - 1, dp);
    }

    public int rob2(int[] arr, int idx, int[] dp) {
        if (idx < 0) return 0;
        if(idx==0) return arr[0];
        if (dp[idx] != -1) {
            return dp[idx];
        }
        int pick = arr[idx] + rob2(arr, idx - 2, dp);
        int notpick = rob2(arr, idx - 1, dp);
        dp[idx] = Math.max(pick, notpick);
        return dp[idx];
    }
}
