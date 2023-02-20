//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
class Rat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] a = new int[n][n];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++) a[i][j] = sc.nextInt();

            Solution obj = new Solution();
            ArrayList<String> res = obj.findPath(a, n);
            Collections.sort(res);
            if (res.size() > 0) {
                for (int i = 0; i < res.size(); i++)
                    System.out.print(res.get(i) + " ");
                System.out.println();
            } else {
                System.out.println(-1);
            }
        }
    }
}

// } Driver Code Ends


// User function Template for Java

// m is the given matrix and n is the order of matrix
class Solution {
    public static ArrayList<String> findPath(int[][] m, int n) {
        if(m[0][0] == 0)return new ArrayList<String>();
        ArrayList<String> list = new ArrayList<>();
        solve(m, n, 0, 0, new StringBuilder(), list);
        return list;
    }
    public static void solve(int[][] m, int n, int row, int col, StringBuilder path, ArrayList<String> ans){
        if(row == n - 1 && col == n - 1){
            ans.add(path.toString());
            return;
        }
        m[row][col] = -1;
        if(row > 0 && m[row - 1][col] == 1){
            path.append("U");
            solve(m, n, row - 1, col, path, ans);
            path.deleteCharAt(path.length() - 1);
        }
        if(row < n - 1 && m[row + 1][col] == 1){
            path.append("D");
            solve(m, n, row + 1, col, path, ans);
            path.deleteCharAt(path.length() - 1);
        }
        if(col > 0 && m[row][col - 1] == 1){
            path.append("L");
            solve(m, n, row, col - 1, path, ans);
            path.deleteCharAt(path.length() - 1);
        }
        if(col < n - 1 && m[row][col + 1] == 1){
            path.append("R");
            solve(m, n, row, col + 1, path, ans);
            path.deleteCharAt(path.length() - 1);
        }
        m[row][col] = 1;
    }
}