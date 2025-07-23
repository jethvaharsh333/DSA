package BINARY_TREE.TWO_TREE_VALIDATION.AAC_Merge_Two_BT;

import BINARY_TREE.TWO_TREE_VALIDATION.TreeNode;

import java.util.*;

/**
 * Question link: https://leetcode.com/problems/merge-two-binary-trees/description/
 * Date: 23-07-2025
 * Time complexity:
 * Space complexity:
 */

public class Solution {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if(root1==null && root2==null) return null;
        if(root1==null) return root2;
        if(root2==null) return root1;

        TreeNode result = new TreeNode(root1.val + root2.val);
        result.left = mergeTrees(root1.left, root2.left);
        result.right = mergeTrees(root1.right, root2.right);

        return result;
    }
}