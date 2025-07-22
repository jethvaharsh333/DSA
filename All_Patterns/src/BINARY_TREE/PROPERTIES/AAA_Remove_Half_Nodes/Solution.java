package BINARY_TREE.PROPERTIES.AAA_Remove_Half_Nodes;

import BINARY_TREE.PROPERTIES.Node;

import java.util.*;

/**
 * Question link: https://www.geeksforgeeks.org/problems/remove-half-nodes/1
 * Date: 21-07-2025
 * Time complexity:
 * Space complexity:
 */

public class Solution {
    // Return the root of the modified tree after removing all the half nodes.
    public Node RemoveHalfNodes(Node root) {
        if(root==null) return root;

        root.left = RemoveHalfNodes(root.left);
        root.right = RemoveHalfNodes(root.right);

        if(root.left==null && root.right!=null){
            return root.right;
        }

        if(root.left!=null && root.right==null){
            return root.left;
        }

        return root;
    }
}