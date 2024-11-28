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
class Solution2 {
    private int count = 0;

    public int goodNodes(TreeNode root) {
        nodesc(root, root.val);
        return count; 
    }

    private void nodesc(TreeNode root, int maxCount) {
        if(root != null){
            if(root.val >= maxCount){
                count++;
            }
            nodesc(root.left, Math.max(root.val, maxCount));
            nodesc(root.right, Math.max(root.val, maxCount));
        }
    }
}
