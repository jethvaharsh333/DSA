package BINARY_TREE.PROPERTIES.AAC_Maximum_Depth_Binary_Tree;

import BINARY_TREE.PROPERTIES.TreeNode;

import java.util.*;

/**
 * Question link:
 * Date: 21-07-2025
 * Time complexity:
 * Space complexity:
 */

public class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;

        int leftHeight = maxDepth(root.left);
        int rightHeight = maxDepth(root.right);

        return 1 + Math.max(leftHeight, rightHeight);
    }
}