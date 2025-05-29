// Time Complexity: O(NlogN); Space Complexity: O(N) [N = total number of nodes across all lists]
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
    public ListNode mergeKLists(ListNode[] lists) {
        List<Integer> allNodes = new ArrayList<>();

        for (ListNode node : lists) {
            while (node != null) {
                allNodes.add(node.val);
                node = node.next;
            }
        }

        Collections.sort(allNodes);

        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        for (int val : allNodes) {
            current.next = new ListNode(val);
            current = current.next;
        }

        return dummy.next;
    }
}
