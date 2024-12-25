class Solution1 {
    class Pair{
        String first;
        int second;
        Pair(String _first, int _second){
            this.first = _first;
            this.second = _second;
        }
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(beginWord, 1));

        Set<String> set = new HashSet<>();
        int len = wordList.size();
        for(int i=0 ; i<len ; i++){
            set.add(wordList.get(i));
        }

        while(!queue.isEmpty()){
            String word = queue.peek().first;
            int steps = queue.peek().second;
            queue.remove();

            if(word.equals(endWord)) return steps;

            int wordLength = word.length();
            for(int i=0 ; i<wordLength ; i++){
                for(char ch='a' ; ch<='z' ; ch++){
                    char[] replacedCharArray = word.toCharArray();
                    replacedCharArray[i] = ch;
                    String replacedWord = new String(replacedCharArray);

                    if(set.contains(replacedWord)){
                        set.remove(replacedWord);
                        queue.add(new Pair(replacedWord, steps+1));
                    }
                }
            }
        }

        return 0;
    }
}
