public class a8_maximum_sum_of_non_adjacent_elements {

    // Function to find the maximum sum of non-adjacent elements
    public static int findMaxSum(int[] nums) {
        return findMaxSumRec(nums, 0, new int[nums.length]);
    }

    // Recursive function with memoization
    private static int findMaxSumRec(int[] nums, int index, int[] memo) {
        // Base case: no elements left
        if (index > nums.length-1) {
            return 0;
        }
        // If result is already computed, return it from memo
        if (memo[index] != 0) {
            return memo[index];
        }
        
        // Option 1: Include the current element
        int include = nums[index] + findMaxSumRec(nums, index + 2, memo);
        // Option 2: Exclude the current element
        int exclude = findMaxSumRec(nums, index + 1, memo);
        
        // Store the result in memo
        memo[index] = Math.max(include, exclude);
        
        return memo[index];
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 5, 10, 7};
        System.out.println("Maximum sum of non-adjacent elements: " + findMaxSum(nums));
    }
}
