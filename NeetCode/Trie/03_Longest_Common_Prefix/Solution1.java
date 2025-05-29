// Time Complexity: O(n*m), Space Complexity: O(n*m)

class Solution1 {
    class Trie{
        Trie[] links = new Trie[26];
        boolean flag = false;
    }

    private Trie buildTrie(String[] strs){
        Trie root = new Trie();

        for(String str: strs){
            Trie node = root;
            for(char ch: str.toCharArray()){
                int index = ch-'a';
                if(node.links[index] == null){
                    node.links[index] = new Trie();
                }
                node = node.links[index];
            }
            node.flag = true;
        }

        return root;
    }

    private String traverseTrie(Trie root){
        StringBuilder prefix = new StringBuilder();
        Trie node = root;

        while(node != null){
            int childCount = 0;
            int index = -1;

            for(int i=0 ; i<26 ; i++){
                if(node.links[i] != null){
                    childCount++;
                    index = i;
                }
            }

            if(childCount!=1 || node.flag){
                break;
            }

            prefix.append((char)(index+'a'));
            node = node.links[index];
        }

        return prefix.toString();
    }
    
    public String longestCommonPrefix(String[] strs) {
        Trie root = buildTrie(strs);
        return traverseTrie(root);
    }
}
