//{ Driver Code Starts
//Initial Template for Java



import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int x = Integer.parseInt(inputLine[1]);
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            Pair ans = new Solve().getFloorAndCeil(arr, n, x);
            System.out.println(ans.floor + " " + ans.ceil);
        }
    }
}

class Pair {
    int floor, ceil;

    Pair() {
        this.floor = 0;
        this.ceil = 0;
    }

    Pair(int floor, int ceil) {
        this.floor = floor;
        this.ceil = ceil;
    }
}

// } Driver Code Ends


//User function Template for Java




class Solve {
    Pair getFloorAndCeil(int[] arr, int n, int x) {
        Pair ans = new Pair(-1, -1);
        Arrays.sort(arr);
        if(x < arr[0]){
            ans.ceil = arr[0];
            return ans;
        }
        int s = 0, m = 0, e = n;
        while(s < e){
            m = s + (e - s) / 2;
            if(arr[m] == x){
                ans.floor = arr[m];
                ans.ceil = arr[m];
                return ans;
            }
            if(arr[m] > x){
                e--;
            }else{
                s++;
            }
        }
        
        if(arr[m] > x){
            ans.floor = -1;
            ans.ceil = arr[m];
        }else{
            ans.floor = arr[m];
            if(m < n - 1){
                ans.ceil = arr[m+1];
            }else{
                ans.ceil = -1;
            }
        }
        return ans;
    }
}

