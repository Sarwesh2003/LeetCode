class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] right = rightSmaller(heights, n);
        int[] left = leftSmaller(heights, n);
        
        int area = Integer.MIN_VALUE;
        for(int i=0; i<n; ++i){
            int l = heights[i];
            int b = right[i] - left[i] + 1 ;
            int newArea = l*b;
            area = area>newArea?area:newArea;
        }
        return area;
    }
    
    private int[] rightSmaller(int[] arr, int n){
        Stack<Integer> s = new Stack<>();
        int[] ans = new int[n];
        for(int i=n-1; i>=0; --i){
            int element = arr[i];
            while(!s.empty() && arr[s.peek()] >= element){
                s.pop();
            }
            if(s.empty()){
                ans[i] = n-1;
            }else{
                ans[i] = s.peek()-1;
                // s.push(i);
            }
            s.push(i);
        }
        return ans;
    }
    
    private int[] leftSmaller(int[] arr, int n){
        Stack<Integer> s = new Stack<>();
        int[] ans = new int[n];
        for(int i=0; i<n; ++i){
            int element = arr[i];
            while(!s.empty() && arr[s.peek()] >= element){
                s.pop();
            }
            if(s.empty()){
                ans[i]=0;
            }else{
                ans[i] = s.peek()+1;
                
            }
            s.push(i);
        }
        return ans;
    }
}