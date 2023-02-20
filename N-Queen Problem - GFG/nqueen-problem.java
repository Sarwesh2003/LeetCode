//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
import java.lang.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0) {
            int n = Integer.parseInt(in.readLine());
            
            Solution ob = new Solution();
            ArrayList<ArrayList<Integer>> ans = ob.nQueen(n);
            if(ans.size() == 0)
                System.out.println("-1");
            else {
                for(int i = 0;i < ans.size();i++){
                    System.out.print("[");
                    for(int j = 0;j < ans.get(i).size();j++)
                        System.out.print(ans.get(i).get(j) + " ");
                    System.out.print("] ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution{
    static ArrayList<ArrayList<Integer>> nQueen(int n) {
        char[][] board = new char[n][n];
        for(char[] arr:board){
            Arrays.fill(arr, '.');
        }
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        for(char[] arr:board){
            Arrays.fill(arr, '.');
        }
        solve(board, 0, n, ans, new ArrayList<Integer>());
        return ans;
    }
     public static void solve(char[][] board, int col, int n, ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> list){
        if(col == n){
            if(list.size() == n)
                ans.add(new ArrayList<>(list));
            return;
        }
        for(int row = 0; row < n; ++row){
            if(canPlace(board, row, col, n)){
                board[row][col] = 'Q';
                list.add(col, row + 1);
                solve(board, col + 1, n, ans, list);
                board[row][col] = '.';
                list.remove(col);
            }
        }
    }
    public static boolean canPlace(char[][] board, int row, int col, int n){
        int dupr = row;
        int dupc = col;
        while(row >= 0 && col >= 0){
            if(board[row][col] == 'Q')return false;
            row--;
            col--;
        }
        row = dupr;
        col = dupc;
        while(col >= 0){
            if(board[row][col] == 'Q')return false;
            col--;
        }
        col = dupc;
        while(row < n && col >= 0){
            if(board[row][col] == 'Q')return false;
            row++;
            col--;
        }
        return true;
    }
}