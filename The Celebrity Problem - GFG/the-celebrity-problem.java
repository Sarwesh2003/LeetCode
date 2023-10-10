//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0)
        {
            int N = sc.nextInt();
            int M[][] = new int[N][N];
            for(int i=0; i<N; i++)
            {
                for(int j=0; j<N; j++)
                {
                    M[i][j] = sc.nextInt();
                }
            }
            System.out.println(new Solution().celebrity(M,N));
            t--;
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java


class Solution
{ 
    //Function to find if there is a celebrity in the party or not.
    int celebrity(int M[][], int n)
    {
        Stack<Integer> s = new Stack<>();
        for(int i = 0; i < n; ++i){
            s.push(i);
        }
        
        while(s.size() > 1){
            int i = s.pop();
            int j = s.pop();
            
            if(M[i][j] == 0 && M[j][i] == 1){
                s.push(i);
            }
            if(M[j][i] == 0 && M[i][j] == 1){
                s.push(j);
            }
        }
        if(s.empty())return -1;
        
        while(!s.empty()){
            int candidate = s.pop();
            boolean flag = true;
            for(int i = 0; i < n; ++i){
                if(i != candidate && M[candidate][i] == 1){
                    flag = false;
                    break;
                }
                if(i != candidate && M[i][candidate] == 0){
                    flag = false;
                    break;
                }
            }
            if(flag)return candidate;
        }
        return -1;
        
        
    }
}