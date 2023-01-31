//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            String s;
            s = br.readLine();

            Solution obj = new Solution();
            String res = obj.removeOuter(s);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends


class Solution {
    public static String removeOuter(String s) {
        StringBuilder sb = new StringBuilder(s);
        int open = 0, close = 0;
        int j = 0;
        StringBuilder ans = new StringBuilder("");
        for(int i = 0; i < sb.length(); ++i){
            char ch = sb.charAt(i);
            if(ch == '('){
                ++open;
            }else if(ch == ')'){
                ++close;
            }
            if(open == close){
                ans.append(sb.substring(j+1, i));
                open = 0;
                close = 0;
                j = i + 1;
            }
        }
        return ans.toString();
    }
}
