package RECURSION_AND_BACKTRACKING.PERMUTATION.AAB_Construct_Smallest_Number_From_DI_String;

import java.util.*;

/**
 * Question link:
 * Date: 17-07-2025
 * Time complexity:
 * Space complexity:
 */

public class Solution {
    public String smallestNumber(String pattern) {
        StringBuilder answer = new StringBuilder();
        boolean[] visited = new boolean[10];
        recurse(0, pattern, answer, visited);
        return answer.toString();
    }

    private boolean recurse(int idx, String pattern, StringBuilder answer, boolean[] visited){
        if(pattern.length()+1 == answer.length()){
            return true;
        }

        for(int digit=1 ; digit<=9 ; digit++){
            if (visited[digit]) continue;

            if(idx > 0){
                char prevChar = answer.charAt(answer.length()-1);
                char patternChar = pattern.charAt(idx-1);

                if(patternChar=='I' && prevChar-'0'>=digit) continue;
                if(patternChar=='D' && prevChar-'0'<=digit) continue;
            }

            visited[digit] = true;
            answer.append(digit);

            if (recurse(idx+1, pattern, answer, visited))
                return true;

            answer.deleteCharAt(answer.length() - 1);
            visited[digit] = false;
        }

        return false;
    }
}