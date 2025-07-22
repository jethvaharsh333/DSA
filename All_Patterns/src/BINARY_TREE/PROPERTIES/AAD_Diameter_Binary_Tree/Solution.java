package BINARY_TREE.PROPERTIES.AAD_Diameter_Binary_Tree;

import BINARY_TREE.PROPERTIES.TreeNode;

import java.util.*;

/**
 * Question link:
 * Date: 22-07-2025
 * Time complexity:
 * Space complexity:
 */

public class Solution {
    int maxHeight;

    public int diameterOfBinaryTree(TreeNode root) {
        maxHeight = 0;
        maxDepth(root);
        return maxHeight;
    }

    public int maxDepth(TreeNode root){
        if(root == null) return 0;

        int leftHeight = maxDepth(root.left);
        int rightHeight = maxDepth(root.right);

        maxHeight = Math.max(maxHeight, leftHeight + rightHeight);

        return 1 + Math.max(leftHeight, rightHeight);
    }
}