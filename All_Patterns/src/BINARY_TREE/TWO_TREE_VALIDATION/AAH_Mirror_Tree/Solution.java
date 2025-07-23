package BINARY_TREE.TWO_TREE_VALIDATION.AAH_Mirror_Tree;

import java.util.*;

/**
 * Question link: https://www.geeksforgeeks.org/problems/mirror-tree/1
 * Date: 23-07-2025
 * Time complexity:
 * Space complexity:
 */

class Node{
    int data;
    Node left,right;
    Node(int d)
    {
        data=d;
        left=null;
        right=null;
    }
}

public class Solution {
    void mirror(Node node) {
        if(node == null) return;

        mirror(node.left);
        mirror(node.right);

        Node leftNode = node.left;
        node.left = node.right;
        node.right = leftNode;
    }
}