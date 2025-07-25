package BINARY_TREE.LEVEL_ORDER_TRAVERSAL;

import java.util.*;

/**
 * Question link:
 * Date: 25-07-2025
 * Time complexity:
 * Space complexity:
 */

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}