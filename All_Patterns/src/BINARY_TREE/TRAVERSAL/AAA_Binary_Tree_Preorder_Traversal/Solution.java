package BINARY_TREE.TRAVERSAL.AAA_Binary_Tree_Preorder_Traversal;

import java.util.*;

/**
 * Question link: https://leetcode.com/problems/binary-tree-preorder-traversal/
 * Date: 21-07-2025
 * Time complexity:
 * Space complexity:
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> trav = new ArrayList<>();

        if(root == null){
            return trav;
        }

        trav.add(root.val);
        trav.addAll(preorderTraversal(root.left));
        trav.addAll(preorderTraversal(root.right));

        return trav;
    }
}