package BINARY_TREE.LEVEL_ORDER_TRAVERSAL.AAF_BT_Right_Side_View;

import BINARY_TREE.LEVEL_ORDER_TRAVERSAL.TreeNode;

import java.util.*;

/**
 * Question link: https://leetcode.com/problems/binary-tree-right-side-view
 * Date: 26-07-2025
 * Time complexity:
 * Space complexity:
 */

public class Solution1 {
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null) return new ArrayList<>();

        List<Integer> result = new ArrayList<Integer>();

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);

        while(!queue.isEmpty()){
            int len = queue.size();

            for(int i=0 ; i<len ; i++){
                TreeNode node = queue.remove();

                if(i == len-1) result.add(node.val);

                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
            }
        }

        return result;
    }
}