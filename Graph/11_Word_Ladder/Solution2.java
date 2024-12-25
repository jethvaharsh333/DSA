class Solution2 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) return 0;
        
        HashMap<String, List<String>> adja = new HashMap<>();

        for (String word : wordList) {
            addNeighborsToAdja(adja, word);
        }

        Queue<String> bfs = new LinkedList<>();
        HashSet<String> seen = new HashSet<>();
        seen.add(beginWord);
        bfs.add(beginWord);

        int dist = 1;
        while (!bfs.isEmpty()) {
            for (int i = bfs.size()-1; i >= 0; i--) {
                String curr = bfs.poll();
                List<String> similarStrings = getSimilarStrings(curr);

                for (String similar : similarStrings) {
                    for (String neighbor : adja.getOrDefault(similar, List.of())) {
                        if (seen.contains(neighbor)) continue;
                        if (neighbor.equals(endWord)) return dist+1;
                        seen.add(neighbor);
                        bfs.add(neighbor);
                    }
                }
            }
            dist++;
        }

        return 0;
    }

    private List<String> getSimilarStrings(String word) {
        List<String> ret = new ArrayList<>();
        for (int i = 0; i < word.length(); i++) {
            String neighbor = word.substring(0,i) + "*" + word.substring(i+1,word.length());
            ret.add(neighbor);
        }

        return ret;
    }

    private void addNeighborsToAdja(HashMap<String, List<String>> adja, String word) {
        for (int i = 0; i < word.length(); i++) {   
            String neighbor = word.substring(0,i) + "*" + word.substring(i+1,word.length());
            adja.putIfAbsent(neighbor, new ArrayList<String>());
            adja.get(neighbor).add(word);
        }
    }
}
