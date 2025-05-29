// Time complexity: O(n); Space complexity: O(h) [h = stack size]
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
    private int diameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        depthTree(root);
        return diameter;
    }

    public int depthTree(TreeNode root) {
        if(root == null) return 0;

        int depthLeft = depthTree(root.left);
        int depthRight = depthTree(root.right);

        diameter = Math.max(depthLeft+depthRight, diameter);

        return Math.max(depthLeft,depthRight)+1;
    }
}
