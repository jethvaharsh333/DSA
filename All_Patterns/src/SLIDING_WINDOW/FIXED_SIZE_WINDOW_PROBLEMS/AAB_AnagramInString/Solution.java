package SLIDING_WINDOW.FIXED_SIZE_WINDOW_PROBLEMS.AAB_AnagramInString;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
* https://leetcode.com/problems/find-all-anagrams-in-a-string/
* TC: O(n+m), SC: O(1)
* */

public class Solution {
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

/*
s = "cbaebabacd", p = "abc"

| Step | `left` | `right` | Window | freq (`a`/`b`/`c`) | `remainingChars` | Action                   | `result` |
| ---- | ------ | ------- | ------ | ------------------ | ---------------- | ------------------------ | -------- |
| 1    | 0      | 0       | `c`    | a:1 b:1 c:0        | 2                | `c` in p, freq--         | \[]      |
| 2    | 0      | 1       | `cb`   | a:1 b:0 c:0        | 1                | `b` in p, freq--         | \[]      |
| 3    | 0      | 2       | `cba`  | a:0 b:0 c:0        | 0                | `a` in p, freq-- → MATCH | \[0]     |
| 4    | 1      | 3       | `bae`  | a:0 b:0 c:1        | 1                | `e` not in p, `c` freq++ | \[0]     |
| 5    | 2      | 4       | `aeb`  | a:0 b:0 c:1        | 1                | `b` in p, freq--         | \[0]     |
| 6    | 3      | 5       | `eba`  | a:0 b:-1 c:1       | 1                | `a` in p, freq--         | \[0]     |
| 7    | 4      | 6       | `bab`  | a:1 b:-1 c:1       | 1                | `b` in p, freq--         | \[0]     |
| 8    | 5      | 7       | `aba`  | a:0 b:0 c:1        | 1                | `a` in p, freq--         | \[0]     |
| 9    | 6      | 8       | `bac`  | a:0 b:0 c:0        | 0                | `c` in p, freq-- → MATCH | \[0, 6]  |
| 10   | 7      | 9       | `acd`  | a:0 b:1 c:0        | 1                | `d` not in p, `b` freq++ | \[0, 6]  |

*/
