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
class Solution1 {
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        
        ListNode curr = head;
        ListNode prev = null;

        while(curr!=null){
            ListNode nextPtr = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextPtr;
        }
        
        return prev;
    }
}
