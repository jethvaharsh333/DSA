package BINARY_TREE.TWO_TREE_VALIDATION.AAA_Same_Tree;

import BINARY_TREE.TWO_TREE_VALIDATION.TreeNode;

import java.util.*;

/**
 * Question link: https://leetcode.com/problems/same-tree/
 * Date: 23-07-2025
 * Time complexity:
 * Space complexity:
 */

public class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null && q==null){
            return true;
        }

        if(p!=null && q!=null && p.val==q.val){
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }

        return false;
    }
}