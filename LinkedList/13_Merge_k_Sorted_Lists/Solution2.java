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
class Solution2 {
    public ListNode mergeKLists(ListNode[] lists) {
        List<ListNode> nodeList = new ArrayList<>();

        for(ListNode list : lists){
            while(list != null){
                nodeList.add(list);
                list = list.next;
            }
        }

        Collections.sort(nodeList, (a, b) -> a.val-b.val);

        if(nodeList.size() == 0){
            return null;
        }

        ListNode result = nodeList.get(0);

        for(int i = 0; i < nodeList.size()-1; i++){
            nodeList.get(i).next = nodeList.get(i+1);
        }

        return result;

    }
}
