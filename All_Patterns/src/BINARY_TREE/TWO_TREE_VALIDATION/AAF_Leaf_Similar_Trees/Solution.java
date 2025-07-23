package BINARY_TREE.TWO_TREE_VALIDATION.AAF_Leaf_Similar_Trees;

import BINARY_TREE.TWO_TREE_VALIDATION.TreeNode;

import java.util.*;

/**
 * Question link: https://leetcode.com/problems/leaf-similar-trees/
 * Date: 23-07-2025
 * Time complexity:
 * Space complexity:
 */

public class Solution {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leaves1 = new ArrayList<>();
        getLeaves(root1, leaves1);
        List<Integer> leaves2 = new ArrayList<>();
        getLeaves(root2, leaves2);

        return leaves1.equals(leaves2);
    }

    private void getLeaves(TreeNode root, List<Integer> leaves){
        if(root == null) return;

        if(root.left==null && root.right==null){
            leaves.add(root.val);
        }

        getLeaves(root.left, leaves);
        getLeaves(root.right, leaves);
    }
}