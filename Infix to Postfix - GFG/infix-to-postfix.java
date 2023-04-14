//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {

    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            System.out.println(
                new Solution().infixToPostfix(br.readLine().trim()));
        }
    }
}
// } Driver Code Ends


class Solution {
    // Function to convert an infix expression to a postfix expression.
    public static String infixToPostfix(String exp) {
        Stack<Character> s = new Stack<>();
        StringBuilder ans = new StringBuilder();
        for(char ch : exp.toCharArray()){
            if(Character.isLetterOrDigit(ch)){
                ans.append(ch);
            }else{
                if(s.isEmpty()){

                    s.push(ch);

                }else if(ch == '('){
                    
                    s.push(ch);

                }else if(ch == ')'){

                    while(!s.isEmpty() && s.peek() != '(')ans.append(s.pop());
                    s.pop();
                }else{
                    while(!s.isEmpty() && precedence(s.peek()) >= precedence(ch)){
                        ans.append(s.pop());
                    }
                    s.push(ch);
                }
            }
        }
        while(!s.isEmpty()){
            if(s.peek() != '(')
                ans.append(s.pop());
            else
                s.pop();
        }
        return ans.toString();
        
    }

    public static int precedence(char ch){
        switch(ch){
            case '^': return 3;
            
            case '*':
            case'/': return 2;
            
            case '+':
            case '-': return 1;
            
        }
        return -1;
    }
}