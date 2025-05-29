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
    private boolean check = false;

    public boolean hasPathSum(TreeNode root, int targetSum) {
        path(root, targetSum, 0);
        return check;
    }

    private void path(TreeNode root, int targetSum, int height) {
        if(root == null){
            return;
        }

        height += root.val;

        if(root.left == null && root.right == null && targetSum == height){
            check = true;
            return;
        }

        path(root.left, targetSum, height);
        path(root.right, targetSum, height);
    }
}
