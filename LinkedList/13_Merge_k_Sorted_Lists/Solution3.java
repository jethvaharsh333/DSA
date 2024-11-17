// Time Complexity: O(Nlogk); Space Complexity: O(k+N) [N = total number of nodes across all lists, k = number of linked lists]
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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> queue = new PriorityQueue<>((a,b) -> a.val - b.val);
        for(ListNode list : lists){
            if(list != null){
                queue.add(list);
            }
        }
        
        ListNode node = new ListNode();
        ListNode l = node;

        while(!queue.isEmpty()){
            ListNode temp = queue.poll();   //poll(): Retrieves and removes the head of this queue, or returns null if this queue is empty.
            // PriorityQueue (min-heap) stores the elements in ascending order based on their values, not in the order they were added.
            // So polled element will always be lowest or equal value comparing other elements in priority queue
            l.next = new ListNode(temp.val);
            l = l.next;
            if(temp.next != null){      // we can find next node as first only removed from queue but still linked with next node in ll
                queue.add(temp.next);
            }
        }

        return node.next;
    }
}
