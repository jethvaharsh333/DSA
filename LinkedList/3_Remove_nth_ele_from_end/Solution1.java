// Not too optimized still "0 ms"

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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int count = 1;
        ListNode temp = head;

        while(temp.next != null){
            temp = temp.next;
            count++;
        }

        if (n == count) {
            return head.next;
        }

        temp = head;

        for(int comp=0 ; comp<(count-n-1) ; comp++){
            temp = temp.next;
        }
        
        if(temp.next!=null){
            temp.next = temp.next.next;
        }

        return head;

    }
}
