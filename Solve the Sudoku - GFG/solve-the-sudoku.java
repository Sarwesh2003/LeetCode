//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Driver_class
{
    public static void main(String args[])
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int grid[][] = new int[9][9];
            for(int i = 0; i < 9; i++)
            {
                for(int j = 0; j < 9; j++)
                grid[i][j] = sc.nextInt();
            }
            
            Solution ob = new Solution();
            
            if(ob.SolveSudoku(grid) == true)
                ob.printGrid(grid);
            else
                System.out.print("NO solution exists");
            System.out.println();
            
        }
    }
}




// } Driver Code Ends


//User function Template for Java

class Solution
{
    //Function to find a solved Sudoku. 
    static boolean SolveSudoku(int board[][])
    {
        for(int r = 0; r < board.length; ++r){
            for(int c = 0; c < board[0].length; ++c){
                if(board[r][c] == 0){
                    for(int i = 1; i <= 9; ++i){
                        if(isSafe(board, r, c, i)){
                            board[r][c] = i;
                            if(SolveSudoku(board))
                                return true;
                            else
                                board[r][c] = 0;
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    
    //Function to print grids of the Sudoku.
    static void printGrid (int grid[][])
    {
        if(SolveSudoku(grid)){
            for(int i = 0; i < grid.length; ++i){
                for(int j = 0; j < grid[i].length; ++j){
                    System.out.print(grid[i][j] +" ");
                }
            }
        }
    }
    public static boolean isSafe(int[][] board, int r, int c, int ch){
        for(int i = 0; i < 9; ++i){
            if(board[r][i] == ch)return false;

            if(board[i][c] == ch)return false;

            if(board[3 * (r / 3) + i / 3][3 * (c / 3) + i % 3] == ch)return false;
            
        }
        return true;
    }
}