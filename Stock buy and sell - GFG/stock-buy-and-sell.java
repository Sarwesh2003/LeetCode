//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine().trim());

        while (tc-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            int[] price = new int[n];
            String[] str = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                price[i] = Integer.parseInt(str[i]);
            }
            Solution sln = new Solution();
            sln.stockBuySell(price, n);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public void stockBuySell(int[] price, int n) {
        ArrayList<int[]> list = new ArrayList<>();
        int i = 0;
        while(i < n - 1){
            while(i < n - 1 && price[i + 1] <= price[i])++i;
            
            if(i == n - 1)break;
            
            int p1 = i++;
            while(i < n && price[i] >= price[i - 1])++i;
            
            list.add(new int[]{p1, i - 1});
        }
        if(list.size() < 1){
            System.out.println("No Profit");
            return;
        }
        for(int[] profit : list){
            System.out.print("("+profit[0]+" "+profit[1]+") ");
        }
        System.out.println();
    }
}