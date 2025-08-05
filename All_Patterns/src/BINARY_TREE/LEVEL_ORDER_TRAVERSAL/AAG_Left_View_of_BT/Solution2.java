package BINARY_TREE.LEVEL_ORDER_TRAVERSAL.AAG_Left_View_of_BT;

import java.util.*;

/**
 * Question link: https://www.geeksforgeeks.org/problems/left-view-of-binary-tree/1
 * Date: 05-08-2025
 * Time complexity:
 * Space complexity:
 */

public class Solution2 {
    ArrayList<Integer> leftView(Node root) {
        ArrayList<Integer> result = new ArrayList<Integer>();

        getLeftNodes(result, root, 0);

        return result;
    }

    private void getLeftNodes(ArrayList<Integer> result, Node root, int level){
        if(root == null) return;

        if(level == result.size()) result.add(root.data);

        getLeftNodes(result, root.left, level+1);
        getLeftNodes(result, root.right, level+1);
    }
}
