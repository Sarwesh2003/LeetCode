// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String A = br.readLine().trim();
            Solution ob = new Solution();
            String ans = ob.FirstNonRepeating(A);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


class Solution
{
    
    public String FirstNonRepeating(String A)
    {
        String str = "";
        HashMap<Character, Integer> map = new HashMap<>();
        Queue<Character> q = new LinkedList<>();
        for(char ch : A.toCharArray()){
            
            if(map.containsKey(ch)){
                int count = map.get(ch);
                map.put(ch, count+1);
            }else{
                map.put(ch, 1);
            }
            q.add(ch);
            while(q.size() > 0){
                if(map.get(q.peek()) > 1){
                    q.remove();
                }else{
                    str+=q.peek();
                    break;
                }
            }
            if(q.size() <= 0){
                str+='#';
            }
            
        }
        return str;

    }
}