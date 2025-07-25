package BINARY_TREE.LEVEL_ORDER_TRAVERSAL.AAA_BT_Level_Order_Traversal;

import BINARY_TREE.LEVEL_ORDER_TRAVERSAL.TreeNode;

import java.util.*;

/**
 * Question link: https://leetcode.com/problems/binary-tree-level-order-traversal/
 * Date: 25-07-2025
 * Time complexity:
 * Space complexity:
 */

public class Solution1 {
    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            int len = queue.size();
            List<Integer> li = new ArrayList<>();

            for(int i=0 ; i<len ; i++){
                TreeNode node = queue.remove();
                li.add(node.val);

                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
            }

            result.add(li);
        }

        return result;
    }

}