package Sliding_Window.FIXED_SIZE_WINDOW_PROBLEMS.AAC_Permutation_In_String;

import java.util.Scanner;

public class Solution2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter 1st string: ");
        String s1 = sc.nextLine();

        System.out.print("Enter 2nd string: ");
        String s2 = sc.nextLine();

        s1 = s1.toLowerCase();
        s2 = s2.toLowerCase();

        Boolean ans = checkInclusion(s1, s2);
        System.out.println(ans);
    }

    public static boolean checkInclusion(String s1, String s2) {
        int l1=s1.length(), l2=s2.length();
        if(l1 > l2) return false;

        int[] freq = new int[26];

        for (char c : s1.toCharArray()) {
            freq[c - 'a']++;
        }

        int l=0, r=0;
        int remainingChar = l1;

        while(r < l2){
            if(freq[s2.charAt(r) - 'a'] > 0){
                remainingChar--;
            }

            freq[s2.charAt(r) - 'a']--;
            r++;

            if(remainingChar == 0){
                return true;
            }

            if(r-l == l1){
                if(freq[s2.charAt(l) - 'a'] >= 0){
                    remainingChar++;
                }

                freq[s2.charAt(l) - 'a']++;
                l++;
            }
        }

        return false;
    }

}
