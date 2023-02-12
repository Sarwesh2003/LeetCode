//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S[] = read.readLine().split(" ");
            int L = Integer.parseInt(S[0]);
            int R = Integer.parseInt(S[1]);
            int D = Integer.parseInt(S[2]);
            Solution ob = new Solution();
            ArrayList<Integer> ans = ob.goodNumbers(L, R, D);
            for (int i : ans) System.out.print(i + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    ArrayList<Integer> goodNumbers(int L, int R, int D) {
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = L; i <= R; ++i){
            int n = i;
            int temp = n % 10;
            if(temp == D)continue;
            n /= 10;
            while(n > 0){
                if(n % 10 != D && n % 10 > temp){
                    temp += n % 10;
                    n /= 10;
                }else{
                    break;
                }
            }
            if(n <= 0 && i != D)ans.add(i);
        }
        return ans;
    }
}