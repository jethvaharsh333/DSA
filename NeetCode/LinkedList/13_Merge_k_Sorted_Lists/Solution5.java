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
class Solution5 {
    public ListNode mergeKLists(ListNode[] lists) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;

        for (ListNode list : lists) {
            while (list != null) {
                int val = list.val;
                if (val > max) {
                    max = val;
                }
                if (val < min) {
                    min = val;
                }
                list = list.next;
            }
        }
        // bucket where each bucket corresponds to a specific value.
        /*
         * Each position in table acts as a bucket, storing nodes of the same value by
         * chaining them together using the next pointers
         */
        ListNode[] table = new ListNode[max - min + 1];
        for (int i = lists.length - 1; i >= 0; i--) {
            ListNode node = lists[i], temp;
            while (node != null) {
                temp = node.next;
                node.next = table[node.val - min];
                table[node.val - min] = node;
                node = temp;
            }
        }
        
        ListNode result = new ListNode();
        ListNode pointer = result;
        for (ListNode node : table) {
            if (node != null) {
                pointer.next = node;
                pointer = pointer.next;
                while (node.next != null)
                    node = node.next;
                pointer = node;
            }
        }
        return result.next;
    }
}
