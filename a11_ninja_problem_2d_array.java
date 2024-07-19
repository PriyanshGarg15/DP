import java.util.*;

public class a11_ninja_problem_2d_array {
    // Recursion
    public int solve2(int days, int last, int[][] points) {
        if (days == 0) {
            int maxi = 0;
            for (int task = 0; task < 3; task++) {
                if (task != last) {
                    maxi = Math.max(points[0][task], maxi);
                }
            }
            return maxi;
        }
        int maxi = 0;
        for (int task = 0; task < 3; task++) {
            if (task != last) {
                int point = points[days][task] + solve2(days - 1, task, points);
                maxi = Math.max(maxi, point);
            }
        }
        return maxi;
    }

    // Memoization
    public int solve(int days, int last, int[][] points, int[][] dp) {
        if (days == 0) {
            int maxi = 0;
            for (int task = 0; task < 3; task++) {
                if (task != last) {
                    maxi = Math.max(points[0][task], maxi);
                }
            }
            return maxi;
        }
        if (dp[days][last] != -1)
            return dp[days][last];
        int maxi = 0;
        for (int task = 0; task < 3; task++) {
            if (task != last) {
                int point = points[days][task] + solve(days - 1, task, points, dp);
                maxi = Math.max(maxi, point);
            }
        }
        return dp[days][last] = maxi;
    }

    // Tabulation without space optimization
    public int tab(int[][] points, int day) {
        int[][] dp = new int[day + 1][4];

        dp[0][0] = Math.max(points[0][1], points[0][2]);
        dp[0][1] = Math.max(points[0][0], points[0][2]);
        dp[0][2] = Math.max(points[0][0], points[0][1]);
        dp[0][3] = Math.max(points[0][0], Math.max(points[0][1], points[0][2]));

        for (int i = 1; i <= day; i++) {
            for (int last = 0; last < 4; last++) {
                dp[i][last] = 0;
                for (int task = 0; task < 3; task++) {
                    if (task != last) {
                        int point = points[i][task] + dp[i - 1][task];
                        dp[i][last] = Math.max(dp[i][last], point);
                    }
                }
            }
        }

        return dp[day][3];
    }

    public static void main(String[] args) {
        a11_ninja_problem_2d_array solution = new a11_ninja_problem_2d_array();
        int[][] points = {{1, 2, 5}, {3, 1, 1}, {3, 3, 3}};
        int n = points.length;
        System.out.println(solution.solve2(n-1, n,points)); // Expected output: 11
    }
}
