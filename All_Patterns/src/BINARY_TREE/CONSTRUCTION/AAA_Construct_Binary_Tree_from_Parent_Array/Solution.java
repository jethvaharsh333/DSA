package BINARY_TREE.CONSTRUCTION.AAA_Construct_Binary_Tree_from_Parent_Array;

/**
 * Question link:
 * Date: 22-07-2025
 * Time complexity:
 * Space complexity:
 */

class Node
{
    int data;
    Node left, right;
    Node(int key)
    {
        data = key;
        left = right = null;
    }
}

public class Solution {
    // Function to construct binary tree from parent array.
    public Node createTree(int parent[]) {
        int len = parent.length;
        Node[] created = new Node[len];
        Node root = null;

        for(int i=0 ; i<len ; i++){
            if(created[i] == null){
                created[i] = new Node(i);
            }

            if(parent[i] == -1){
                root = created[i];
                continue;
            }

            if(created[parent[i]] == null){
                created[parent[i]] = new Node(parent[i]);
            }

            Node parentNode = created[parent[i]];
            if(parentNode.left == null) parentNode.left = created[i];
            else parentNode.right = created[i];
        }

        return root;
    }
}

/*

parent = [2, 0, -1]

| Node | parent | Meaning                     |
| ---- | ------ | --------------------------- |
| 0    | 2      | Node 0 is a child of node 2 |
| 1    | 0      | Node 1 is a child of node 0 |
| 2    | -1     | Node 2 is root              |


*/