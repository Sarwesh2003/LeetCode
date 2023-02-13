//{ Driver Code Starts
import java.util.Scanner;
import java.util.Stack;
class SortedStack{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0){
			Stack<Integer> s=new Stack<>();
			int n=sc.nextInt();
			while(n-->0)
			s.push(sc.nextInt());
			GfG g=new GfG();
			Stack<Integer> a=g.sort(s);
			while(!a.empty()){
				System.out.print(a.peek()+" ");
				a.pop();
			}
			System.out.println();
		}
	}
}
// } Driver Code Ends


/*Complete the function below*/
class GfG{
	public Stack<Integer> sort(Stack<Integer> s)
	{
		Stack<Integer> ans = new Stack<>();
		while(s.size() > 0){
		    int ele = s.pop();
		    solve(ans, ele);
		}
	    return ans;
	    
	}
	public void solve(Stack<Integer> s, int ele){
	    if(s.size() == 0 || s.peek() < ele){
	        s.push(ele);
	        return;
	    }
	    int temp = s.pop();
	    solve(s, ele);
	    s.push(temp);
	}
}