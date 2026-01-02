package A_Hashing.AAL_Anagram;

import java.util.Scanner;

public class JA {
    public static void main(String[] args) {
        // INPUT
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String t = sc.nextLine();

        // LOGIC
        Solution sol = new Solution();
        System.out.println(sol.isAnagram(s, t));
    }

    private static class Solution {
        public boolean isAnagram(String s, String t) {
            int lengthOfS = s.length(), lengthOfT = t.length();

            if(lengthOfS != lengthOfT) return false;

            int[] lettersOfS = new int[26];
            int[] lettersOfT = new int[26];
            // hashing; frequency of each letter in string to be stored.

            for(int i=0 ; i<lengthOfS ; i++){
                int sIndex = s.charAt(i) - 'a';
                int tIndex = t.charAt(i) - 'a';

                lettersOfS[sIndex]++; lettersOfT[tIndex]++;
            }

            for(int i=0 ; i<26 ; i++){
                if(lettersOfS[i] != lettersOfT[i]) return false;
            }

            return true;
        }
    }
}
