package BINARY_TREE.LEVEL_ORDER_TRAVERSAL.AAK_All_Nodes_Distance_K_in_BT;
import BINARY_TREE.LEVEL_ORDER_TRAVERSAL.TreeNode;
import java.util.*;

/**
 * Question link:
 * Date: 27-07-2025
 * Time complexity:
 * Space complexity:
 */

public class Solution2 {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> res = new ArrayList<>();
        if(root==null) return res;

        distance(root, target, k, res);

        return res;
    }

    private int distance(TreeNode root, TreeNode target, int k, List<Integer>res){
        if(root == null) return -1;

        if(root == target){
            levelOrder(root, k, res);
            return 1;
        }

        int left = distance(root.left, target, k, res);
        if(left != -1){
            if(k-left == 0) res.add(root.val);
            else levelOrder(root.right, k-left-1, res);
            return left+1;
        }

        int right = distance(root.right, target, k, res);
        if(right != -1){
            if(k-right == 0) res.add(root.val);
            else levelOrder(root.left, k-right-1, res);
            return right+1;
        }

        return -1;
    }

    private void levelOrder(TreeNode root, int dist, List<Integer>res){
        if(root == null) return;
        if(dist < 0) return;
        if(dist == 0){
            res.add(root.val);
            return;
        }

        levelOrder(root.left, dist-1, res);
        levelOrder(root.right, dist-1, res);
    }
}