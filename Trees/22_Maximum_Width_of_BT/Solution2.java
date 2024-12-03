// Time Complexity: O(n), Space Complexity: O(h) [h = height of the tree]
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
    public int widthOfBinaryTree(TreeNode root) {
        return dfs(root, new ArrayList<>(), 0, 0);
    }

    public int dfs(TreeNode root, ArrayList<Integer> li, int level, int n) {
        if(root == null) return 0;

        int max = 1;

        if(level >= li.size())
            li.add(n);
        else
            max = Math.max(max, n-li.get(level)+1);

        int left = dfs(root.left, li, level+1, 2*n);
        int right = dfs(root.right, li, level+1, 2*n+1);

        return Math.max(max, Math.max(left, right));
    }
}
