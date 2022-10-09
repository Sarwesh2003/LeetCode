class Solution {
    int count = 0;
    // int sum = 0;
    public int findTargetSumWays(int[] nums, int target) {
        solve(nums, target, 0, 0);
        return count;
    }
    
    public void solve(int[] nums, int tgt, int sum,int i){
        if(i >= nums.length){
            if(tgt == sum){
                count++;
            }    
        }else{
            solve(nums, tgt, sum + nums[i], i + 1);
            solve(nums, tgt, sum - nums[i], i + 1);
        }
    }
}