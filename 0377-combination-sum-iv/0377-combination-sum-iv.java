class Solution {
    public int combinationSum4(int[] nums, int target) {
        return solve(nums, target);
    }
    public int solve(int[] nums, int tgt){
        int[] dp = new int[tgt + 1];
        dp[0] = 1;
        
        for(int i = 0; i <= tgt; ++i){
            for(int j = 0; j < nums.length; ++j){
                if(i - nums[j] >= 0)
                    dp[i] += dp[i - nums[j]];
            }
        }
        return dp[tgt];
    }
}