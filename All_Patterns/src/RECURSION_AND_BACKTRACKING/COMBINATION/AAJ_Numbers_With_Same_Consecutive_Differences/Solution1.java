package RECURSION_AND_BACKTRACKING.COMBINATION.AAJ_Numbers_With_Same_Consecutive_Differences;

import java.util.*;

/**
 * Question link: https://leetcode.com/problems/numbers-with-same-consecutive-differences
 * Date: 19-07-2025
 * Time complexity:
 * Space complexity:
 */

public class Solution1 {
    public int[] numsSameConsecDiff(int n, int k) {
        List<Integer> result = new ArrayList<>();

        for(int i=1 ; i<10 ; i++){
            List<Integer> current = new ArrayList<>();
            current.add(i);
            recurse(n, k, current, result);
        }

        int size = result.size();
        int[] arr = new int[size];
        for(int i=0 ; i<size ; i++){
            arr[i] = result.get(i);
        }

        return arr;
    }

    private void recurse(int n, int k, List<Integer> current, List<Integer> result){
        if(current.size() == n){
            int num = 0;
            for(int x: current){
                num *= 10;
                num += x;
            }

            result.add(num);
            return;
        }

        int lastDigit = current.get(current.size()-1);

        if(lastDigit-k >= 0){
            current.add(lastDigit-k);
            recurse(n, k, current, result);
            current.remove(current.size()-1);
        }

        if(k!=0 && lastDigit+k<10){
            current.add(lastDigit+k);
            recurse(n, k, current, result);
            current.remove(current.size()-1);
        }
    }
}