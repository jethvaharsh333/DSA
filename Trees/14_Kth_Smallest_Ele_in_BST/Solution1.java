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
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> li = adder(root);
        return li.get(k-1);
    }

    private List<Integer> adder(TreeNode root){
        if(root == null){
            return new ArrayList<>();
        }

        List<Integer> re = new ArrayList<>();
        re.addAll(adder(root.left));
        re.add(root.val);
        re.addAll(adder(root.right));

        return re;
    } 
}
