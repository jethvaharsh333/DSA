package SLIDING_WINDOW.FIXED_SIZE_WINDOW_PROBLEMS.AAC_Permutation_In_String;
/*
* https://leetcode.com/problems/permutation-in-string
* */

import java.util.Scanner;

public class Solution1 {
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

        StringBuilder sb = new StringBuilder();

        for(int i=0 ; i<l1 ; i++){
            sb.append(s2.charAt(i));
        }

        if(isInPermutation(s1, sb, l1, 0)){
            return true;
        }

        for(int i=l1 ; i<l2 ; i++){
            sb.deleteCharAt(0);
            sb.append(s2.charAt(i));
            if(isInPermutation(s1, sb, l1, 0)){
                return true;
            }
        }

        return false;
    }

    public static boolean isInPermutation(String s1, StringBuilder sb, int len, int start){
        if(start == len){
            return sb.toString().equals(s1);
        }

        for(int i=start ; i<len ; i++){
            swap(i, start, sb);
            if(isInPermutation(s1, sb, len, start+1)){
                return true;
            }
            swap(i, start, sb);
        }

        return false;
    }

    public static void swap(int i1, int i2, StringBuilder sb){
        char temp = sb.charAt(i1);
        sb.setCharAt(i1, sb.charAt(i2));
        sb.setCharAt(i2, temp);
    }
}
