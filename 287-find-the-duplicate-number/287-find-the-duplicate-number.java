class Solution {
    public int findDuplicate(int[] nums) {
        int ans = 0;
        Arrays.sort(nums);
        for(int i=0;i<nums.length;++i){
            if(nums[i] != (i+1)){
                if(nums[i] != nums[nums[i] - 1]){
                    swap(nums, i, nums[i]-1);
                }else{
                    return nums[i];
                }
            }
        }
        return -1;
    }
    public void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}