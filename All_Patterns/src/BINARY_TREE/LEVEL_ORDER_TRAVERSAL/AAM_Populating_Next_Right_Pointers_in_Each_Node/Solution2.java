package BINARY_TREE.LEVEL_ORDER_TRAVERSAL.AAM_Populating_Next_Right_Pointers_in_Each_Node;

import java.util.*;

/**
 * Question link:
 * Date: 06-08-2025
 * Time complexity:
 * Space complexity:
 */

public class Solution2 {
    public Node connect(Node root) {
        if(root == null) return null;

        Node leftmost = root;

        while(leftmost.left != null){
            Node current=leftmost;

            while(current != null){
                current.left.next=current.right;
                if(current.next != null){
                    current.right.next=current.next.left;
                }
                current=current.next;
            }

            leftmost=leftmost.left;
        }

        return root;
    }
}
