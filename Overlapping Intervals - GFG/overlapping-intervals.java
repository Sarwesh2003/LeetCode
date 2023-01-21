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
            int n = Integer.parseInt(br.readLine().trim());
            String[] s = br.readLine().trim().split(" ");
            int[][] Intervals = new int[n][2];
            int j = 0;
            for(int i = 0; i < n; i++){
                Intervals[i][0] = Integer.parseInt(s[j]);
                j++;
                Intervals[i][1] = Integer.parseInt(s[j]);
                j++;
            }
            Solution obj = new Solution();
            int[][] ans = obj.overlappedInterval(Intervals);
            for(int i = 0; i < ans.length; i++){
                for(j = 0; j < ans[i].length; j++){
                    System.out.print(ans[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


class Solution
{
    public int[][] overlappedInterval(int[][] arr)
    {
        Arrays.sort(arr, (a, b) -> a[0] - b[0]);
        ArrayList<int[]> list = new ArrayList<>();
        int start = arr[0][0], end = arr[0][1];
        
        for(int[] a : arr){
            if(end >= a[0]){
                end = Math.max(end, a[1]);
            }else{
                list.add(new int[]{start, end});
                start = a[0];
                end = a[1];
            }
        }
        list.add(new int[]{start,end});
        int[][] ans = new int[list.size()][];
        ans = list.toArray(ans);
        return ans;
    }
}