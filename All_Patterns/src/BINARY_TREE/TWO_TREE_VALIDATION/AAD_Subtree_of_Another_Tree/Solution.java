package BINARY_TREE.TWO_TREE_VALIDATION.AAD_Subtree_of_Another_Tree;

import BINARY_TREE.TWO_TREE_VALIDATION.TreeNode;

import java.util.*;

/**
 * Question link: https://leetcode.com/problems/subtree-of-another-tree/description/
 * Date: 23-07-2025
 * Time complexity:
 * Space complexity:
 */

public class Solution {
    public boolean isSubtree(TreeNode root, TreeNode subRoot){
        if(root==null && subRoot==null) return true;
        if(root==null || subRoot==null) return false;

        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot) || check(root, subRoot);
    }

    private boolean check(TreeNode root1, TreeNode root2){
        if(root1==null && root2==null) return true;

        if(root1!=null && root2!=null && root1.val==root2.val){
            return check(root1.left, root2.left) && check(root1.right, root2.right);
        }

        return false;
    }
}