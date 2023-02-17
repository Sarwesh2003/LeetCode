//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class PhoneDigit
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();//testcases
        
        
        while(t-- > 0)
        {
            int n = sc.nextInt(); // input size of array
            int arr[] = new int[n]; //input the elements of array that are keys to be pressed
            
            for(int i = 0; i < n; i++)
               arr[i] = sc.nextInt();//input the elements of array that are keys to be pressed
            ArrayList <String> res = new Solution().possibleWords(arr, n);
            for (String i : res) System.out.print (i + " ");
             System.out.println();
              
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    //Function to find list of all words possible by pressing given numbers.
    static ArrayList <String> possibleWords(int a[], int N){
        int n = a.length;
        if(n == 0)return new ArrayList<>();
        StringBuilder str = new StringBuilder();
        ArrayList<String> list = new ArrayList<>();
        for(int ch : a){
            list.add(getMapping(ch));
        }
        ArrayList<String> ans = new ArrayList<>();
        solve(0, new StringBuilder(), ans, list);
        return ans;
    }
    public static void solve(int idx, StringBuilder curr, ArrayList<String> ans, ArrayList<String> list){
        if(idx == list.size()){
            ans.add(curr.toString());
            return;
        }
        String s = list.get(idx);
        for(char ch : s.toCharArray()){
            curr.append(ch);
            solve(idx + 1, curr, ans, list);
            curr.deleteCharAt(curr.length() - 1);
        }
    }
    public static String getMapping(int ch){
        switch(ch){
            case 1: return "";
            case 2: return "abc";
            case 3: return "def";
            case 4: return "ghi";
            case 5: return "jkl";
            case 6: return "mno";
            case 7: return "pqrs";
            case 8: return "tuv";
            case 9: return "wxyz";
        }
        return "";
    }
}


