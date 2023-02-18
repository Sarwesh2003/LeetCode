//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] S = br.readLine().trim().split(" ");
            int n = Integer.parseInt(S[0]);
            int m = Integer.parseInt(S[1]);
            char [][] board = new char[n][m];
            for(int i = 0; i < n; i++){
                String[] s = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++){
                    board[i][j] = s[j].charAt(0);
                }
            }
            String word = br.readLine().trim();
            Solution obj = new Solution();
            boolean ans = obj.isWordExist(board, word);
            if(ans)
                System.out.println("1");
            else
                System.out.println("0");
       }
    }
}
// } Driver Code Ends


class Solution
{
    public boolean isWordExist(char[][] board, String word)
    {
        for(int i = 0; i < board.length; ++i){
            for(int j = 0; j < board[i].length; ++j){
                if(board[i][j] == word.charAt(0) && solve(board, word, 0, i, j)){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean solve(char[][] b, String w, int idx, int i, int j){
        if(idx == w.length()){
            return true;
        }
        if(i >= b.length || i < 0 || j >= b[0].length || j < 0 || b[i][j] == '1' || b[i][j] != w.charAt(idx)){
            return false;
        }
        char temp =  b[i][j];
        b[i][j] = '1';
        boolean res = solve(b, w, idx + 1, i + 1, j) || solve(b, w, idx + 1, i - 1, j) ||
        solve(b, w, idx + 1, i, j + 1) || solve(b, w, idx + 1, i, j - 1);
        b[i][j] = temp;
        return res;
    }
}