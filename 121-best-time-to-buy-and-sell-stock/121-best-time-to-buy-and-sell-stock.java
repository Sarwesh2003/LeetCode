class Solution {
    public int maxProfit(int[] prices) {
        int maxDiff = Integer.MIN_VALUE;
        int currDiff = 0;
        int smallest = Integer.MAX_VALUE;
        for(int i=0;i<prices.length;++i){
            if(smallest > prices[i]){
                smallest = prices[i];
            }
            
            currDiff = prices[i] - smallest;
            if(currDiff > maxDiff){
                maxDiff = currDiff;
            }
        }
        
       
        if(maxDiff <=0){
            return 0;
        }
        return maxDiff;
    }
}