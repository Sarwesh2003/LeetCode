class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n + 1];
        // Arrays.fill(dp, 0, dp.length, -1);
        // int ans = Math.min(memo(n - 1, cost, dp), memo(n - 2, cost, dp));
        
        return tab(n, cost,dp);
    }
    // Recursion solution - TLE
    public int solve(int n, int[] cost){
        if(n == 0)
            return cost[0];
        if(n == 1)
            return cost[1];
        int c = cost[n] + Math.min(solve(n - 1, cost), solve(n - 2, cost));
        return c;
    }
    
    //Memoization - Accepted
    public int memo(int n, int[] cost, int[] dp){
        if(n == 0 || n == 1)
            return cost[n];
        
        if(dp[n] != -1)
            return dp[n];
        
        dp[n] = cost[n] + Math.min(memo(n - 1, cost, dp), memo(n - 2, cost, dp));
        return dp[n];
    }
    
    public int tab(int n, int[] cost, int[] dp){
        dp[0] = cost[0];
        dp[1] = cost[1];
        
        for(int i = 2; i < n; ++i){
            dp[i] = cost[i] + Math.min(dp[i - 1], dp[i -2]);
        }
        return Math.min(dp[n - 1], dp[n - 2]);
    }
}