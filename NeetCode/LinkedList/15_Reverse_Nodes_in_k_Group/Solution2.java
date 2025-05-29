// Time complexity: O(n), Space complexity: O(1)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution2 {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = head;
        ListNode prevNode = null;

        while(temp != null){
            ListNode kthNode = getKthNode(temp, k);

            if (kthNode == null) {          // Group is not full
                if (prevNode != null) {
                    prevNode.next = temp;
                }
                break;
            }

            ListNode nextNode = kthNode.next;
            kthNode.next = null;

            reverse(temp);

            if(temp == head){
                head = kthNode;  // for 1st iteration
            } 
            else{
                prevNode.next = kthNode;
            }

            prevNode = temp;
            temp = nextNode;
        }
        return head;
    }

    public ListNode getKthNode(ListNode temp, int k) {
        k = k-1;
        while(temp!=null && k>0){
            temp = temp.next;
            k--;
        }
        
        return temp;
    }

    public ListNode reverse(ListNode head) {
        ListNode temp = head;
        ListNode prev = null;
        ListNode forward = null;

        while(temp != null){
            forward = temp.next;
            temp.next = prev;
            prev = temp;
            temp = forward;
        }

        return prev;
    }
}
