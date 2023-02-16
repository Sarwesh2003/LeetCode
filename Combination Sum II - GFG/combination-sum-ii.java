//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t;
        t = sc.nextInt();
        while (t-- > 0) {

            int n = sc.nextInt();
            int k = sc.nextInt();
            int[] candidates = new int[n];
            for (int i = 0; i < n; i++) candidates[i] = sc.nextInt();

            Solution obj = new Solution();
            List<List<Integer>> ans = obj.combinationSum2(candidates, k);
            Collections.sort(ans, new Comparator<List<Integer>>() {
                @Override   public int compare(List<Integer> a, List<Integer> b) {
                    int al = a.size();
                    int bl = b.size();
                    int min = Math.min(al, bl);
                    for (int i = 0; i < min; i++) {
                        if (a.get(i) < b.get(i))
                            return -1;
                        else if (a.get(i) > b.get(i))
                            return 1;
                    }
                    if (al < bl)
                        return -1;
                    else if (al > bl)
                        return 1;
                    return -1;
                }
            });
            System.out.print("[ ");
            for (int i = 0; i < ans.size(); i++) {
                System.out.print("[ ");
                for (int j = 0; j < ans.get(i).size(); j++)
                    System.out.print(ans.get(i).get(j) + " ");
                System.out.print("]");
            }
            System.out.println(" ]");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public static List<List<Integer>> combinationSum2(int[] a, int s) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(a);
        solve(a, s, ans, 0, new ArrayList<Integer>());
        return ans;
    }
    public static void solve(int[] c, int tgt, List<List<Integer>> ans, int idx, ArrayList<Integer> list){

        for(int i = idx; i < c.length; ++i){
            if(i == idx || c[i] != c[i - 1]){
                if(c[i] == tgt){
                ArrayList<Integer> temp = new ArrayList<>(list);
                temp.add(c[i]);
                ans.add(temp);
                return;
            }else if(c[i] > tgt){return;}
            else{
                list.add(c[i]);
                solve(c, tgt - c[i], ans, i + 1, list);
                list.remove(list.size() - 1);
            }
            }
        }
    }
}