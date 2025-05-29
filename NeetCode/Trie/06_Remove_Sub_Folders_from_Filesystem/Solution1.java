// Time Complexity: O(N*L), Space Complexity: O(N*L) [N = number of folders, L = maximum length of a folder path] 
class Solution1 {
    class Trie {
        private Map<String, Trie> links = new HashMap<>();
        private String deepFolder = null;
    }

    private Trie buildTrie(String[] folder) {
        Trie root = new Trie();
        for(String f : folder){
            Trie node = root;

            String[] parts = f.split("/");
            for(String part : parts){
                if(part.isEmpty()) continue;
                node.links.putIfAbsent(part, new Trie());
                node = node.links.get(part);
            }

            node.deepFolder = f;
        }

        return root;
    }

    private void collectRootFolders(Trie node, List<String> result) {
        if(node == null) return;

        if(node.deepFolder != null){
            result.add(node.deepFolder);
            return;
        }

        for(Trie child : node.links.values()){
            collectRootFolders(child, result);
        }
    }

    public List<String> removeSubfolders(String[] folder) {
        // Arrays.sort(folder); 
        Trie root = buildTrie(folder);
        List<String> result = new ArrayList<>();
        collectRootFolders(root, result);
        return result;
    }
}
