package BINARY_TREE.CONSTRUCTION.AAC_Construct_BT_from_Preorder_and_Inorder_Traversal;

import BINARY_TREE.CONSTRUCTION.TreeNode;

import java.util.*;

/**
 * Question link:
 * Date: 22-07-2025
 * Time complexity:
 * Space complexity:
 */

public class Solution2 {
    private int pre = 0;
    private int in = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, inorder, Integer.MIN_VALUE);
    }

    private TreeNode buildTree(int[] preOrder, int[] inOrder, int stop){
        if(pre >= preOrder.length) return null;

        if(inOrder[in] == stop){
            in++;
            return null;
        }

        TreeNode root = new TreeNode(preOrder[pre++]);

        root.left = buildTree(preOrder, inOrder, root.val);
        root.right = buildTree(preOrder, inOrder, stop);

        return root;
    }
}


/*

# IDEA:
We know:
    Preorder = root → left → right
    Inorder =  left → root → right
This means:
    If we walk preorder linearly, we’re always picking the next root.
    If we walk inorder linearly, we’re waiting to match the root.

# Keep building the tree from preorder until we hit the stop value in inorder.

# Nodes created through preOrder and joins through Inorder.

# tree(preorder, inorder, stop = 3)
Keep building nodes until you reach 3 in inorder.
That means everything before 3 belongs to its left subtree.
*/
