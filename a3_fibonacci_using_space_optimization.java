import java.util.Scanner;

public class a3_fibonacci_using_space_optimization {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the value of n: ");
        int n = sc.nextInt();
        
        // Using space optimized method
        int result = fibonacciSpaceOptimized(n);
        System.out.println("Fibonacci number using space optimization: " + result);
    }

    public static int fibonacciSpaceOptimized(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;

        int prev2 = 0; // F(0)
        int prev1 = 1; // F(1)
        int curr = 0;

        for (int i = 2; i <= n; i++) {
            curr = prev1 + prev2;
            prev2 = prev1;
            prev1 = curr;
        }

        return curr;
    }
}
