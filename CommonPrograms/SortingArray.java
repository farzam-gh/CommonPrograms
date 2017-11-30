import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		ArrayList<Integer> al=new ArrayList<>();
		int t=sc.nextInt();
		while(t>0){
		    int n=sc.nextInt();
		    for(int i=0;i<n;i++){
		        al.add(sc.nextInt());
		    }//end of for i
		    solve(al,n);
		    System.out.println("");
		    al.clear();
		    t--;
		}//end of while
	}//end of main
	static void solve(ArrayList<Integer> al,int n){
	    ArrayList<Node> aln=new ArrayList<>();
	    ArrayList<Integer>temp=new ArrayList<Integer>(al);
	    int s1=0;
	    int s2=0;
	    int i=0;
	    Integer t=0;
	    while(temp.size()>0){
	        s1=temp.size();
	        t=al.get(i);
	        while(temp.contains(t))
	            temp.remove(t);
	        s2=temp.size();
	        if(s1-s2>0)
	        aln.add(new Node(al.get(i++),s1-s2));
	        else i++;
	        
	    }//end of while
	    Collections.sort(aln,new Comparator<Node>(){
	        public int compare(Node n1,Node n2){
	            int result=n2.r-n1.r;
	            if(result!=0)
	                return result;
	            return n1.v-n2.v;  
	        }//end of compare
	    });
	    for(Node x:aln)
	        for(int j=0;j<x.r;j++)
	    System.out.print(x.v+" ");
	}//end of solve
}//end
class Node{
    int v;
    int r;
    Node(int v,int r){
        this.v=v;
        this.r=r;
        //System.out.println(v+" : "+r+" ");
    }//end of constructor
}//end of Node