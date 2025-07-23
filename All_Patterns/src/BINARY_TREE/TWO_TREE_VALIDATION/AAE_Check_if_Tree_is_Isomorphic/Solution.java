package BINARY_TREE.TWO_TREE_VALIDATION.AAE_Check_if_Tree_is_Isomorphic;

import java.util.*;

/**
 * Question link: https://www.geeksforgeeks.org/problems/check-if-tree-is-isomorphic/1
 * Date: 23-07-2025
 * Time complexity:
 * Space complexity:
 */
class Node
{
    int data;
    Node left, right;
    Node(int item)    {
        data = item;
        left = right = null;
    }
}

public class Solution {
    boolean isIsomorphic(Node root1, Node root2) {
        // code here.
        if(root1==null && root2==null) return true;
        if(root1==null || root2==null) return false;
        if(root1.data != root2.data) return false;

        boolean noSwap = isIsomorphic(root1.left, root2.left) && isIsomorphic(root1.right, root2.right);
        boolean swap = isIsomorphic(root1.left, root2.right) && isIsomorphic(root1.right, root2.left);

        return noSwap || swap;
    }
}