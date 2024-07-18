import java.util.*;
public class a1_fibonacci_using_top_down_memoization_approach {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the value of n: ");
        int n = sc.nextInt();
        
        int dp[] = new int[n + 1];
        Arrays.fill(dp,-1);
        // Using memoization (top-down approach)
        int resultMemo = fdp(n, dp);
        System.out.println("Fibonacci number using memoization: " + resultMemo);
    }

    // Memoization (top-down approach)
    public static int fdp(int n, int dp[]) {
        if (n == 0 || n == 1) {
            return n;
        }
        if (dp[n] != -1) {
            return dp[n];
        }
        int n1 = fdp(n - 1, dp);
        int n2 = fdp(n - 2, dp);
        return dp[n] = n1 + n2;
    }
}
