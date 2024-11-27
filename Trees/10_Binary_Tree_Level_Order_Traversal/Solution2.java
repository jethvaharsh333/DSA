// Time complexity: O(n); Space complexity: O(h) [h = height of tree] [Efficient Solution]
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        traverse(result, root, 0);
        return result;
    }

    private void traverse(List<List<Integer>> result, TreeNode node, int level) {
        if(node == null){
            return;
        }

        if(result.size() <= level){
            result.add(new ArrayList<>());
        }

        result.get(level).add(node.val);

        traverse(result, node.left, level+1);
        traverse(result, node.right, level+1);
    }
}
