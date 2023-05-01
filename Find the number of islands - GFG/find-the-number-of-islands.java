//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            char[][] grid = new char[n][m];
            for (int i = 0; i < n; i++) {
                String[] S = br.readLine().trim().split(" ");
                for (int j = 0; j < m; j++) {
                    grid[i][j] = S[j].charAt(0);
                }
            }
            Solution obj = new Solution();
            int ans = obj.numIslands(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


class Solution {
    static class Node{
        int row;
        int col;
        public Node(){}
        public Node(int first, int sec){
            this.row = first;
            this.col = sec;
        }
    }
    // Function to find the number of islands.
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        
        int cnt = 0; 
        boolean[][] vis = new boolean[n][m];
        for(int i = 0; i < n; ++i){
            for(int j = 0; j < m; ++j){
                if(!vis[i][j] && grid[i][j] == '1'){
                    BFS(i, j, grid, vis);
                    cnt++;
                }
            }
            
        }
        return cnt;
    }
    public void BFS(int row, int col, char[][] grid, boolean[][] vis){
        Queue<Node> q = new LinkedList<>();
        vis[row][col] = true;
        q.add(new Node(row, col));
        int n = grid.length;
        int m = grid[0].length;
        while(!q.isEmpty()){
            Node curr = q.poll();
            int r = curr.row;
            int c = curr.col;
            for(int delrow = -1; delrow <= 1; ++delrow){
                for(int delcol = -1; delcol <= 1; ++delcol){
                    int newrow = r + delrow;
                    int newcol = c + delcol;
                    
                    if(newrow >= 0 && newrow < n && newcol >= 0 && newcol < m && grid[newrow][newcol] == '1' && vis[newrow][newcol] != true){
                        vis[newrow][newcol] = true;
                        q.add(new Node(newrow, newcol));
                    }
                }
            }
        }
    }
}