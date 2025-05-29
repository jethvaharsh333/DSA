// Time Complexity: O(n+m), Space Complexity: O(1)
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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null) return list2;
        else if(list2 == null) return list1;

        ListNode ll = new ListNode();
        ListNode head = ll;

        ListNode curr1 = list1;
        ListNode curr2 = list2;

        while(curr1!=null && curr2!=null){
            if(curr1.val <= curr2.val){
                head.next = curr1;
                curr1 = curr1.next;
            }
            else{
                head.next = curr2;
                curr2 = curr2.next;
            }

            head = head.next;
        }

        if(curr1 != null){
            head.next = curr1;
        }
        else{
            head.next = curr2;
        }

        return ll.next;
    }
}
