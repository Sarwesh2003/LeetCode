//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Main {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String s = br.readLine();
            Solution obj = new Solution();
            System.out.println(obj.maxOdd(s));
        }
    }
}
// } Driver Code Ends


class Solution {

    String maxOdd(String s) {
        int n = s.length();
        StringBuilder num2 = new StringBuilder(s);
        if((num2.charAt(n - 1) - '0') % 2 != 0){
            return s;
        }
        
        StringBuilder max = new StringBuilder();
        for(int i = 0; i < n; ++i){
            char ch = num2.charAt(i);
            if((ch - '0') % 2 != 0){
                max = max.replace(0, max.length(),num2.substring(0, i + 1));
            }
        }
        return String.valueOf(max);
    }
}