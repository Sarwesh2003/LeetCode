//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            int N = sc.nextInt();

            Solution ob = new Solution();
            int ans  = ob.setBit(N);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java
class Solution{
    static int setBit(int N){
        
        StringBuilder bin = new StringBuilder(Integer.toBinaryString(N));
        for(int i = bin.length() - 1; i >= 0; --i){
            if(bin.charAt(i) == '0'){
                bin.setCharAt(i, '1');
                break;
            }
        }
        return Integer.parseInt(bin.toString(), 2);
    }
}