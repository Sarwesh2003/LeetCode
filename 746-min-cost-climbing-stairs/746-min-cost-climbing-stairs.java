class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int ans = Math.min(solve(n - 1, cost), solve(n - 2, cost));
        return ans;
    }
    // Recursion solution - TLE
    public int solve(int n, int[] cost){
        if(n == 0)
            return cost[0];
        if(n == 1)
            return cost[1];
        
        int[] dp = new int[n + 1];
        Arrays.fill(dp, 0, dp.length, -1);
        int c = cost[n] + Math.min(memo(n - 1, cost, dp), memo(n - 2, cost, dp));
        return c;
    }
    
    //Memoization
    public int memo(int n, int[] cost, int[] dp){
        if(n == 0 || n == 1)
            return cost[n];
        
        if(dp[n] != -1)
            return dp[n];
        
        dp[n] = cost[n] + Math.min(memo(n - 1, cost, dp), memo(n - 2, cost, dp));
        return dp[n];
    }
}