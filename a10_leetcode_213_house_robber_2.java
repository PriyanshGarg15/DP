import java.util.Arrays;

public class a10_leetcode_213_house_robber_2 {
    public int rob(int[] nums) {
        int n = nums.length;
        
        // Handle edge cases
        if (n == 0) return 0;
        if (n == 1) return nums[0];
        
        // Exclude the last element and calculate maximum amount
        int[] nums1 = Arrays.copyOfRange(nums, 0, n - 1);
        int max1 = robhelp(nums1);
        
        // Exclude the first element and calculate maximum amount
        int[] nums2 = Arrays.copyOfRange(nums, 1, n);
        int max2 = robhelp(nums2);
        
        // Return the maximum amount between the two cases
        return Math.max(max1, max2);
    }

    public int robhelp(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1); // Initialize memoization array with -1
        return robhelp2(nums, n - 1, dp);
    }

    public int robhelp2(int[] arr, int idx, int[] dp) {
        if (idx < 0) return 0;
        if(idx == 0) return arr[0];
        if (dp[idx] != -1) {
            return dp[idx];
        }
        int pick = arr[idx] + robhelp2(arr, idx - 2, dp);
        int notpick = robhelp2(arr, idx - 1, dp);
        dp[idx] = Math.max(pick, notpick);
        return dp[idx];
    }

    public static void main(String[] args) {
        a10_leetcode_213_house_robber_2 solution = new a10_leetcode_213_house_robber_2();
        int[] nums = {2, 3, 2};
        System.out.println("Maximum amount that can be robbed: " + solution.rob(nums)); // Expected output: 3
        
        int[] nums2 = {1, 2, 3, 1};
        System.out.println("Maximum amount that can be robbed: " + solution.rob(nums2)); // Expected output: 4
        
        int[] nums3 = {0};
        System.out.println("Maximum amount that can be robbed: " + solution.rob(nums3)); // Expected output: 0
    }
}
