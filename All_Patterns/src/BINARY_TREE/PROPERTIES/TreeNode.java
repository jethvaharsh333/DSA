package BINARY_TREE.PROPERTIES;

import java.util.*;

/**
 * Question link:
 * Date: 22-07-2025
 * Time complexity:
 * Space complexity:
 */

public class TreeNode {
    int val;
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