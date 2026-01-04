package A_Hashing.AAS_First_Unique_Char_in_String;

import java.util.Arrays;
import java.util.Scanner;

public class JA {
    public static void main(String[] args) {
        // INPUT
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        System.out.println(firstUniqueChar(s));
    }

    private static int firstUniqueChar(String s){
        int[] letters = new int[26];

        for(int i=0 ; i<s.length() ; i++){
            int index = s.charAt(i) - 'a';
            letters[index]++;
        }

        for(int i=0 ; i<s.length() ; i++){
            int index = s.charAt(i) - 'a';
            if(letters[index] == 1) return i;
        }

        return -1;
    }
}
