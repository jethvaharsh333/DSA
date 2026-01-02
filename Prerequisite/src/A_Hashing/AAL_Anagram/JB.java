package A_Hashing.AAL_Anagram;

import java.util.Scanner;

public class JB {
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

            /*
             LOGIC: Fill/Push the frequency of letters of s and Remove/Pop from t and check at last is whole
             frequency arr is 0.
             */
            int[] letters = new int[26];

            for(int i=0 ; i<lengthOfS ; i++){
                int index = s.charAt(i) - 'a';
                letters[index]++;
            }

            for(int i=0 ; i<lengthOfS ; i++){
                int index = t.charAt(i) - 'a';
                letters[index]--;

                if(letters[index] < 0) return false;
            }

            return true;
        }
    }
}
