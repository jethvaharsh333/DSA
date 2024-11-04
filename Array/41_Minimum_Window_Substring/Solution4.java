// Time complexity: O(n); Space Complexity: O(1); OPTIMAL SOLUTION
class Solution4 {
    public String minWindow(String s, String t) {
        int tEle[] = new int[123]; //to track a-z & A-Z in unicode (65-90 and 97-122)
        for(char c: t.toCharArray()){
            tEle[c]++; //count frequency of letters, putting a char translates to ASCII code, so its a funky index. E.G. tEle['a'] => tEle[97]
        }

        char[]S = s.toCharArray();
        int minLength = Integer.MAX_VALUE, start = 0;
        int find = t.length();

        int left = 0, right = 0;    //sliding window
        while(right < S.length){    //to slide right limit
            if(tEle[S[right]] > 0) find--; 

            tEle[S[right]]--;
            right++;

            while(find == 0){   //to slide left limit when all required characters are found
                if(right - left < minLength){
                    start = left;
                    minLength = right - left;
                }
                if(tEle[S[left]] == 0) find++;
                tEle[S[left]]++;
                left++;
            }
        }
        if(minLength == Integer.MAX_VALUE) return new String();
        return s.substring(start, start+minLength);
    }
}
