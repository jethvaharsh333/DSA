package Sliding_Window.FIXED_SIZE_WINDOW_PROBLEMS.AAD_Check_String_Contain_ALL_Binary_Codes_k;

import java.util.Scanner;

/*
* https://leetcode.com/problems/check-if-a-string-contains-all-binary-codes-of-size-k/description/
* */

public class Solution1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter string: ");
        String s1 = sc.nextLine();

        System.out.print("Enter k: ");
        int k = sc.nextInt();

        Boolean ans = hasAllCodes(s1, k);
        System.out.println(ans);
    }

    public static boolean hasAllCodes(String s, int k) {
        if (s.length() < k) return false;

        int size = 1 << k; // 2^k
        boolean[] arr = new boolean[size];
        int len = s.length();

        StringBuilder sb = new StringBuilder();
        sb.append(s.substring(0,k));

        int index = binaryToDecimal(sb, k);
        arr[index] = true;

        for(int i=k ; i<len ; i++){
            sb.deleteCharAt(0);
            sb.append(s.charAt(i));
            index = binaryToDecimal(sb, k);
            arr[index] = true;
        }

        for(int i=0 ; i<size ; i++){
            if(arr[i] == false){
                return false;
            }
        }

        return true;
    }

    public static int binaryToDecimal(StringBuilder sb, int k){
        int sum = 0;

        for(int i=0 ; i<k ; i++){
            sum += (sb.charAt(i) - '0') * (1 << (k-i-1));
        }

        return sum;
    }

}
