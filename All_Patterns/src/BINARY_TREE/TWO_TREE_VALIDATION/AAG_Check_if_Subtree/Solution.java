package BINARY_TREE.TWO_TREE_VALIDATION.AAG_Check_if_Subtree;

import java.util.*;

/**
 * Question link: https://www.geeksforgeeks.org/problems/check-if-subtree/1
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
    public static boolean isSubtree(Node T, Node S) {
        if(T==null && S==null) return true;
        if(T==null || S==null) return false;

        return isSubtree(T.left, S) || isSubtree(T.right, S) || check(T, S);
    }

    private static boolean check(Node root1, Node root2){
        if(root1==null && root2==null) return true;
        if(root1==null || root2==null) return false;
        if(root1.data == root2.data) return check(root1.left, root2.left) && check(root1.right, root2.right);
        return false;
    }
}