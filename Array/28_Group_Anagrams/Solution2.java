class Solution2 {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) return new ArrayList<>();

        Map<String, List<String>> map = new HashMap<>();
        
        for (String s : strs) {
            char[] ca = new char[26];
            for (int i = 0; i < s.length(); i++) 
                ca[s.charAt(i) - 'a']++;
            
            String keyStr = String.valueOf(ca);
            
            if (!map.containsKey(keyStr)) 
                map.put(keyStr, new ArrayList<>());
            
            map.get(keyStr).add(s);
        }
        return new ArrayList<>(map.values());
    }
}
