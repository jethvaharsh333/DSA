import java.util.*;

class Node {
        int num;
        Node next;
        Node(int val) {
            num = val;
            next = null;
        }
}


class TUF{
    static Node insertNode(Node head,int val) {
    Node newNode = new Node(val);
    
    if(head == null) {
        head = newNode;
        return head;
    }
    
    Node temp = head;
    while(temp.next != null) temp = temp.next;
    
    temp.next = newNode;
    return head;
}

    static Node intersectionPresent(Node head1,Node head2) {
        Node l1 = head1;
        Node l2 = head2;
        
        Stack<Node> s1 = new Stack<>();
        while(l1.next != null){
            
            s1.push(l1);
            l1 = l1.next;
        }

        Stack<Node> s2 = new Stack<>();
        while(l2.next != null){
            
            s2.push(l2);
            l2 = l2.next;
        }

        
        
        Node ans = null;
        while(!s1.isEmpty() && !s2.isEmpty()){
            Node n1 = s1.pop();
            Node n2 = s2.pop();

            if(n1 == n2){
                ans = n1;
            }
            else{
                break;
            }
        }
        
        return ans;
    }

    //utility function to print linked list created
    static void printList(Node head) {
        while(head.next != null) {
        System.out.print(head.num+"->");
            head = head.next;
        }
        System.out.println(head.num);
    }

    public static void main(String args[]) {
        // creation of both lists 
        Node head = null;
        head=insertNode(head,1);
        head=insertNode(head,3);
        head=insertNode(head,1);
        head=insertNode(head,2);
        head=insertNode(head,4);
        Node head1 = head;
        head = head.next.next.next;
        Node headSec = null;
        headSec=insertNode(headSec,3);
        Node head2 = headSec;
        headSec.next = head;
        //printing of the lists
        System.out.print("List1: "); printList(head1);
        System.out.print("List2: "); printList(head2);
        //checking if intersection is present
        Node answerNode = intersectionPresent(head1,head2);
        if(answerNode == null)  
        System.out.println("No intersection\n");
        else
        System.out.println("The intersection point is "+answerNode.num);
        
    }
}