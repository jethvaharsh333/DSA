// Time Complexity: O(Nlogk); Space Complexity: O(logk) [OPTIMAL SOLUTION] [N = total number of nodes across all lists, k = number of linked lists]
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
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        return mergeLists(lists, 0, lists.length - 1);
    }

    private ListNode mergeLists(ListNode[] lists, int left, int right) {
        if (left == right) {
            return lists[left];
        }

        int mid = left + (right - left) / 2;
        ListNode leftMerged = mergeLists(lists, left, mid);
        ListNode rightMerged = mergeLists(lists, mid + 1, right);

        return mergeTwoLists(leftMerged, rightMerged);
    }

    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }

        if (l1 != null) {
            current.next = l1;
        }
        if (l2 != null) {
            current.next = l2;
        }

        return dummy.next;
    }
}
