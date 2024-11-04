package DynamicProgramming;

import java.util.*;

//Count ways to reach the nth stair. 
class ClimbingStairs{

    public static int countWays(int n,int dp[]){
       
        if(n == 0){
           return 1;
        }
        if(n < 0){
            return 0;
        }
        if(dp[n] != -1){
            return dp[n];
        }
        dp[n] = countWays(n-1,dp) + countWays(n-2,  dp);
        return dp[n];
    }

    public static int countWaysTab(int n){
        int dp[] = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;

        for(int i=3; i<=n; i++){
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
    public static void main(String[] args) {
        int n = 5;
        int dp[] = new int[n+1];
        Arrays.fill(dp,-1);
        System.out.println(countWays(n,dp));
        System.err.println(countWaysTab(n));
    }
}
