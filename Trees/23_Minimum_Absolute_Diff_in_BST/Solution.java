// Time Complexity: O(n), Space Complexity: O(h) (h = height of the tree)
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
    private int prev = Integer.MAX_VALUE;
    private int ans = Integer.MAX_VALUE;

    public int getMinimumDifference(TreeNode root) {
        inOrderTrav(root);
        return ans;
    }

    private void inOrderTrav(TreeNode root){
        if(root.left != null) inOrderTrav(root.left);

        ans = Math.min(ans, Math.abs(root.val-prev));
        prev = root.val;

        if(root.right != null) inOrderTrav(root.right);
    }
}
