// https://leetcode.com/problems/reverse-linked-list/
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
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode curr = head;
        ListNode temp1 = head.next;
        ListNode temp2 = temp1.next;

        head.next = null;
        
        while (temp1 != null) {
            temp1.next = curr;  
            curr = temp1;  
            temp1 = temp2; 
            if (temp2 != null) {
                temp2 = temp2.next;
            }
        }
        
        return curr;
    }
}