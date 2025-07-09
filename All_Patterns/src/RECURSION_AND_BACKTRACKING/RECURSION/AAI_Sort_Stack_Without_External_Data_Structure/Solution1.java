package RECURSION_AND_BACKTRACKING.RECURSION.AAI_Sort_Stack_Without_External_Data_Structure;

import java.util.*;

/**
 * Question link: https://www.geeksforgeeks.org/problems/sort-a-stack/1
 * Date: 02-07-2025
 * Time complexity:
 * Space complexity:
 */

public class Solution1 {
    public static void sortedInsert(Stack<Integer> s, int x) {
        if (s.isEmpty() || x > s.peek()) {
            s.push(x);
            return;
        }
        int temp = s.pop();
        sortedInsert(s, x);
        s.push(temp);
    }

    public Stack<Integer> sort(Stack<Integer> s) {
        // add code here.
        if (!s.isEmpty()) {
            int x = s.pop();
            sort(s);
            sortedInsert(s, x);
        }

        return s;
    }
}

/*

| RECURSIVE CALLS                | ACTION / STACK STATE                        | COMMENT                |
| ------------------------------ | ------------------------------------------- | ---------------------- |
| `sort([41, 3, 32, 2])`         | pop 2, call `sort([41, 3, 32])`             | Start                  |
| `sort([41, 3, 32])`            | pop 32, call `sort([41, 3])`                |                        |
| `sort([41, 3])`                | pop 3, call `sort([41])`                    |                        |
| `sort([41])`                   | pop 41, call `sort([])`                     | base case hit          |
| `sort([])`                     | return (stack is empty)                     | base done              |
| ← backtrack: push 41           | call `sortedInsert([], 41)`                 | push directly          |
| → stack: `[41]`                | returned to previous level                  |                        |
| `sortedInsert([41], 3)`        | 3 < 41 → pop 41, call `sortedInsert([], 3)` | need to insert smaller |
| `sortedInsert([], 3)`          | stack empty → push 3                        | base insert            |
| ← backtrack: push 41           | → stack becomes `[41, 3]`                   |                        |
| → stack after `sortedInsert`   | `[41, 3]`                                   |                        |
| `sortedInsert([41, 3], 32)`    | 32 < 3 → pop 3, recurse                     | go deeper              |
| `sortedInsert([41], 32)`       | 32 < 41 → pop 41, recurse                   | go deeper              |
| `sortedInsert([], 32)`         | empty → push 32                             | base case              |
| ← backtrack: push 41           | stack → `[41, 32]`                          |                        |
| ← backtrack: push 3            | stack → `[41, 32, 3]`                       |                        |
| → after `sortedInsert`         | `[41, 32, 3]`                               |                        |
| `sortedInsert([41, 32, 3], 2)` | 2 < 3 → pop 3                               |                        |
| `sortedInsert([41, 32], 2)`    | 2 < 32 → pop 32                             |                        |
| `sortedInsert([41], 2)`        | 2 < 41 → pop 41                             |                        |
| `sortedInsert([], 2)`          | empty → push 2                              | base                   |
| ← push 41, then 32, then 3     | stack becomes `[41, 32, 3, 2]`              | final                  |


* */