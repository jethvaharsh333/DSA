class Solution {
    public int maxDifference(String s) {
        Map<Character, Integer> map = new HashMap<>();

        for(int i=0 ; i<s.length() ; i++){
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        int maxOdd = 0;
        int minEven = Integer.MAX_VALUE;
        
        for(int value: map.values()){
            if(value%2 == 0){        // even freq
                if(minEven > value){
                    minEven = value;
                }
            }else{
                if(maxOdd < value){
                    maxOdd = value;
                }
            }
        }

        return maxOdd-minEven;
    }
}
