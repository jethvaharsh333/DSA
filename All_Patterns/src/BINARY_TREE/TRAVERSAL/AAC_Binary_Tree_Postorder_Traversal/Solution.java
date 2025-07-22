package BINARY_TREE.TRAVERSAL.AAC_Binary_Tree_Postorder_Traversal;

import java.util.*;

/**
 * Question link: https://leetcode.com/problems/binary-tree-postorder-traversal/
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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<Integer>();

        if(root == null) return ans;
        ans.addAll(postorderTraversal(root.left));
        ans.addAll(postorderTraversal(root.right));
        ans.add(root.val);

        return ans;
    }
}