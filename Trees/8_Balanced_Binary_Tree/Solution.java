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
    public boolean isBalanced(TreeNode root) {
        return height(root) == -1 ? false : true;
    }

    private int height(TreeNode root){
        if(root == null){
            return 0;
        }

        int leftHeight = height(root.left);
        if(leftHeight==-1){
            return -1;
        }

        int rightHeight = height(root.right);
        if(rightHeight==-1){
            return -1;
        }

        int diff = leftHeight-rightHeight;
        
        if(Math.abs(diff) > 1){
            return -1;
        }

        return Math.max(leftHeight, rightHeight) + 1;
    }
}
