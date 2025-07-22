package BINARY_TREE.PROPERTIES.AAF_Minimum_Depth_of_Binary_Tree;

import BINARY_TREE.PROPERTIES.TreeNode;

/**
 * Question link: https://leetcode.com/problems/minimum-depth-of-binary-tree
 * Date: 21-07-2025
 * Time complexity:
 * Space complexity:
 */

public class Solution1 {
    public int minDepth(TreeNode root) {
        if(root == null) return 0;

        int leftHeight = minDepth(root.left);
        int rightHeight = minDepth(root.right);

        if(leftHeight == 0 || rightHeight==0){
            return 1 + leftHeight + rightHeight;
        }

        return 1 + Math.min(leftHeight, rightHeight);
    }
}
