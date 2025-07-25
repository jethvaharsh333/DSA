package BINARY_TREE.LEVEL_ORDER_TRAVERSAL.AAC_Cousins_in_BT;

import BINARY_TREE.LEVEL_ORDER_TRAVERSAL.TreeNode;

import java.util.*;

/**
 * Question link: https://leetcode.com/problems/cousins-in-binary-tree
 * Date: 25-07-2025
 * Time complexity:
 * Space complexity:
 */

public class Solution1 {
    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        List<Integer> li = new ArrayList<>();

        while(!queue.isEmpty()){
            int len = queue.size();

            for(int i=0 ; i<len ; i++){
                TreeNode node = queue.remove();
                int value = node.val;

                TreeNode leftNode = node.left;
                if(leftNode != null){
                    queue.offer(leftNode);
                    if(leftNode.val==x || leftNode.val==y) li.add(value);
                }

                TreeNode rightNode = node.right;
                if(rightNode != null){
                    queue.offer(rightNode);
                    if(rightNode.val==x || rightNode.val==y) li.add(value);
                }
            }

            int size = li.size();
            if(size == 1){
                return false;
            }else if(size == 2){
                if(li.get(0) == li.get(1)) return false;
                return true;
            }
        }

        return false;
    }
}