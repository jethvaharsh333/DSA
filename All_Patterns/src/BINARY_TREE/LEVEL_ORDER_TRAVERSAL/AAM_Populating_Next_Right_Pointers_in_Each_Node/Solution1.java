package BINARY_TREE.LEVEL_ORDER_TRAVERSAL.AAM_Populating_Next_Right_Pointers_in_Each_Node;

import java.util.*;

/**
 * Question link: https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
 * Date: 06-08-2025
 * Time complexity:
 * Space complexity:
 */

public class Solution1 {
    public Node connect(Node root) {
        if(root == null) return root;

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            int len = queue.size();

            for(int i=0 ; i<len ; i++){
                Node node = queue.remove();

                if(i<len-1){
                    node.next = queue.peek();
                }

                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
        }

        return root;
    }
}


class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};