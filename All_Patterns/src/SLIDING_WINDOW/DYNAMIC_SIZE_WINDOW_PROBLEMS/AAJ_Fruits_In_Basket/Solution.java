package SLIDING_WINDOW.DYNAMIC_SIZE_WINDOW_PROBLEMS.AAJ_Fruits_In_Basket;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Question link: https://leetcode.com/problems/fruit-into-baskets/description/
 * Date: 20-06-2025
 * Time complexity: O(n) — each element is visited at most twice
 * Space complexity: O(1) — at most 3 keys in the map (since only 2 baskets)
 */

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of fruits: ");
        int n = sc.nextInt();
        int[] fruits = new int[n];

        System.out.print("Enter fruit types (as integers): ");
        for (int i = 0; i < n; i++) {
            fruits[i] = sc.nextInt();
        }

        Solution obj = new Solution();
        int result = obj.totalFruit(fruits);
        System.out.println("Max number of fruits in 2 baskets: " + result);

        sc.close();

    }

    public int totalFruit(int[] fruits) {
        Map<Integer, Integer> freq = new HashMap<>();
        int maxLen = 0;
        int left = 0;

        for(int right=0 ; right<fruits.length ; right++){
            int fruit = fruits[right];
            freq.put(fruit, freq.getOrDefault(fruit, 0) + 1);

            while(freq.size() > 2){
                int leftFruit = fruits[left];
                freq.put(leftFruit, freq.get(leftFruit)-1);

                if(freq.get(leftFruit) == 0){
                    freq.remove(leftFruit);
                }

                left++;
            }

            maxLen = Math.max(maxLen, right-left+1);
        }

        return maxLen;
    }
}