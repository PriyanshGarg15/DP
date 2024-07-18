import java.util.Scanner;

public class a2_fibonacci_using_bottom_up_tabulation_approach {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the value of n: ");
        int n = sc.nextInt();

        // Using tabulation (bottom-up approach)
        int resultTab = tab(n);
        System.out.println("Fibonacci number using tabulation: " + resultTab);
    }
    
    // Tabulation (bottom-up approach)
    public static int tab(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
