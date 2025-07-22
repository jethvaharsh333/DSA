package BINARY_TREE.CONSTRUCTION.AAC_Construct_BT_from_Preorder_and_Inorder_Traversal;

import BINARY_TREE.CONSTRUCTION.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Question link:
 * Date: 22-07-2025
 * Time complexity:
 * Space complexity:
 */

public class Solution1 {
    private int preOrderIndex = 0;
    private Map<Integer, Integer> inOrderMap = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int len = inorder.length;

        for(int i=0 ; i<len ; i++){
            inOrderMap.put(inorder[i], i);
        }

        return buildTree(preorder, 0, len-1);
    }

    private TreeNode buildTree(int[] preOrder, int left, int right){
        if(left > right) return null;

        int val = preOrder[preOrderIndex++];
        TreeNode root = new TreeNode(val);

        int inOrderIndex = inOrderMap.get(val);

        root.left = buildTree(preOrder, left, inOrderIndex-1);
        root.right = buildTree(preOrder, inOrderIndex+1, right);

        return root;
    }
}
