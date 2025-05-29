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
class Solution3 {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode result = null;
        ListNode kTail = null;
        ListNode currentNode = head;

        while (currentNode != null) {
            int count = 0;
            currentNode = head;
            while (count < k && currentNode != null) {
                currentNode = currentNode.next;
                count++;
            }

            if (count == k) {
                ListNode reversedHead = reverseBlock(head, k);
                if (result == null) {
                    result = reversedHead;
                }
                if (kTail != null) {
                    kTail.next = reversedHead;
                }

                kTail = head;
                head = currentNode;
            }
        }
        if (kTail != null) {
            kTail.next = head;
        }
        return result == null ? head : result;
    }

    private ListNode reverseBlock(ListNode start, int k) {
        ListNode prevNode = null;
        ListNode currentNode = start;

        while (k-- > 0) {
            ListNode temp = currentNode.next;
            currentNode.next = prevNode;
            prevNode = currentNode;
            currentNode = temp;
        }
        return prevNode;   
    }
}
