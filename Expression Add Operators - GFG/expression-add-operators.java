//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            String S;
            S = br.readLine();

            int target;
            target = Integer.parseInt(br.readLine());

            Solution obj = new Solution();
            ArrayList<String> res = obj.addOperators(S, target);
            Collections.sort(res);
            for (String s : res) System.out.print(s + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends


class Solution {
    public static ArrayList<String> addOperators(String S, int target) {
        ArrayList<String> list = new ArrayList<>();
        if(S.length() == 0)return list;

        solve(S, target, "", 0, 0, 0, list);
        return list;
    }
    public static void solve(String num, int tgt, String path, long calc, int idx, long prev,  ArrayList<String> ans){
        if(idx == num.length()){
            if(calc == tgt){
                ans.add(path);
            }
            return;
        }

        for(int i = idx; i < num.length(); ++i){
           if(i != idx && num.charAt(idx) == '0')break;

           long currVal = Long.parseLong(num.substring(idx, i + 1));
           if(idx == 0){
               solve(num, tgt, path + currVal, currVal, i + 1, currVal, ans);
           }else{
               solve(num, tgt, path + '+' + currVal, calc + currVal, i + 1, currVal, ans);
               solve(num, tgt, path + '-' + currVal, calc - currVal, i + 1, -currVal, ans);
               solve(num, tgt, path + '*' + currVal, calc - prev + prev * currVal, i + 1, currVal * prev, ans);
           }
        }
    }
}
