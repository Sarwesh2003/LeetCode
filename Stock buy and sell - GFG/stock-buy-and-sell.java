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
    class Interval{
        int buy, sell;
    }
    public void stockBuySell(int[] price, int n) {
        ArrayList<Interval> list = new ArrayList<Interval>();
        int i = 0;
        int count = 0;
        while(i < n-1){
            while(i < n - 1 && price[i + 1] <= price[i])i++;
            
            if(i == n - 1)break;
            
            Interval e = new Interval();
            
            e.buy = i++;
            
            while(i < n && price[i] >= price[i - 1])i++;
            
            e.sell = i - 1;
            list.add(e);
            count++;
        }
        if(count == 0){
            System.out.println("No Profit");
            return;
        }
        for(i = 0; i < count; ++i){
            Interval in = list.get(i);
            System.out.print("("+in.buy + " " + in.sell +") ");
        }
        System.out.println();
    }
}