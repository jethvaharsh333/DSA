package BINARY_TREE.CONSTRUCTION.AAE_Construct_BT_from_Preorder_and_Postorder_Traversal;

import BINARY_TREE.CONSTRUCTION.TreeNode;

import java.util.*;

/**
 * Question link:
 * Date: 22-07-2025
 * Time complexity:
 * Space complexity:
 */

public class Solution {
    int postpreindex = 0;

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        Map<Integer, Integer> postorderMap = new HashMap<>();
        for(int i=0 ; i<postorder.length ; i++){
            postorderMap.put(postorder[i], i);
        }

        return build(preorder, postorder, postorderMap, 0, postorder.length-1);
    }

    private TreeNode build(int[] preorder, int[] postorder, Map<Integer, Integer> postorderMap, int start, int end){
        if(start > end) return null;

        TreeNode root = new TreeNode(preorder[postpreindex++]);

        if(start == end){
            return root;
        }

        int index = postorderMap.get(preorder[postpreindex]);

        root.left = build(preorder, postorder, postorderMap, start, index);
        root.right = build(preorder, postorder, postorderMap, index+1, end-1);

        return root;
    }
}