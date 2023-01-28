//{ Driver Code Starts
import java.util.Scanner;

class SquartRoot
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t>0)
		{
			long a = sc.nextInt();
			Solution obj = new Solution();
			System.out.println(obj.floorSqrt(a));
		t--;
		}
	}
}
// } Driver Code Ends


/*You are required to complete
this function*/

// Function to find square root
// x: element to find square root
class Solution
{
     long floorSqrt(long x){
		long s = 0, m = 0, e = x;
        while(s <= e){
            m = s + (e - s) / 2;
            if(m * m == x){
                return m;
            }
            if(m * m > x){
                e = m - 1;
            }else{
                s = m + 1;
            }
        }
        return s - 1;
	 }
}
