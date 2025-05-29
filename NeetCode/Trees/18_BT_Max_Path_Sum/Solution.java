// Time complexity: O(n); Space complexity: O(h) [h = height of tree]
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
    private int maxPathSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        if(root == null) return 0;

        maxPathSum = Integer.MIN_VALUE;
        findMaxPath(root);

        return maxPathSum;
    }

    private int findMaxPath(TreeNode root) {
        if(root == null) return 0;

        int leftSum = Math.max(0, findMaxPath(root.left));
        int rightSum = Math.max(0, findMaxPath(root.right));

        maxPathSum = Math.max(maxPathSum, leftSum+rightSum+root.val);

        return root.val + Math.max(leftSum, rightSum);
    }
}
