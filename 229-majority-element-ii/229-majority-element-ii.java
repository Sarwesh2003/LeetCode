import java.util.Map.Entry;
class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        List<Integer> ans = new ArrayList<>();
        int freq = n/3;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i=0; i<n; ++i){
            int key = nums[i];
            if(map.containsKey(key)){
                int count = map.get(key);
                count++;
                map.put(key, count);
            }else{
                map.put(key,1);
            }
        }
        for(Entry<Integer,Integer> val : map.entrySet())
        {
            // System.out.println(val.getKey() + " occurs " + val.getValue() + " time(s)");
            if(val.getValue() > freq){
                ans.add(val.getKey());
            }
        }
        return ans;
    }
}