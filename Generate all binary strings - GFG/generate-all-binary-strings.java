//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    while (T-- > 0) {
      int n = sc.nextInt();
      Solution obj = new Solution();
      List<String> ans = obj.generateBinaryStrings(n);
      for(String s : ans) System.out.print(s+" ");
      System.out.println();
    }
  }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
  public static List<String> generateBinaryStrings(int n) {
    List<String> ans = new ArrayList<>();
    solve(n, ans, new StringBuilder(""));
    return ans;
  }
  public static void solve(int n, List<String> ans, StringBuilder curr){
      if(curr.length() == n){
          if(isValid(curr))
            ans.add(curr.toString());
          return;
      }
      solve(n, ans, curr.append('0'));
      curr.delete(curr.length() - 1, curr.length());
      solve(n, ans, curr.append('1'));
      
      curr.delete(curr.length() - 1, curr.length());
  }
  public static boolean isValid(StringBuilder str){
      for(int i = 0; i < str.length() - 1; ++i){
          if(str.charAt(i) == '1' && str.charAt(i + 1) == '1')return false;
      }
      return true;
  }
}
     
     