// Insert() : Time Complexity: O(n), Space Complexity: O(n)
// Search() : Time Complexity: O(n), Space Complexity: O(1)
// StartsWith() : Time Complexity: O(n), Space Complexity: O(1)

class Trie {
    private Node root;

    public Trie() {
        root = new Node();
    }
    
    public void insert(String word) {
        Node node = root; // At begining of the trie
        for(int i=0 ; i<word.length() ; i++){
            if(!node.containsKey(word.charAt(i))){
                node.put(word.charAt(i), new Node());
            }
            node = node.get(word.charAt(i));
        }
        node.setEnd();
    }
    
    public boolean search(String word) {
        Node node = root;
        for(int i=0 ; i<word.length() ; i++){
            if(!node.containsKey(word.charAt(i))){
                return false;
            }
            node = node.get(word.charAt(i));
        }

        return node.isEnd();
    }
    
    public boolean startsWith(String prefix) {
        Node node = root;
        for(int i=0 ; i<prefix.length() ; i++){
            if(!node.containsKey(prefix.charAt(i))){
                return false;
            }
            node = node.get(prefix.charAt(i));
        }

        return true;
    }
}

class Node{
    private Node[] links = new Node[26];
    private boolean flag = false;

    public boolean containsKey(char ch){
        return links[ch-'a'] != null;
    }

    public void put(char ch, Node node){
        links[ch-'a'] = node;
    }

    public Node get(char ch){
        return links[ch-'a'];
    }

    public void setEnd(){
        flag = true;
    }

    public boolean isEnd(){
        return flag;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
