// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
	        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while(t-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            long a[] = new long[(int)(n)];
            // long getAnswer[] = new long[(int)(n)];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(inputLine[i]);
            }
            int k = Integer.parseInt(br.readLine().trim());
            
            Compute obj = new Compute();
            long answer[] = obj.printFirstNegativeInteger(a, n, k);
            int sz = answer.length;
            
            StringBuilder output = new StringBuilder();
            for(int i=0;i<sz;i++)
                output.append(answer[i]+" ");
            System.out.println(output);
            
        }
	}
}

// } Driver Code Ends


//User function Template for Java


class Compute {
    
    public long[] printFirstNegativeInteger(long a[], int n, int k)
    {
//  ;       int n = a.length
        ArrayList<Long> list = new ArrayList<>();
        
        for(int i=0;i<n;++i){
            int flag = 0, flag2 = 0;
            for(int j=i;(i+k)<=n && j<(i+k);j++){
                flag2 = 1;
                if(a[j] < 0){
                    list.add(a[j]);
                    flag = 1;
                    break;
                }
            }
            if(flag2 != 0 && flag == 0)
                list.add((long)0);
        }
        
        long[] arr = new long[list.size()];
        for(int i=0; i<list.size(); ++i){
            arr[i] = list.get(i);
        }
        return arr;
    }
}