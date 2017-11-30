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
	    Collections.sort(al,new Comparator<Integer>(){
	        public int compare(Integer i1,Integer i2){
	            String s1=Integer.toString(i1);
	            int l1=s1.length();
	            String s2=Integer.toString(i2);
	            int l2=s2.length();
	            String s3="";
	            int j=0;
	            if(l1==l2)
	                return i2-i1;
	            else{
	                if(l1<l2){
	                  for(int i=0;i<l2;i++){
	                   int result= Integer.parseInt(s2.substring(i,i+1))-
	                        Integer.parseInt((s1.substring(j,j+1)));
	                        if(result!=0)
	                            return result;
	                        if(j<l1-1)  
	                            j++;
	                        else
	                            j=0;
	                    }//end of for i
	                    return Integer.parseInt(s2.substring(l1,l1+1))-
	                    Integer.parseInt(s2.substring(l1-1,l1));
	                }else if (l1>l2){
	                  for(int i=0;i<l1;i++){
	                   int result= Integer.parseInt(s2.substring(j,j+1))-
	                        Integer.parseInt((s1.substring(i,i+1)));
	                        if(result!=0)
	                            return result;
	                        if(j<l2-1)  
	                            j++;
	                        else
	                            j=0;
	                    }//end of for i
	                    //System.out.println("reached");
	                    return Integer.parseInt(s1.substring(l2-1,l2))-
	                    Integer.parseInt(s1.substring(l2,l2+1));
	                }
	                return i1-i2;
	                }//end of else
	        }//end of compare
	    });
	    for(Integer x:al)
	    System.out.print(x);
	}//end of solve
}//end