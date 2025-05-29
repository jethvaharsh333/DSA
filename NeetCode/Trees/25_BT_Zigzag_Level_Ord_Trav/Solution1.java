// Time Complexity: O(n), Space Complexity: O(n)
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        boolean leftToRight = true;

        while(!queue.isEmpty()){
            List<Integer> currentLevel = new ArrayList<>();
            int currentLevelSize = queue.size();

            for(int i=0 ; i<currentLevelSize ; i++){
                TreeNode node = queue.poll();
                
                if(leftToRight){
                    currentLevel.add(node.val);
                }else{
                    currentLevel.add(0, node.val);
                }

                if(node.left != null){
                    queue.add(node.left);
                }

                if(node.right != null){
                    queue.add(node.right);
                }
            }

            leftToRight = !leftToRight;
            result.add(currentLevel);
        }

        return result;
    }
}
