import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		char[] in;
		int t=sc.nextInt();
		while(t>0){
		    int n=sc.nextInt();
		    int m=sc.nextInt();
		    in=new char[n*m];
		    for(int i=0;i<n*m;i++){
		        in[i]=sc.next().charAt(0);
		    }//end of for i
		    solve(in,n,m);
		    System.out.println("");
		    t--;
		}//end of while
	}//end of main
	static void solve(char[] in,int n,int m){
	    Graph g=new Graph(n*m);
	     Node current;
	    for(int i=0;i<n*m;i++){
	       current=g.vertices.get(i);
	        current.name=in[i];
	        if(i%m>0)
	            g.addEdge(i,i-1);
	        if(i%m!=m-1)
	            g.addEdge(i,i+1);
	        if(i-m>0)
	            g.addEdge(i,i-m); 
	        if(i+m<n*m)
	            g.addEdge(i,i+m);  
	    }//end of for
	    for(int i=0;i<m*n;i++){
	        current=g.vertices.get(i);
	        if(current.name=='O'){
	            current.name=bfs(g,i,m,n);
	        }//end if
	        System.out.print(current.name+" ");
	           // if(i%m==m-1)
	               // System.out.println("");
	    }//end of for
	         
	}//end of solve
	
	public static char bfs(Graph g,int s,int m,int n){
	    Node current=g.vertices.get(s);
	    Queue<Integer> q=new LinkedList<>();
	    q.add(s);
	    boolean[] visited=new boolean[m*n];
	    for(int i=0;i<m*n;i++)
	        visited[i]=false;
	        if(current.name=='O' && current.data%m==0 || current.data/m==0 
	        || current.data%m==m-1 || current.data/m==n-1)
	                        return 'O';
	    do{
	        if(!q.isEmpty())
	        current=g.vertices.get(q.poll());
	        for(Integer x:current.adj){
	            if(visited[x]==false && g.vertices.get(x).name=='O'){
	                    if(x%m==0 || x/m==0 || x%m==m-1 || x/m==n-1)
	                        return 'O';
	                    q.add(x); 
	                    visited[x]=true;
	            }//end if
	        }//end of for
	             
	    }while(!q.isEmpty() );
	        return 'X';
	}//end of bfs
	
}//end
class Node{
    int data;
    char name;
    HashSet<Integer> adj=new HashSet<>();
     Node(int data){
         this.data=data;
     }//end of constructor
     public void addEdge(int d){
         adj.add(d);
     }//end of addEdge
     public void setName(char c){
         this.name=c;
     }//end of setName
     public void removeEdge(int d){
         adj.remove(d);
     }//end of removeEdge
}//end of Node class

class Graph{
    ArrayList<Node> vertices=new ArrayList<>();
    public Graph(int v){
        for(int i=0;i<v;i++)
            vertices.add(new Node(i));
    }//end of constructor
    public void addEdge(int s,int d){
        vertices.get(s).addEdge(d);
    }//end of addEdge
    public void removeEdge(int e,int from,char c){
        if(from>=0 && from<vertices.size()){
        vertices.get(from).removeEdge(e);
        if(c=='O')
        vertices.get(from).name='O';
        }//end if
    }//end of removeEdge
    
}//end of Graph class