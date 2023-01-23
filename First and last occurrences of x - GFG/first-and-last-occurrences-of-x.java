//{ Driver Code Starts
//Initial Template for Java



import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function Template for Java


class GFG
{
    ArrayList<Long> find(long nums[], int n, int target)
    {
        ArrayList<Long> ans = new ArrayList<>();
        int s = 0, m = 0, e = nums.length;
        boolean flag = false;
        while(s < e){
            m = s + (e - s) / 2;
            if(nums[m] == target){
                flag = true;
                break;
            }
            if(nums[m] < target)
                s++;
            else
                e--;
        }
        if(!flag){
            ans.add(-1L);
            ans.add(-1L);
            return ans;
        }
        int i = m - 1;
        while(i >= 0 && nums[i] == nums[m]){
            --i;
        }
        int j = m + 1;
        while(j <= nums.length - 1 && nums[j] == nums[m])
            ++j;
        
        ans.add((long)i + 1);
        ans.add((long)j - 1);
        return ans;
    }
}



//{ Driver Code Starts.

// Driver class
class Array {

    // Driver code
    public static void main(String[] args) throws IOException {
        // Taking input using buffered reader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcases = Integer.parseInt(br.readLine());
        // looping through all testcases
        while (testcases-- > 0) {
//            int n = Integer.parseInt(br.readLine());
            String line = br.readLine();
            String[] q = line.trim().split("\\s+");
            int n =Integer.parseInt(q[0]);
            int x =Integer.parseInt(q[1]);
//            //int y =Integer.parseInt(q[2]);
            String line1 = br.readLine();
            String[] a1 = line1.trim().split("\\s+");
            long arr[] = new long[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Long.parseLong(a1[i]);
            }
            GFG ob = new GFG();
            ArrayList<Long> ans=ob.find(arr,n,x);
            System.out.println(ans.get(0)+" "+ans.get(1));
        }
    }
}

// } Driver Code Ends