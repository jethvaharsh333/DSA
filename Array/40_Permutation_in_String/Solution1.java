// Time complexity: O(n); Space Complexity: O(n)
class Solution1 {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        HashMap<Character,Integer> map1 = new HashMap<>();
        HashMap<Character,Integer> map2 = new HashMap<>();

        for(int i=0 ; i<s1.length() ; i++){
            map1.put(s1.charAt(i), map1.getOrDefault(s1.charAt(i), 0)+1);
        }

        for (int i=0 ; i<s1.length() ; i++) {
            map2.put(s2.charAt(i), map2.getOrDefault(s2.charAt(i), 0) + 1);
        }
        if (map1.equals(map2)) return true;

        for(int i=s1.length() ; i<s2.length() ; i++){
            char newChar = s2.charAt(i);
            char oldChar = s2.charAt(i - s1.length());
            map2.put(newChar, map2.getOrDefault(newChar, 0) + 1);

            if(map2.get(oldChar) == 1){
                map2.remove(oldChar);
            } 
            else{
                map2.put(oldChar, map2.get(oldChar) - 1);
            }

            if (map1.equals(map2)) return true;
        }

        return false;
    }
}
