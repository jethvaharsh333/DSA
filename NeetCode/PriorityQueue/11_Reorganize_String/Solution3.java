// Time Complexity: O(n), Space Complexity: O(n)

class Solution3 {
    public String reorganizeString(String s) {
        int[] freq = new int[26];

        for(char c:s.toCharArray()){
            freq[c-'a']++;
        }

        int maxFreq = 0;
        int maxFreqLetter = 0;
        for(int k=0;k<26;k++){
            if(freq[k] > maxFreq){
                maxFreq = freq[k];
                maxFreqLetter = k;
            }
        }

        if(maxFreq > (s.length() + 1)/2){
            return "";
        }

        char[] ans = new char[s.length()];
        int index = 0;

        while(freq[maxFreqLetter] !=0){
            ans[index] = (char) (maxFreqLetter + 'a');
            index +=2;
            freq[maxFreqLetter]--;
        }

        for(int i=0; i< freq.length; i++){
            while(freq[i] > 0){
                if(index >= s.length()){
                    index=1;
                }
                ans[index] = (char)(i+ 'a');
                index += 2;
                freq[i]--;
            }
        }
        return String.valueOf(ans);
    }
}
