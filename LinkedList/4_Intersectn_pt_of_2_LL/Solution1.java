// 3ms [brute-force]
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution1 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;

        ListNode l1 = headA;
        ListNode l2 = headB;
        
        Stack<ListNode> s1 = new Stack<>();
        while(l1 != null){
            s1.push(l1);
            l1 = l1.next;
        }

        Stack<ListNode> s2 = new Stack<>();
        while(l2 != null){
            s2.push(l2);
            l2 = l2.next;
        }
        
        ListNode ans = null;
        while(!s1.isEmpty() && !s2.isEmpty()){
            ListNode n1 = s1.pop();
            ListNode n2 = s2.pop();

            if(n1 == n2){
                ans = n1;
            }
            else{
                break;
            }
        }       
        return ans;
    }
}
