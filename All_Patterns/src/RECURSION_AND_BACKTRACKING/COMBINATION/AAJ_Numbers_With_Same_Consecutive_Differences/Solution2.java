package RECURSION_AND_BACKTRACKING.COMBINATION.AAJ_Numbers_With_Same_Consecutive_Differences;

import java.util.*;

/**
 * Question link:
 * Date: 21-07-2025
 * Time complexity:
 * Space complexity:
 */

public class Solution2 {
    public int[] numsSameConsecDiff(int n, int k){
        List<Integer> result = new ArrayList<>();

        for(int i=1 ; i<10 ; i++){
            dfs(n, k, i, 1, result);
        }

        int[] answer = new int[result.size()];
        for(int i=0 ; i<result.size() ; i++){
            answer[i] = result.get(i);
        }

        return answer;
    }

    private void dfs(int n, int k, int currNum, int depth, List<Integer> result){
        if(depth == n){
            result.add(currNum);
            return;
        }

        int lastDigit = currNum%10;

        if(lastDigit+k < 10){
            dfs(n, k, currNum*10+(lastDigit+k), depth+1, result);
        }

        if(k!=0 && lastDigit-k>=0){
            dfs(n, k, currNum*10+(lastDigit-k), depth+1, result);
        }
    }
}