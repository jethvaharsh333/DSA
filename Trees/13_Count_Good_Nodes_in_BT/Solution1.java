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
class Solution1 {
    public int goodNodes(TreeNode root) {
        return nodesc(root, Integer.MIN_VALUE);
    }

    private int nodesc(TreeNode root, int count) {
        if(root == null){
            return 0;
        }

        int goodNodeCount = (root.val >= count) ? 1 : 0;
        count = Math.max(count, root.val);
        
        return goodNodeCount + nodesc(root.left, count) + nodesc(root.right, count);
    }
}
