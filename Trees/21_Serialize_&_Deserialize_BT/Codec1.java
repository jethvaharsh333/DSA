// Time complexity: Serialization:O(n), Deserialization:O(n), ; Space complexity: O(n)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec1 {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null){
            return "n";
        }

        String left = serialize(root.left);
        String right = serialize(root.right);

        return left + "," + right + "," + root.val; 
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.equals("n")){
            return null;
        }
        
        String[] nodes = data.split(",");
        int[] lastIndex = {nodes.length-1};
        return buildTree(nodes, lastIndex);
    }

    private TreeNode buildTree(String[] nodes, int[] lastIndex) {
        if(lastIndex[0] < 0){
            return null;
        }

        String value = nodes[lastIndex[0]--];
        if(value.equals("n")){
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(value)); 
        root.right = buildTree(nodes, lastIndex);
        root.left = buildTree(nodes, lastIndex); 
        return root;
    }
}

// Your Codec1 object will be instantiated and called as such:
// Codec1 ser = new Codec1();
// Codec1 deser = new Codec1();
// TreeNode ans = deser.deserialize(ser.serialize(root));
