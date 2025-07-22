package BINARY_TREE.CONSTRUCTION.AAD_Construct_BT_from_Inorder_n_Postorder_Traversal;

import BINARY_TREE.CONSTRUCTION.TreeNode;

import java.util.*;

/**
 * Question link:
 * Date: 22-07-2025
 * Time complexity:
 * Space complexity:
 */

public class Solution2 {
    private int in;
    private int post;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int len = inorder.length;
        in = inorder.length - 1;
        post = postorder.length - 1;

        return buildTree(inorder, postorder, Integer.MIN_VALUE);
    }

    private TreeNode buildTree(int[] inorder, int[] postorder, int stop){
        if(post < 0) return null;

        if(inorder[in] == stop){
            in--;
            return null;
        }

        TreeNode node = new TreeNode(postorder[post--]);

        node.right = buildTree(inorder, postorder, node.val);
        node.left = buildTree(inorder, postorder, stop);

        return node;
    }
}

/*

Because postorder gives me nodes from RIGHT to LEFT, I must scan inorder[] from RIGHT to LEFT, or everything breaks.

Inorder = [Left ➝ Root ➝ Right]

Let’s look at a real example:
inorder:    [9, 3, 15, 20, 7]
postorder:  [9, 15, 7, 20, 3]

We know:
The last in postorder is 3 → ROOT
In inorder, 3 is at index 1

So:
Left subtree: [9]
Right subtree: [15, 20, 7]

Now we recursively build:
build(right of 3) ➝ build(left of 3)

*/