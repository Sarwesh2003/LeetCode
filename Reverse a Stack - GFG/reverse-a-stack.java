//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        PrintWriter out=new PrintWriter(System.out);
        
        //taking testcases
        int t = Integer.parseInt(br.readLine()); 
    	for(int i=0;i<t;i++)
    	{
            String str=br.readLine();
    		
    		//input n and d
    	    int n=Integer.parseInt(str);
    		Stack<Integer> stack=new Stack<>();
    		String str1=br.readLine();
    		String[] starr1=str1.split(" ");
    		//inserting elements in the array
    		for(int j=0;j<n;j++)
    		{
    		    stack.push(Integer.parseInt(starr1[j]));
    		}
    		//calling reverse() function
            Solution.reverse(stack);
            for(int j:stack){
                out.print(j+" ");
            }
            out.println();
         }
         out.close();
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{ 
    static int cnt = 0;
    static void reverse(Stack<Integer> s)
    {
        cnt = 0;
        int i = 0;
        while(i < s.size()){
            int ele = s.pop();
            solve(s, ele, i);
            ++i;
        }
    }
    public static void solve(Stack<Integer> s, int ele, int i){
        if(s.size() == i){
            s.push(ele);
            cnt++;
            return;
        }
        int temp = s.pop();
        solve(s, ele, i);
        s.push(temp);
    }
}