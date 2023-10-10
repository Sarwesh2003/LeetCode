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
        List<Integer> list = new ArrayList<>();
    	for(int i = 0; i < M.length; ++i){
    	    boolean flag = true;
    	    for(int j = 0; j < M[i].length; ++j){
    	        if(M[i][j] == 1){
    	            flag = false;
    	            break;
    	        }
    	    }
    	    if(flag){
    	        list.add(i);
    	    }
    	}
    	
    	int sz = list.size();
    	
    	if(sz == 0)return -1;
    	for(int candidate : list){
    	    boolean flag = true;
    	    for(int i = 0; i < M.length; ++i){
    	        if(i != candidate && M[i][candidate] == 0){
    	            flag = false;
    	            break;
    	        }
    	        if(i != candidate && M[candidate][i] == 1){
    	            flag = false;
    	            break;
    	        }
    	    }
    	    if(flag){
    	        return candidate;
    	    }
    	}
    	return -1;
    }
}