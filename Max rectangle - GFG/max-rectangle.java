// { Driver Code Starts
import java.util.*;

class FindMinCost
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t > 0)
		{
			int n = sc.nextInt();
			int m = sc.nextInt();
			int arr[][] = new int[n][m];
			for(int i=0; i<n; i++)
			{
				for(int j=0; j<m; j++ )
				{
					arr[i][j] = sc.nextInt();
				}
			}
			System.out.println(new Solution().maxArea(arr, n, m));
		t--;
		}
	}
}// } Driver Code Ends


/*Complete the function given below*/
class Solution {
    public int maxArea(int M[][], int n, int m) {
        int max = Integer.MIN_VALUE;
        int[] area = new int[m];
        for(int i=0; i<n; ++i){
            for(int j=0; j<m; ++j){
                if(M[i][j]!=0)
                    area[j] += M[i][j];
                else
                    area[j] = 0;
            }
            int newArea = calcArea(area);
            max = newArea > max?newArea:max;
        }
        return max;
    }
    
    private int calcArea(int[] arr){
        int max = Integer.MIN_VALUE;
        
        int[] prev = prevSmaller(arr);
        int[] next = nextSmaller(arr);
        
        for(int i=0; i<arr.length; ++i){
            int b = (next[i] - prev[i]) + 1;
            int area = arr[i] * b;
            max = area > max?area:max;
        }
        return max;
    }
    private int[] prevSmaller(int[] arr){
        int n = arr.length;
        Stack<Integer> s = new Stack<>();
        int[] ans = new int[n];
        for(int i=0; i<n; ++i){
            int element = arr[i];
            while(!s.empty() && arr[s.peek()] >= element){
                s.pop();
            }
            if(s.empty()){
                ans[i] = 0;
            }else{
                ans[i] = s.peek()+1;
            }
            s.push(i);
        }
        return ans;
    }
    private int[] nextSmaller(int[] arr){
        int n = arr.length;
        Stack<Integer> s = new Stack<>();
        int[] ans = new int[n];
        for(int i=n-1; i>=0; --i){
            int element = arr[i];
            while(!s.empty() && arr[s.peek()] >= element){
                s.pop();
            }
            if(s.empty()){
                ans[i] = n-1;
            }else{
                ans[i] = s.peek()-1;
            }
            s.push(i);
        }
        return ans;
    }
    
}