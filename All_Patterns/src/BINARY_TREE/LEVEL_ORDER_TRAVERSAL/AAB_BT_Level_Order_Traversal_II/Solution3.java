package BINARY_TREE.LEVEL_ORDER_TRAVERSAL.AAB_BT_Level_Order_Traversal_II;

import BINARY_TREE.LEVEL_ORDER_TRAVERSAL.TreeNode;

import java.util.*;

/**
 * Question link:
 * Date: 25-07-2025
 * Time complexity:
 * Space complexity:
 */

public class Solution3 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;

        trav(root, 0, result);

        return result;
    }

    private void trav(TreeNode node, int level, List<List<Integer>> result){
        if(node == null) return;

        if(result.size() <= level){
            result.add(0, new ArrayList<>());
        }

        result.get(result.size()-level-1).add(node.val);

        trav(node.left, level+1, result);
        trav(node.right, level+1, result);
    }
}