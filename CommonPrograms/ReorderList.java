/* Following is the Linked list node structure */
/*class Node
{
    int data;
    Node next;
    Node(int d) {data = d; next = null; }
}*/
	
class gfg
{
    Node reorderlist(Node head)
    {
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
    
    Node reverse(Node node2){
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
