// Time Complexity: O(n^2), Space Complexity: O(1)

class Solution1 {
    public List<Integer> partitionLabels(String s) {
        List<Integer> result = new ArrayList<>();
        int n = s.length();
        int start = 0;

        while(start < n){
            Set<Character> set = new HashSet<>();
            int end = start;
            
            for(int i=start ; i<n ; i++){
                set.add(s.charAt(i));

                for(char c : set){
                    if(s.lastIndexOf(c) > i){
                        end = Math.max(end, s.lastIndexOf(c));
                    }
                }
                
                if(i == end){
                    result.add(end-start+1);
                    start = end+1;
                    break;
                }
            }
        }
        
        return result;
    }
}
