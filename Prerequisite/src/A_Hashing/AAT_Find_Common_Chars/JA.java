package A_Hashing.AAT_Find_Common_Chars;

import java.util.*;

public class JA {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] words = new String[n];
        for(int i=0 ; i<n ; i++){
            words[i] = sc.nextLine();
        }

        System.out.println(commonChars(words));
    }

    private static List<String> commonChars(String[] words) {
        int wordsSize = words.length;
        int[] commonCharacterCounts = new int[26];
        int[] currentCharacterCounts = new int[26];
        List<String> result = new ArrayList<>();

        for(char ch : words[0].toCharArray()){
            commonCharacterCounts[ch-'a']++;
        }

        for(int i=1 ; i<wordsSize ; i++){
            Arrays.fill(currentCharacterCounts, 0);

            for(char ch : words[i].toCharArray()){
                currentCharacterCounts[ch-'a']++;
            }

            // Update the common character counts to keep the minimum counts
            for (int letter=0 ; letter<26 ; letter++){
                commonCharacterCounts[letter] = Math.min(
                        commonCharacterCounts[letter],
                        currentCharacterCounts[letter]
                );
            }
        }



        for(int i=0 ; i<26 ; i++){
            // No. of times l comes twice, so in result l should appear twice. That's why 2nd loop.
            for(int j=0 ; j<commonCharacterCounts[i] ; j++){
                result.add(String.valueOf((char) (i + 'a')));
            }
        }

        return result;
    }
}
