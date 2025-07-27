package BINARY_TREE.LEVEL_ORDER_TRAVERSAL.AAK_All_Nodes_Distance_K_in_BT;
import BINARY_TREE.LEVEL_ORDER_TRAVERSAL.TreeNode;
import java.util.*;

/**
 * Question link: https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/
 * Date: 27-07-2025
 * Time complexity:
 * Space complexity:
 */

public class Solution1 {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        buildParentMap(root, null, parentMap);

        List<Integer> result = new ArrayList<>();
        Set<TreeNode> visited = new HashSet<>();
        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(target);
        visited.add(target);

        while(!queue.isEmpty()){
            int size = queue.size();

            if(k == 0){
                for(int i=0 ; i<size ; i++){
                    result.add(queue.poll().val);
                }
                return result;
            }

            for(int i=0 ; i<size ; i++){
                TreeNode current = queue.poll();

                if(current.left != null && !visited.contains(current.left)){
                    visited.add(current.left);
                    queue.offer(current.left);
                }

                if(current.right != null && !visited.contains(current.right)){
                    visited.add(current.right);
                    queue.offer(current.right);
                }

                TreeNode parent = parentMap.get(current);
                if(parent != null && !visited.contains(parent)){
                    visited.add(parent);
                    queue.offer(parent);
                }
            }

            k--;
        }

        return result;
    }

    private void buildParentMap(TreeNode node, TreeNode parent, Map<TreeNode, TreeNode> parentMap) {
        if(node == null) return;

        parentMap.put(node, parent);

        buildParentMap(node.left, node, parentMap);
        buildParentMap(node.right, node, parentMap);
    }
}