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

            int K;
            K = sc.nextInt();

            int N;
            N = sc.nextInt();

            Solution obj = new Solution();
            ArrayList<ArrayList<Integer>> ans = obj.combinationSum(K, N);
            Collections.sort(ans, new Comparator<ArrayList<Integer>>() {
                @Override   public int compare(ArrayList<Integer> a,
                                             ArrayList<Integer> b) {
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
            for (int i = 0; i < ans.size(); i++) {
                ArrayList<Integer> cur = ans.get(i);
                for (int j = 0; j < cur.size(); j++) {
                    System.out.print(cur.get(j) + " ");
                }
                System.out.println();
            }
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public static ArrayList<ArrayList<Integer>> combinationSum(int K, int N) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        solve(1, 0, N, ans, new ArrayList<>(), K);
        return ans;
    }
    public static void solve(int idx, int curr, int n, ArrayList<ArrayList<Integer>> ans, List<Integer> list, int k){
        if(curr > n)return;
        if(list.size() == k){
            if(curr == n){
                ans.add(new ArrayList<>(list));
            }
            return;
        }
        for(int i = idx; i <= 9; ++i){
            if(i + curr <= n){
                list.add(i);
                solve(i + 1, curr + i, n, ans, list, k);
                list.remove(list.size() - 1);
            }
        }

    }
}