// Time Complexity: O(nlogk), Space Complexity: O(n+k)

class Solution2 {
    public String reorganizeString(String s) {
        Map<Character, Integer> freqMap = new HashMap<>();

        for(char c : s.toCharArray()){
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }

        int maxFreq = 0;
        for(int freq : freqMap.values()){
            maxFreq = Math.max(maxFreq, freq);
        }
        
        if(maxFreq>(s.length()+1)/2){
            return "";
        }

        PriorityQueue<Character> maxHeap = new PriorityQueue<>(
            (a, b) -> freqMap.get(b) - freqMap.get(a)
        );
        
        maxHeap.addAll(freqMap.keySet());

        StringBuilder result = new StringBuilder();
        Character prevChar = null;

        while(!maxHeap.isEmpty()){
            char current = maxHeap.poll();
            result.append(current);

            freqMap.put(current, freqMap.get(current)-1);

            if(prevChar!=null && freqMap.get(prevChar)>0){
                maxHeap.offer(prevChar);
            }

            prevChar = current;
        }

        return result.toString();
    }
}
