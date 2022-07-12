class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] arr = new int[nums1.length];
        map = nextGreater(nums2);
        for(int i=0; i<nums1.length; ++i){
            arr[i] = map.get(nums1[i]);
        }
        return arr;
    }
    private HashMap<Integer, Integer> nextGreater(int[] arr){
        HashMap<Integer, Integer> map = new HashMap<>();
        Stack<Integer> s = new Stack<>();
        
        s.push(-1);
        for(int i=arr.length-1; i>=0; --i){
            int element = arr[i];
            if(!s.empty() && s.peek() >= element){
                map.put(element, s.peek());
                // s.pop();
            }else{
                while(!s.empty() && s.peek() < element){
                    s.pop();
                }
                if(!s.empty()){
                    map.put(element, s.peek());
                }else{
                    map.put(element, -1);
                }
            }
            s.push(element);
        }
        return map;
        
    } 
}