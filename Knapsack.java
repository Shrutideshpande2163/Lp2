package DynamicProgramming;

import java.util.*;

public class Knapsack {

    public static int knapsackMemo(int val[], int wt[], int W, int n, int dp[][]) {
        if (W == 0 || n == 0) {
            return 0;
        }
        if (dp[n][W] != -1) {
            return dp[n][W];
        }

        if (wt[n - 1] <= W) {
            // include
            int ans1 = val[n - 1] + knapsackMemo(val, wt, W - wt[n - 1], n - 1, dp);
            // exclude
            int ans2 = knapsackMemo(val, wt, W, n - 1, dp);
            // Store the maximum profit
            dp[n][W] = Math.max(ans1, ans2);
            return dp[n][W];
        } else {
            int ans2 = knapsackMemo(val, wt, W, n - 1, dp);
            return dp[n][W];
        }
    }

    public static void main(String args[]) {
        int val[] = { 15, 14, 10, 45, 30 };
        int wt[] = { 2, 5, 1, 3, 4 };
        int W = 7;
        int dp[][] = new int[val.length + 1][W + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }
        System.out.println(knapsackMemo(val, wt, W, val.length, dp));

    }
}
