// Time complexity: O(n), Space complexity: O(1), OPTIMAL SOLUTION
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
class Solution1 {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k <= 1) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prevGroupTail = dummy;
        ListNode curr = head;

        while (true) {
            ListNode tail = curr;
            int count = 1;

            while (tail != null && count < k) {
                tail = tail.next;
                count++;
            }

            if (tail == null) break;

            ListNode prev = null;
            ListNode next = null;
            ListNode temp = curr;

            for (int i = 0; i < k; i++) {
                next = temp.next;
                temp.next = prev;
                prev = temp;
                temp = next;
            }

            prevGroupTail.next = prev;
            curr.next = next;

            prevGroupTail = curr;
            curr = next;
        }

        return dummy.next;
    }
}
