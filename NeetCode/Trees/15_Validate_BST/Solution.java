// Time complexity: O(n); Space complexity: O(h) [h = height of the tree]
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
    public boolean isValidBST(TreeNode root) {
        return checkValid(root, null, null);
    }

    private boolean checkValid(TreeNode node, Integer lower, Integer upper) {
        if(node == null){
            return true;
        }

        if((lower!=null && node.val<=lower) || (upper!=null && node.val>=upper)){
            return false;
        }

        return checkValid(node.left, lower, node.val) && checkValid(node.right, node.val, upper);
    }
}
