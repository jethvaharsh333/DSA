package Sliding_Window.FIXED_SIZE_WINDOW_PROBLEMS.AAE_Max_No_of_Vowels_In_SubString;

import java.util.Scanner;

public class Solution2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter String: ");
        String s = sc.nextLine();

        System.out.println("Enter k: ");
        int k = sc.nextInt();

        int ans = maxVowels(s, k);
        System.out.println("MaxCount: " + ans);
    }

    public static int maxVowels(String s, int k) {
        int[] arr = new int[26];
        arr['a'-'a'] = 1;
        arr['e'-'a'] = 1;
        arr['i'-'a'] = 1;
        arr['o'-'a'] = 1;
        arr['u'-'a'] = 1;

        int maxVowCount=0, currVowCount=0;

        for(int i=0 ; i<s.length() ; i++){
            currVowCount += arr[s.charAt(i)-'a'];

            if(i>=k){
                currVowCount -= arr[s.charAt(i-k)-'a'];
            }

            maxVowCount = Math.max(maxVowCount, currVowCount);
        }

        return maxVowCount;
    }
}
