// O(n), 5ms, 52.35 beats
class Solution2 {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] arr = new int[26];

        for(int i=0 ; i<s.length() ; i++){
            arr[s.charAt(i) - 'a']++;
            arr[t.charAt(i) - 'a']--;
        }

        for(int x: arr){
            if(x!=0) return false;
        }

        return true;
    }
}
