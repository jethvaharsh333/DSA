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
class Solution1 {
    private int preorderIndex = 0;
    private HashMap<Integer, Integer> inorderMap = new HashMap<>();
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i=0 ; i<inorder.length ; i++){
            inorderMap.put(inorder[i], i);
        }

        return tree(preorder, 0, inorder.length-1);
    }

    private TreeNode tree(int[] preorder, int left, int right){
        if(left > right){
            return null;
        }

        int rootVal = preorder[preorderIndex++];
        TreeNode root = new TreeNode(rootVal);

        int rootIndex = inorderMap.get(rootVal);

        root.left = tree(preorder, left, rootIndex-1);
        root.right = tree(preorder, rootIndex+1, right);

        return root;
    }
}
