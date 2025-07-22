package BINARY_TREE.PROPERTIES.AAB_Balanced_Binary_Tree;

import BINARY_TREE.PROPERTIES.TreeNode;

import java.util.*;

/**
 * Question link:
 * Date: 21-07-2025
 * Time complexity:
 * Space complexity:
 */

public class Solution {
    public boolean isBalanced(TreeNode root) {
        return height(root)==-1 ? false : true;
    }

    private int height(TreeNode root){
        if(root == null){
            return 0;
        }

        int leftHeight = height(root.left);
        if(leftHeight == -1) return -1;

        int rightHeight = height(root.right);
        if(rightHeight == -1) return -1;

        int diff = leftHeight - rightHeight;
        if(Math.abs(diff) > 1){
            return -1;
        }

        return 1 + Math.max(leftHeight, rightHeight);
    }
}