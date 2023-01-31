//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            String s = sc.next();
            Solution obj = new Solution();
            System.out.println(obj.reverseWords(s));
            t--;
        }
    }
}

// } Driver Code Ends



class Solution 
{
    //Function to reverse words in a given string.
    String reverseWords(String s)
    {
        StringBuilder ans = new StringBuilder("");
        String[] split = s.split("[.]");
        for(int i = split.length - 1; i >= 0; --i){
            // if(!split[i].contains(" ")){
            //     split[i] = split[i].strip();
            // }
            if(!split[i].equals("")){
                ans.append(split[i]);
                if(i > 0){
                    ans.append(".");
                }
            }
        }
        return ans.toString();
    }
}