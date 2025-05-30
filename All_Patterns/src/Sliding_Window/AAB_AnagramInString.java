package Sliding_Window;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
*
* */

public class AAB_AnagramInString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter s: ");
        String s = sc.nextLine();

        System.out.print("Enter p: ");
        String p = sc.nextLine();

        List<Integer> result = new ArrayList<>();
        if(s==null || p==null || s.length() < p.length()){
            System.out.print("result: " + result);
            return;
        }

        int[] freq = new int[26];

        for(char ch: p.toCharArray()){
            freq[ch-'a']++;
        }

        int left=0, right=0;
        int windowSize = p.length();
        int len = s.length();
        int remainingChars = windowSize;

        while(right < len){
            if(freq[s.charAt(right)-'a'] > 0){      // decrease count only if char at right is in p
                remainingChars--;
            }

            freq[s.charAt(right)-'a']--;            // decreasing next character frequency coming in window
            right++;

            if(remainingChars == 0){
                result.add(left);
            }

            if(right-left == windowSize){
                if(freq[s.charAt(left)-'a'] >= 0){  // if the left char is part of p, increase count
                    remainingChars++;
                }

                freq[s.charAt(left)-'a']++;     // restore the frequency of the left character
                left++;
            }
        }

        System.out.print("result: " + result);
    }
}
