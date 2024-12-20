// Time complexity: O(n), Space complexity: O(h) [h = tree height]
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
    TreeNode firstElement = null;
    TreeNode secondElement = null;
    TreeNode prevElement = null;
    
    public void recoverTree(TreeNode root) {
        traverse(root);

        int temp = firstElement.val;
        firstElement.val = secondElement.val;
        secondElement.val = temp;
    }

    private void traverse(TreeNode root) {
        if(root == null) return;
            
        traverse(root.left);

        if(firstElement==null && prevElement!=null && prevElement.val>=root.val){
            firstElement = prevElement;
        }
        if(firstElement!=null && prevElement!=null && prevElement.val>=root.val){
            secondElement = root;
        }        
        prevElement = root;

        traverse(root.right);
    }
}
