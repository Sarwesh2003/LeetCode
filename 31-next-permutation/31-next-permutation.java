class Solution {
    public void nextPermutation(int[] nums) {
        int i = 0;
        int j = 0;
        
        for(i=nums.length-2;i>=0;--i){
            if(nums[i] < nums[i+1]){
                break;
            }
        }
        if(i>=0){
            for(j=nums.length-1;j>=0;--j){
                if(nums[j] > nums[i]){
                    break;
                }
            }
                swap(nums, i, j);
        
                reverse(nums, i+1);
            
        }else{
            Arrays.sort(nums);
                return;
        }
        
        
        
    }
    
    public void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    public void reverse(int[] nums, int revFrom){
        int j = nums.length-1;
        while(revFrom < j){
            swap(nums, revFrom, j);
            revFrom++;
            j--;
        }
    }
}