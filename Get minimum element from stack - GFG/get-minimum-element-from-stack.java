//{ Driver Code Starts
import java.util.*;



class Get_Min_From_Stack
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while(T>0)
		{
			int q = sc.nextInt();
			GfG g = new GfG();
			while(q>0)
			{
				int qt = sc.nextInt();
				
				if(qt == 1)
				{
					int att = sc.nextInt();
					g.push(att);
					//System.out.println(att);
				}
				else if(qt == 2)
				{
					System.out.print(g.pop()+" ");
				}
				else if(qt == 3)
				{
					System.out.print(g.getMin()+" ");
				}
			
			q--;
			}
			System.out.println();
		T--;
		}
		
	}
}



// } Driver Code Ends


class GfG
{
    int minEle;
    Stack<Integer> s, s1;
    
    public GfG(){
        s = new Stack<>();
        s1 = new Stack<>();
    }
    /*returns min element from stack*/
    int getMin()
    {
        if(s1.isEmpty())return -1;
	    return s1.peek();
    }
    
    /*returns poped element from stack*/
    int pop()
    {
        if(s.isEmpty()){
            return -1;
        }
        int element = s.pop();
        s1.pop();
        return element;
    }

    /*push element x into the stack*/
    void push(int x)
    {
	    if(s.isEmpty()){
	        s.push(x);
	        s1.push(x);
	        return;
	    }else{
	        s.push(x);
	        s1.push(Math.min(x, s1.peek()));
	    }
    }	
}

