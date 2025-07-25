package BINARY_TREE.LEVEL_ORDER_TRAVERSAL.AAB_BT_Level_Order_Traversal_II;

import BINARY_TREE.LEVEL_ORDER_TRAVERSAL.TreeNode;

import java.util.*;

/**
 * Question link: https://leetcode.com/problems/binary-tree-level-order-traversal-ii
 * Date: 25-07-2025
 * Time complexity:
 * Space complexity:
 */

public class Solution1 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
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

        reverse(result);
        // Collections.reverse(result);

        return result;
    }

    private void reverse(List<List<Integer>> result){
        int len = result.size();

        for(int i=0 ; i<len/2 ; i++){
            List<Integer> li = result.get(len-i-1);

            result.remove(len-i-1);
            result.add(len-i-1, result.get(i));

            result.remove(i);
            result.add(i, li);
        }

        /*

        int i=0, j = result.size()-1;

        while (i < j) {
            List<Integer> temp = result.get(i);
            result.set(i, result.get(j));
            result.set(j, temp);
            i++;
            j--;
        }

        */
    }
}