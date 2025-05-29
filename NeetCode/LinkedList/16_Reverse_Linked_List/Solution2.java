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
// Time complexity: O(n), Space complexity: O(1)
class Solution2 {
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        
        ListNode prev = null;

        while (head != null) {
            ListNode nextPtr = head.next; 
            head.next = prev;
            prev = head;
            head = nextPtr;
        }

        return prev;
    }
}
