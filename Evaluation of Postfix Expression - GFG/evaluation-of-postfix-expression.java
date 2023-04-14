//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
		    System.out.println(new Solution().evaluatePostFix(br.readLine().trim()));
		}
	}
}
// } Driver Code Ends


class Solution
{
    //Function to evaluate a postfix expression.
    public static int evaluatePostFix(String S)
    {
        Stack<Integer> s = new Stack<>();
        int res = 0;
        for(char ch : S.toCharArray()){
            if(Character.isDigit(ch)){
                s.push(ch - '0');
            }else{
                if(s.size() >= 2){
                    res = eval(ch, s.pop(), s.pop());
                    s.push(res);
                }else if(!s.isEmpty()){
                    if(ch == '+')res = s.pop();
                    else if(ch == '-')res = s.pop();
                    else if(ch == '*')res = s.pop();
                    else res = s.pop();
                    s.push(res);
                }
            }
        }
        return res;
    }
    
    public static int eval(char op, int b, int a){
        switch(op){
            case '+': return (a + b);
            case '-': return (a - b);
            case '/': return (a / b);
            case '*': return (a * b);
        }
        return 0;
    }
}