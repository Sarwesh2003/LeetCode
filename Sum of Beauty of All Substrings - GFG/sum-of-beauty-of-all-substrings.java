//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            //br.readLine();
            String s;
            s = br.readLine();
            
            Solution obj = new Solution();
            int res = obj.beautySum(s);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static int beautySum(String s) {
        int n = s.length();
        int count = 0;
        for(int i = 0; i < n; ++i){
            int[] map = new int[26];
            for(int j = i; j < n; ++j){
                int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
                char ch = s.charAt(j);
                map[ch - 'a']++;
                for(int k = 0; k < 26; ++k){
                    max = Math.max(max, map[k]);
                    if(map[k] != 0){
                        min = Math.min(min, map[k]);
                    }
                }
                count += (max - min);
            }
        }
        return count;
    }
}
        
