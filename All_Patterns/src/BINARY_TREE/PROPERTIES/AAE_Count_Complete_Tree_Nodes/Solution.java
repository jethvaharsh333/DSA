package BINARY_TREE.PROPERTIES.AAE_Count_Complete_Tree_Nodes;

import BINARY_TREE.PROPERTIES.TreeNode;

import java.util.*;

/**
 * Question link: https://leetcode.com/problems/count-complete-tree-nodes/
 * Date: 21-07-2025
 * Time complexity:
 * Space complexity:
 */

public class Solution {
    public int countNodes(TreeNode root) {
        if (root == null) return 0;

        int leftHeight = getLeftHeight(root);
        int rightHeight = getRightHeight(root);

        if(leftHeight == rightHeight){          // If same height then don't traverse all the way for subtree. For CBT => 2^h - 1
            return (1 << leftHeight) - 1;
        }

        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    private int getLeftHeight(TreeNode root){
        if(root == null) return 0;

        return 1 + getLeftHeight(root.left);
    }

    private int getRightHeight(TreeNode root){
        if(root == null) return 0;

        return 1 + getRightHeight(root.right);
    }
}

/*

**Idea is to use the property of complete tree which is 2^h-1.

Step 1: At Node 1
Left height: 1 -> 2 -> 4 = 3
Right height: 1 -> 3 = 2
Not perfect ⇒ recurse both subtrees:
countNodes(1) = 1 + countNodes(2) + countNodes(3)

Step 2: countNodes(2)
Left: 2 -> 4 = 2
Right: 2 -> 5 = 2
Perfect tree ⇒
countNodes(2) = 2^2 - 1 = 3
=> Nodes: 2, 4, 5

Step 3: countNodes(3)
Left: 3 -> 6 = 2
Right: 3 -> null = 1
Not perfect ⇒
countNodes(3) = 1 + countNodes(6) + countNodes(null)

Step 4: countNodes(6)
Left = Right = 1 (null)
Perfect tree ⇒
countNodes(6) = 2^1 - 1 = 1

Final Total:
countNodes(1) = 1 + 3 + (1 + 1 + 0) = 6

*/