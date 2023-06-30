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
    
	public Stack<Integer> sort(Stack<Integer> s){
	   reverse(s);
	   return s;
	}
	
	
	public Stack<Integer> reverse(Stack<Integer> s){
	    
	    if(s.size()>0){
	        int element = s.peek();
	        s.pop();
	        reverse(s);
	        sort_and_insert(s,element);
	    }
	    return s;
	}
	
	public Stack<Integer> sort_and_insert(Stack<Integer> s,int x){
	    
	    if(s.size()==0 || x>s.peek()){
	        s.push(x);
	    }
	    else{
	        int element = s.peek();
	        s.pop();
	        sort_and_insert(s,x);
	        s.push(element);
	    }
	    
	    return s;
	}
	
	
}