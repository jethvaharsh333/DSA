// Time complexity: O(n^2), Space complexity: O(h) [h = tree height]
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
    public int pathSum(TreeNode root, int targetSum) {
        if(root == null){
            return 0;
        }

        int count = oneNodePathSum(root, targetSum);

        count += pathSum(root.left, targetSum);
        return count + pathSum(root.right, targetSum);
    }

    public int oneNodePathSum(TreeNode root, long targetSum){
        if(root==null){
            return 0;
        }
        
        int count = 0;
        if(root.val == targetSum){
            count++;
        }

        return count + oneNodePathSum(root.left, targetSum-root.val) 
                     + oneNodePathSum(root.right, targetSum-root.val);
    }
}
