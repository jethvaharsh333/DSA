// Time Complexity: O(n), Space Complexity: O(n)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution2 {
    public void reorderList(ListNode head) {
        newOrderList(head, head);
    }

    public ListNode newOrderList(ListNode head, ListNode fast){
          if(fast.next==null){   // Odd no of node
            ListNode tail = head.next;
            head.next = null;
            return tail;
          }
          else if(fast.next.next==null){ // even no of node
            ListNode tail = head.next.next;
            head.next.next = null;
            return tail; 
          }
        ListNode node =  newOrderList(head.next, fast.next.next);
           ListNode  reverseNode = node.next;

           node.next = head.next;
           head.next = node;
           
           return reverseNode;
    }
}
