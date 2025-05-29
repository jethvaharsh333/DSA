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

class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode half = head;
        ListNode full = head;

        while(full != null && full.next != null){
            half = half.next;
            full = full.next.next;
        }

        return half;
    }
}