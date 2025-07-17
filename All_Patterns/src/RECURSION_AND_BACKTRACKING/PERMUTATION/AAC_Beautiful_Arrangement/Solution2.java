package RECURSION_AND_BACKTRACKING.PERMUTATION.AAC_Beautiful_Arrangement;

import java.util.*;

/**
 * Question link:
 * Date: 17-07-2025
 * Time complexity:
 * Space complexity:
 */

public class Solution2 {
    int count = 0;

    public int countArrangement(int n) {
        boolean[] visited = new boolean[n + 1];
        backtrack(1, n, visited);
        return count;
    }

    void backtrack(int pos, int n, boolean[] visited) {
        if (pos > n) {
            count++;
            return;
        }

        for (int num = 1; num <= n; num++) {
            if (!visited[num] && (num % pos == 0 || pos % num == 0)) {
                visited[num] = true;
                backtrack(pos + 1, n, visited);
                visited[num] = false;
            }
        }
    }
}