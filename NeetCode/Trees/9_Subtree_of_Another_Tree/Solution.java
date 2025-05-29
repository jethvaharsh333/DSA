// Time complexity: O(n*m); Space complexity: O(max(h1,h2)) [h = stack size]
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null  && subRoot == null ) return true;
        if(root == null || subRoot == null) return false;

        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot) || helper(root, subRoot);
    }

    private boolean helper(TreeNode root, TreeNode subRoot){
        if(root == null  && subRoot == null ) return true;
        if(root == null || subRoot == null ) return false;
        if(root.val != subRoot.val) return false;
        return helper(root.left, subRoot.left) && helper(root.right, subRoot.right);
    }
}
