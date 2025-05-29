// Time Complexity: O(n), Space Complexity: O(1)

class Solution2 {
    public List<Integer> partitionLabels(String s) {
        int[] lastIndex = new int[26];
        for(int i=0 ; i<s.length() ; i++){
            lastIndex[s.charAt(i)-'a'] = i;
        }

        List<Integer> result = new ArrayList<>();
        int startIndex = 0;
        int endIndex = 0;

        for(int i=0 ; i<s.length() ; i++){
            if(lastIndex[s.charAt(i)-'a'] > endIndex){
                endIndex = lastIndex[s.charAt(i)-'a']; 
            }

            if(i == endIndex){
                result.add(endIndex-startIndex+1);
                startIndex = i+1;
            }
        }

        return result;
    }
}
