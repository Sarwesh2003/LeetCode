//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
         BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t= Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
            int n = Integer.parseInt(read.readLine());
            int matrix[][] = new int[n][n];
            String st[] = read.readLine().trim().split("\\s+");
            int k = 0;
            for(int i = 0; i < n; i++)
            {
                for(int j = 0; j < n; j++)
                    matrix[i][j] = Integer.parseInt(st[k++]);
            }
            Solution ob = new Solution();
            ob.rotateby90(matrix, n);
            for(int i = 0; i < n; i++)
            {
                for(int j = 0; j < n; j++)
                    System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    //Function to rotate matrix anticlockwise by 90 degrees.
    static void rotateby90(int matrix[][], int n){
        int i = 0, j;
        for(i = 0; i < n; ++i){
            reverse(matrix, i, n);
        }
        i = j = 0;
        
        while(i < n){
            j = i + 1;
            while(j < n){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
                ++j;
            }
            ++i;
        }
        
    }
    public static void reverse(int[][] matrix, int i, int n){
        int s = 0, e = n - 1;
        while(s < e){
            int temp = matrix[i][s];
            matrix[i][s] = matrix[i][e];
            matrix[i][e] = temp;
            ++s;
            --e;
        }
    }
}