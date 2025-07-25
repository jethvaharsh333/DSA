package BINARY_TREE.PROPERTIES.AAF_Minimum_Depth_of_Binary_Tree;

import BINARY_TREE.PROPERTIES.TreeNode;

import java.util.*;

/**
 * Question link: https://leetcode.com/problems/minimum-depth-of-binary-tree/
 * Date: 21-07-2025
 * Time complexity:
 * Space complexity:
 */

public class Solution2 {
    public int minDepth(TreeNode root) {
        if(root == null) return 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int depth = 1;

        while(!queue.isEmpty()){
            int size = queue.size();

            for(int i=0 ; i<size ; i++){
                TreeNode node = queue.poll();

                if(node.left==null && node.right==null){
                    return depth;
                }

                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }

            depth++;
        }

        return depth;
    }

}