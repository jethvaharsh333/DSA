package RECURSION_AND_BACKTRACKING.COMBINATION.AAI_Maximum_Compatibility_Score_Sum;

/**
 * Question link: https://leetcode.com/problems/maximum-compatibility-score-sum/
 * Date: 19-07-2025
 * Time complexity:
 * Space complexity:
 */

public class Solution1 {
    public int maxCompatibilitySum(int[][] students, int[][] mentors) {
        boolean[] usedMentors = new boolean[mentors.length];
        return backtrack(0, students, mentors, usedMentors);
    }

    private int backtrack(int idx, int[][] students, int[][] mentors, boolean[] usedMentors){
        if(idx == students.length){
            return 0;
        }

        int maxScore = 0;

        for(int i=0 ; i<mentors.length ; i++){
            if(!usedMentors[i]){
                int score = compatibilityScore(students[idx], mentors[i]);
                usedMentors[i] = true;
                maxScore = Math.max(maxScore, score + backtrack(idx+1, students, mentors, usedMentors));
                usedMentors[i] = false;
            }
        }

        return maxScore;
    }

    private int compatibilityScore(int[] student, int[] mentor){
        int score = 0;

        for(int i=0 ; i<student.length ; i++){
            if(student[i] == mentor[i]) score++;
        }

        return score;
    }
}

/*

1. Simple 2-For Loop Approach

# Idea:
for each student:
    for each mentor:
        if mentor not used:
            assign and take score

# Problem:
=> It assigns mentors to students without considering future students.
=> It doesn’t explore all permutations → so it misses better total combinations.

# Example
students = [
  [1, 0],  // S0
  [1, 1],  // S1
  [0, 0]   // S2
]
mentors = [
  [1, 1],  // M0
  [1, 0],  // M1
  [0, 0]   // M2
]

Precompute:
|           | M0 (\[1,1]) | M1 (\[1,0]) | M2 (\[0,0]) |
| --------- | ----------- | ----------- | ----------- |
| S0  [1,0] | 1           | *2          | 0           |
| S1  [1,1] | *2          | 1           | 0           |
| S2  [0,0] | 0           | 1           | *2          |

** If all correct then
Step 1: Assign S0
Best match: M1 (score 2) → ✅ Assign M1 to S0
usedMentors = [false, true, false]

Step 2: Assign S1
Best match: M0 (score 2) → ✅ Assign M0 to S1
usedMentors = [true, true, false]

Step 3: Assign S2
Only M2 is left → S2 → M2 (score = 2) ✅

Total = 2 + 2 + 2 = 6 ✅

** If fails then
Now let's suppose:
    You made a bad choice: S0 → M0 (score 1) instead of M1
    Now S1 takes M1 (score 1)
    S2 gets M2 (score 2)

→ Total = 1 + 1 + 2 = 4 ❌

----------------------------------------------------------

2.Greedy Approach

# Idea:
For each student, assign the best available mentor at that moment.

# Problem:
Greedy looks for best local choice, but doesn’t see the global impact.

=> Once a mentor is assigned, you can’t undo — even if it ruins future scores

# Example
students = [
  [1, 0, 1],  // S0
  [0, 1, 1],  // S1
  [1, 1, 1]   // S2
]
mentors = [
  [1, 0, 0],  // M0
  [0, 1, 1],  // M1
  [1, 1, 1]   // M2
]

Compatibility Scores--
|    | M0 | M1 | M2 |
| -- | -- | -- | -- |
| S0 | 2  | 1  | 2  |
| S1 | 1  | 3  | 2  |
| S2 | 2  | 2  | 3  |

**Greedy Plan:-
=> Student 0:
Best match = M0 or M2 (tie score = 2)
Suppose we choose M0 (arbitrary tie-break)
usedMentors = [true, false, false]

=> Student 1:
Best match = M1 (score = 3) → assign
usedMentors = [true, true, false]

=> Student 2:
Only M2 left → score = 3

Total = 2 + 3 + 3 = 8 ✅

** Different greedy path:-
S0: you choose M2 (also score 2)
usedMentors = [false, false, true]

S1:
Best: M1 (score 3) → assign
usedMentors = [false, true, true]

S2:
Only M0 left → score = 2

Total = 2 + 3 + 2 = 7 ❌ => Bad choice at the beginning ruined the score.

-------------------------------------------------------------------------

HENCE, We want to try every possible way to assign students to mentors and pick the best total score.

*/