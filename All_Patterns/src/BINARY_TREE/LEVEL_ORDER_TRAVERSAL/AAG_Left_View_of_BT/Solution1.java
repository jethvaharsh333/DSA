package BINARY_TREE.LEVEL_ORDER_TRAVERSAL.AAG_Left_View_of_BT;

import java.util.*;

/**
 * Question link: https://www.geeksforgeeks.org/problems/left-view-of-binary-tree/1
 * Date: 05-08-2025
 * Time complexity:
 * Space complexity:
 */

public class Solution1 {
    ArrayList<Integer> leftView(Node root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if(root == null) return result;

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            result.add(queue.peek().data);
            int len = queue.size();

            for(int i=0 ; i<len ; i++){
                Node node = queue.poll();
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
        }

        return result;
    }
}

class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}