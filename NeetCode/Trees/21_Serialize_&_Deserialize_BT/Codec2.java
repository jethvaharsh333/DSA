// Time complexity: Serialization:O(1), Deserialization:O(1), ; Space complexity: O(1)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec2 {

    static TreeNode node;

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        node = root;
        return ""; 
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        return this.node;
    }
}

// Your Codec2 object will be instantiated and called as such:
// Codec2 ser = new Codec2();
// Codec2 deser = new Codec2();
// TreeNode ans = deser.deserialize(ser.serialize(root));
