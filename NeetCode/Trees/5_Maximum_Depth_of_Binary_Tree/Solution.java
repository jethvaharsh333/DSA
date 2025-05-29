// Time complexity: O(n); Space complexity: O(h) [h = height of small tree]
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
    public int maxDepth(TreeNode root) {
        return count(root);
    }

    private int count(TreeNode root){
        if(root == null){
            return 0;
        }

        int leftTree = count(root.left);
        int rightTree = count(root.right);

        return Math.max(leftTree, rightTree) + 1;
    }
}
