package Sliding_Window.FIXED_SIZE_WINDOW_PROBLEMS.AAE_Max_No_of_Vowels_In_SubString;

import java.util.Scanner;

/*
* https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length/
* */
public class Solution1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter String: ");
        String s = sc.nextLine();

        System.out.println("Enter k: ");
        int k = sc.nextInt();

        int ans = maxVowels(s, k);
        System.out.println(ans);
    }

    public static int maxVowels(String s, int k){
        int len = s.length();
        StringBuilder sb = new StringBuilder(s.substring(0,k));
        int maxCount = 0;
        int consecutiveCount = 0;

        for(int i=0; i<k ; i++){
            if(isVowel(sb.charAt(i))){
                consecutiveCount++;
            }
        }

        maxCount = consecutiveCount;

        for(int i=k; i<len ; i++){
            if(isVowel(sb.charAt(0))){
                consecutiveCount--;
            }

            sb.deleteCharAt(0);

            char ch = s.charAt(i);
            sb.append(ch);
            if(isVowel(ch)){
                consecutiveCount++;
            }

            maxCount = Math.max(maxCount, consecutiveCount);
        }

        return maxCount;
    }

    public static boolean isVowel(char ch){
        if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u'){
            return true;
        }

        return false;
    }
}
