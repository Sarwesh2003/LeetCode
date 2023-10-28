//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.lang.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            String inputLine[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);

            int start[] = new int[n];
            int end[] = new int[n];

            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++)
                start[i] = Integer.parseInt(inputLine[i]);

            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) 
                end[i] = Integer.parseInt(inputLine[i]);
                
            int ans = new Solution().maxMeetings(start, end, n);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


class Solution 
{
    static class Node{
        int s, e;
        public Node(int s, int e){
            this.s = s;
            this.e = e;
        }
    }
    //Function to find the maximum number of meetings that can
    //be performed in a meeting room.
    public static int maxMeetings(int start[], int end[], int n)
    {
        if(n == 1)return n;
        PriorityQueue<Node> q = new PriorityQueue<>((a, b)->a.e - b.e);
        for(int i = 0; i < n; ++i){
            q.add(new Node(start[i], end[i]));
        }
        int cnt = 1;
        Node prev = q.poll();
        while(!q.isEmpty()){
            Node curr = q.poll();
            if(curr.s > prev.e){
                cnt++;
                prev = curr;
            }
        }
        return cnt;
    }
}
