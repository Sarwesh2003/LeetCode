//{ Driver Code Starts
//Initial template for JAVA

import java.util.Scanner;

class aToi
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		sc.nextLine();
		while(t>0)
		{
			String str = sc.nextLine();
			
			Solution obj = new Solution();
			System.out.println(obj.atoi(str));
		t--;
		}
	}
}
// } Driver Code Ends


//User function template for JAVA

/*You are required to complete this method */
class Solution
{
    int atoi(String s) {
	    StringBuilder sb = new StringBuilder("");
        int idx = 0;
        char[] ch = s.toCharArray();
        while(idx < ch.length && ch[idx] == ' '){
            ++idx;
        }
        int sign = 1;
        if(idx < ch.length && (ch[idx] == '-' || ch[idx] == '+')){
            sign = ch[idx++] == '-' ? -1 : 1;
        }

        while(idx < ch.length && ch[idx] == '0'){
            ++idx;
        }
        int start = 0;
        while(idx < ch.length && Character.isDigit(ch[idx])){
            start = idx++;
            while(idx < ch.length && Character.isDigit(ch[idx])){
                idx++;
            }
            for(int i = start; i < idx; ++i){
                sb.append(ch[i]);
            }
            if(idx != ch.length){
                return -1;
            }
            try{
                return Integer.parseInt(sb.toString()) * sign;
            }catch(NumberFormatException e){
                return sign == -1 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
        }        
        return -1;
    }
}
