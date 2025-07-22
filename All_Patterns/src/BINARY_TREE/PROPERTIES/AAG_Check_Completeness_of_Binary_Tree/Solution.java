package BINARY_TREE.PROPERTIES.AAG_Check_Completeness_of_Binary_Tree;

import BINARY_TREE.PROPERTIES.TreeNode;

import java.util.*;

/**
 * Question link: https://leetcode.com/problems/check-completeness-of-a-binary-tree/
 * Date: 21-07-2025
 * Time complexity:
 * Space complexity:
 */

public class Solution {
    public boolean isCompleteTree(TreeNode root) {
        if (root == null) return true;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean seenNull = false;

        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();

            if (curr == null) {
                seenNull = true;
            } else {
                if (seenNull) return false; // Any node after a null = Not Complete
                queue.offer(curr.left);
                queue.offer(curr.right);
            }
        }

        return true;
    }
}

/*

# A binary tree is complete if:
1) Every level is completely filled except possibly the last
2) All nodes in the last level are as far left as possible.

In this code even if nodes skipped between left sided and right sided nodes => it will give error as seenNull becomes true during those
"between nodes" and if any nodes comes after that in same level or below level it will be considered as invalid.

* */