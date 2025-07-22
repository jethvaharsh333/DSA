package BINARY_TREE.CONSTRUCTION.AAF_Construct_BT_from_String_with_Bracket_Representation;

import java.util.*;

/**
 * Question link:
 * Date: 22-07-2025
 * Time complexity:
 * Space complexity:
 */

class Node {
    int data;
    Node left, right;
    Node(int x) {
        data = x;
        left = null;
        right = null;
    }
}

public class Solution {
    static int findIndex(String str, int i, int j) {
        if(i > j) return -1;

        int cnt = 0;

        for(int k=i ; k<=j ; k++){
            if(str.charAt(k) == '(') cnt++;
            else if (str.charAt(k) == ')') {
                cnt--;
                if(cnt == 0) return k;
            }
        }

        return -1;
    }

    static Node constructTreeRecur(String str, int i, int j) {
        if(i > j) return null;

        int val = 0;
        while(i<=j && Character.isDigit(str.charAt(i))) {
            val *= 10;
            val += (str.charAt(i)-'0');
            i++;
        }

        Node root = new Node(val);
        int index = -1;

        // finding index of ')' once we get '('
        if(i<=j && str.charAt(i) == '(') index = findIndex(str, i, j);

        if(index != -1){
            root.left = constructTreeRecur(str, i+1, index-1);
            root.right = constructTreeRecur(str, index+2, j-1); // Because after index, you skip the next '(' to start parsing content directly
        }

        return root;
    }

    static Node treeFromString(String str) {
        return constructTreeRecur(str, 0, str.length() - 1);
    }

    //Driver Code Starts
    static void levelOrder(Node root) {
        if (root == null) {
            System.out.print("N ");
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node curr = queue.poll();

            if (curr == null) {
                System.out.print("N ");
                continue;
            }
            System.out.print(curr.data + " ");
            queue.add(curr.left);
            queue.add(curr.right);
        }
    }

    public static void main(String[] args) {
        String[] str = {"4(2(3)(1))(6(5))"};
        Node root = treeFromString(str[0]);
        levelOrder(root);
    }
}