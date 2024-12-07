// Time Complexity: O(n), Space Complexity: O(w) [w = maximum width of tree]
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution1 {
    private Queue<Node> queue = new LinkedList<>();

    public Node connect(Node root) {
        if(root == null){
            return root;
        }

        queue.add(root);
        
        bfs(root);
        root.next = null;
        return root;
    }

    private void bfs(Node root) {
        while(!queue.isEmpty()){
            int size = queue.size();
            Node node = null; 

            for(int i=0 ; i<size ; i++){
                node = queue.poll();
                node.next = queue.peek();

                if(node.left != null){
                    queue.add(node.left);
                }

                if(node.right != null){
                    queue.add(node.right);
                }
            }

            node.next = null;
        }
    }
}
