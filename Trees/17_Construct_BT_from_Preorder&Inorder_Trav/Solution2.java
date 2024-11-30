// Time complexity: O(n); Space complexity: O(n)
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
    private int in = 0;
    private int pre = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return tree(preorder, inorder, Integer.MIN_VALUE);
    }

    private TreeNode tree(int[] preorder, int[] inorder, int stop){
        if(pre >= preorder.length){
            return null;
        }

        if(inorder[in] == stop){
            ++in;
            return null;
        }

        TreeNode node = new TreeNode(preorder[pre++]);
        node.left = tree(preorder, inorder, node.val);
        node.right = tree(preorder, inorder, stop);
        return node;
    } 
}
