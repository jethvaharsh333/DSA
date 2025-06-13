package SLIDING_WINDOW.DYNAMIC_SIZE_WINDOW_PROBLEMS.AAC_Max_Num_Of_Occurence_Of_Substring;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input string and constraints
        System.out.print("Enter string s: ");
        String s = sc.nextLine();

        System.out.print("Enter maxLetters: ");
        int maxLetters = sc.nextInt();

        System.out.print("Enter minSize: ");
        int minSize = sc.nextInt();

        System.out.print("Enter maxSize: ");
        int maxSize = sc.nextInt();

        // Call the maxFreq method
        int result = maxFreq(s, maxLetters, minSize, maxSize);
        System.out.println("Maximum frequency of valid substring: " + result);
    }

    public static int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        HashMap<String, Integer> map = new HashMap<>();
        int left=0, right=minSize;

        while (right <= s.length()){
            // count substrings within a fixed-size window of size minsize
            // because even if larger the string is the answer then it will have smaller or equal size string also
            String substr = s.substring(left, right);
            map.put(substr, map.getOrDefault(substr, 0) + 1);
            left++; right++;
        }

        int maxOccurrences = 0;
        for (String substr : map.keySet()){
            int count = map.get(substr);

            if (count>maxOccurrences && isValidSubstring(substr, maxLetters)){
                maxOccurrences = count;
            }
        }

        return maxOccurrences;
    }

    public static boolean isValidSubstring(String substr, int maxLetters){
        HashSet<Character> counts = new HashSet<>();

        for(int i=0 ; i<substr.length() ; i++){
            char c = substr.charAt(i);
            counts.add(c);
        }

        return counts.size() <= maxLetters;
    }
}
