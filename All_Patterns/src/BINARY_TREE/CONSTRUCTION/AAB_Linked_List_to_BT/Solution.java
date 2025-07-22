package BINARY_TREE.CONSTRUCTION.AAB_Linked_List_to_BT;


import BINARY_TREE.CONSTRUCTION.TreeNode;

import java.util.*;

/**
 * Question link:
 * Date: 22-07-2025
 * Time complexity:
 * Space complexity:
 */
class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

public class Solution {
    public TreeNode linkedListToBinaryTree(Node head) {
        if (head == null) return null;
        List<TreeNode> nodes = new ArrayList<>();
        Node current = head;

        while (current != null) {
            nodes.add(new TreeNode(current.data));
            current = current.next;
        }

        for(int i=0 ; i<nodes.size() ; i++){
            if(2*i+1 < nodes.size()){
                nodes.get(i).left = nodes.get(2*i+1);
            }

            if(2*i+2<nodes.size()){
                nodes.get(i).right = nodes.get(2*i+2);
            }
        }

        return nodes.get(0);
    }
}