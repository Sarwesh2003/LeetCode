import java.util.Map.Entry;
class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        int num1 = -1, num2 = -1, c1 = 0, c2 = 0;
        int freq = n/3;
        ArrayList<Integer> ans = new ArrayList<>();
        
        for(int element : nums){
            if(element == num1){
                c1++;
            }else if(element == num2){
                c2++;
            }else if(c1 == 0){
                num1 = element;
                c1 = 1;
            }else if(c2 == 0){
                num2 = element;
                c2 = 1;
            }else{
                c1--;
                c2--;
            }
        }
        c1=0;
        c2=0;
        for(int element : nums){
            if(element == num1){
                c1++;
            }else if(element == num2){
                c2++;
            }
        }
        if(c1 > freq && c2 > freq){
            ans.add(num1);
            ans.add(num2);
        }else if(c1 > freq){
            ans.add(num1);
        }else if(c2 > freq){
            ans.add(num2);
        }
        return ans;
    }
}