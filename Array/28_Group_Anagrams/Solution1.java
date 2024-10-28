// O(n.klogk), 6ms 
class Solution1 {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) return new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();

        for(int i=0 ; i<strs.length ; i++){
            char chararr[] = strs[i].toCharArray();
            Arrays.sort(chararr);
            String str = new String(chararr);
            
            if(!map.containsKey(str)){
                map.put(str, new ArrayList<>());
            }

            map.get(str).add(strs[i]);
        }

        return new ArrayList<>(map.values());
    }
}

/*
Iterating through each string in strs: Suppose there are n strings in the input array strs. : O(n)
Sorting each string: string of average length k: O(klogk) time
HashMap operations: O(1) on average.
Constructing the key by sorting each string is O(klogk).
Thus, the total time complexity becomes: O(n⋅klogk)
*/
