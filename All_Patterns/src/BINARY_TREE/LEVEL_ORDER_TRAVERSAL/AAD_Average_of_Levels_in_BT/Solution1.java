package BINARY_TREE.LEVEL_ORDER_TRAVERSAL.AAD_Average_of_Levels_in_BT;

import BINARY_TREE.LEVEL_ORDER_TRAVERSAL.TreeNode;

import java.util.*;

/**
 * Question link:
 * Date: 25-07-2025
 * Time complexity:
 * Space complexity:
 */

public class Solution1 {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            int size = q.size();
            double sum=0, count=size;

            while(size-- > 0){
                TreeNode cur = q.remove();
                sum += cur.val;
                if(cur.left != null) q.add(cur.left);
                if(cur.right != null) q.add(cur.right);
            }

            double avg = sum/count;
            result.add(avg);
        }

        return result;
    }
}