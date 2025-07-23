package BINARY_TREE.TWO_TREE_VALIDATION.AAB_Two_Mirror_Trees;

import java.util.*;

/**
 * Question link: https://www.geeksforgeeks.org/problems/two-mirror-trees/1
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
    boolean areMirror(Node a, Node b) {
        if(a==null && b==null) return true;
        if(a==null || b==null) return false;

        if(a.data == b.data){
            return areMirror(a.left, b.right) && areMirror(a.right, b.left);
        }

        return false;
    }
}