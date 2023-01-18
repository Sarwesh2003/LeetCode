//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int n;
            n = Integer.parseInt(br.readLine());
            
            
            int[] nums = IntArray.input(br, n);
            
            Solution obj = new Solution();
            ArrayList<Integer> res = obj.Solve(n, nums);
            
            IntArray.print(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static ArrayList<Integer> Solve(int n, int[] nums) {
        int n1 = -1, n2 = -1, c1 = 0, c2 = 0;
        // int n = nums.length;
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < n; ++i){
            if(nums[i] == n1){
                c1++;
            }else if(nums[i] == n2){
                c2++;
            }else if(c1 == 0){
                n1 = nums[i];
                c1 = 1;
            }else if(c2 == 0){
                n2 = nums[i];
                c2 = 1;
            }else{
                c1--;
                c2--;
            }
        }
        
        c1 = c2 = 0;
        for(int ele : nums){
            if(ele == n1){
                c1++;
            }else if(ele == n2){
                c2++;
            }
        }
        if(c1 > (n / 3)){
            list.add(n1);
        }
        if(c2 > (n / 3)){
            list.add(n2);
        }
        if(c1 <= (n / 3) && c2 <= (n / 3))
        list.add(-1);
        
        return list;
    }
}
        
