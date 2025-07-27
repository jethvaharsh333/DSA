package BINARY_TREE.LEVEL_ORDER_TRAVERSAL.AAF_BT_Right_Side_View;

import BINARY_TREE.LEVEL_ORDER_TRAVERSAL.TreeNode;

import java.util.*;

/**
 * Question link:
 * Date: 27-07-2025
 * Time complexity:
 * Space complexity:
 */

public class Solution2 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        dfs(root, 0, res);
        return res;
    }

    public void dfs(TreeNode root, int depth, List<Integer> res){
        if(root == null)  return;

        if(depth == res.size()){
            res.add(root.val);
        }

        dfs(root.right, depth+1, res);
        dfs(root.left, depth+1, res);
    }
}