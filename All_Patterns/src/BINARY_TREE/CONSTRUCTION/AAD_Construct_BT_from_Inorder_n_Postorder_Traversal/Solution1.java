package BINARY_TREE.CONSTRUCTION.AAD_Construct_BT_from_Inorder_n_Postorder_Traversal;

import BINARY_TREE.CONSTRUCTION.TreeNode;

import java.util.*;

/**
 * Question link:
 * Date: 22-07-2025
 * Time complexity:
 * Space complexity:
 */

public class Solution1 {
    private int post;
    private Map<Integer, Integer> inorderMap = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int len = inorder.length;
        post = postorder.length-1;

        for(int i=0 ; i<len ; i++){
            inorderMap.put(inorder[i], i);
        }

        return buildTree(postorder, 0, len-1);
    }

    private TreeNode buildTree(int[] postorder, int left, int right){
        if(left > right) return null;

        TreeNode node = new TreeNode(postorder[post--]);
        int ind = inorderMap.get(node.val);

        node.right = buildTree(postorder, ind+1, right);
        node.left = buildTree(postorder, left, ind-1);

        return node;
    }
}

/*

Here we know two different inde subtrees be made but we have to decide order of building left and right subtres as per
TRAVERSAL.

----------------------------------------------------------------------------------------------------------

1) Preorder = Root → Left → Right AND you're reading forwards (pre++)
So:
    First: pick root
    Then: build left subtree
    Then: build right subtree
You CANNOT build right subtree first here, because you haven’t even seen left subtree in the traversal yet!

E.g.:
Preorder  = [A, B, D, E, C, F]
Inorder   = [D, B, E, A, F, C]

You pass: For A, left subtree = inorder[0..2] → D, B, E
Right subtree = inorder[4..5] → F, C

But in preorder, right after A, you get:
B, D, E  ← These are left subtree nodes
If you try to build the right subtree first, your recursive call has:
pre = 1 → B
But B belongs to the left subtree — you’re now building the wrong tree from the wrong segment of preorder.

You’ve violated traversal order.

----------------------------------------------------------------------------------------------------------

2) Postorder = Left → Right → Root AND you're reading backwards (post--)
So:
    First: pick root
    Then: build right subtree
    Then: build left subtree
Here, we are reading last before and is our root which means we first have to build right subTree first

*/