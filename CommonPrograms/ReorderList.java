package com.farzam.java;


import java.util.Scanner;

class Node{
	
    public int data;
    public Node next;
    
    Node(int d){
    	data = d; 
    	next = null;
    }
    public String toString() {
    	return ""+this.data+" ";
    }
}

	
public class ReorderList{
	static Node head;
	static Node current;
	public static void main(String[] args) {
		ReorderList rl=new ReorderList();
		System.out.print("Enter number of elements in Linked List: ");
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		System.out.print("Enter Nodes: ");
		for(int i=0;i<n;i++) {
			if(head==null) {
				head=new Node(sc.nextInt());
				current=head;
			}else {
				current.next=new Node(sc.nextInt());
				current=current.next;
			}
		}
		System.out.print("The reversed List: ");
		while(head!=null) {
		System.out.print(rl.reorderlist(head));
		head=head.next;
		}
	}//main
	
   public Node reorderlist(Node head){
        Node slow=head;
        Node fast=slow.next;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }//end of while
        Node node1=head;
        Node node2=slow.next;
        slow.next=null;
        node2=reverse(node2);
        Node node=new Node(0);
        Node curr=node;
        while(node1!=null || node2!=null){
            if(node1!=null){
            curr.next=node1;
            curr=curr.next;
            node1=node1.next;
            }//end of if
            if(node2!=null){
                curr.next=node2;
                curr=curr.next;
                node2=node2.next;
            }//end if
        }//end of while
        node=node.next;
		return node;
    }//end of reorder
    
   public Node reverse(Node node2){
        Node curr=node2;
        Node prev=null;
        Node next;
        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }//end of while
        return prev;
    }//end of reverse
    
}//end


