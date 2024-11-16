// Time Complexity: O(n), Space Complexity: O(n) [OPTIMAL SOLUTION]
/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) return null;

        HashMap<Node, Node> addr = new HashMap<>();

        Node curr = head;
        while(curr != null){
            addr.put(curr, new Node(curr.val));
            curr = curr.next;
        }

        curr = head;
        while(curr != null){
            Node temp = addr.get(curr);
            temp.next = addr.get(curr.next);
            temp.random = addr.get(curr.random);
            curr = curr.next;
        }

        return addr.get(head);
    }
}
