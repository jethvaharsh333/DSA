// Time complexity: O(n); Space Complexity: O(n)
class Solution3 {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";
        
        HashMap<Character, Integer> map = new HashMap<>(); // character with count
        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0;
        int counter = t.length();
        int minLength = Integer.MAX_VALUE;
        int minLeft = 0;

        while(right < s.length()){
            char ch1 = s.charAt(right);
            int count1 = map.getOrDefault(ch1, 0);
            if(count1 > 0) counter--;
            map.put(ch1, count1-1);

            while(counter == 0){
                if(right-left+1 < minLength){
                    minLength = right-left+1;
                    minLeft = left;
                }

                char ch2 = s.charAt(left);
                int count2 = map.getOrDefault(ch2, 0);
                map.put(ch2, count2+1);
                if (count2 >= 0) counter++;
                left++;
            }

            right++;
        }

        return minLength == Integer.MAX_VALUE ? "" : s.substring(minLeft, minLeft + minLength);
    }
}
