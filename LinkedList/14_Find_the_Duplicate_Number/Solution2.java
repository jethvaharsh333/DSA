class ListNode {
    int val;        // Value of the node
    ListNode next;  // Pointer to the next node

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

// Time Complexity: O(n), Space Complexity: O(1)
class Solution2 {
    public int findDuplicate(int[] nums) {
        ListNode[] nodes = new ListNode[nums.length];
        for (int i = 0; i < nums.length; i++) {
            nodes[i] = new ListNode(i);
        }

        for (int i = 0; i < nums.length; i++) {
            nodes[i].next = nodes[nums[i]];
        }

        ListNode slow = nodes[0];
        ListNode fast = nodes[0];

        do {
            slow = slow.next;         
            fast = fast.next.next;    
        } while (slow != fast);

        slow = nodes[0];
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow.val;
    }
}
