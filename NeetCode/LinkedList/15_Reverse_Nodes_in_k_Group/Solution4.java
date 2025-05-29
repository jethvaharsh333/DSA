// Time complexity: O(n), Space complexity: O(1)
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
class Solution4 {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k <= 1) {
            return head;
        }
        ListNode current = head;
        int length = 0;
        while (current != null) {
            length++;
            current = current.next;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prevGroupEnd = dummy;

        current = head;
        while (length >= k) {
            ListNode groupStart = current;
            ListNode prev = null;

            for (int i = 0; i < k; i++) {
                ListNode next = current.next;
                current.next = prev;
                prev = current;
                current = next;
            }
            prevGroupEnd.next = prev; 
            groupStart.next = current; 
            prevGroupEnd = groupStart;
            length -= k;
        }
        return dummy.next;
    }
}
