package Priority_Queue.Miscellaneous.AAA_Max_Value_Of_Eq;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read number of points
        int n = sc.nextInt();

        // Read k value
        int k = sc.nextInt();

        // Read points array
        int[][] points = new int[n][2];
        for (int i = 0; i < n; i++) {
            points[i][0] = sc.nextInt(); // xi
            points[i][1] = sc.nextInt(); // yi
        }

        int result = findMaxValueOfEquation(points, k);
        System.out.println("Maximum value of equation: " + result);

        sc.close();
    }

    public static int findMaxValueOfEquation(int[][] points, int k) {
        int result = Integer.MIN_VALUE;

        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
                (a, b) -> b[0] - a[0]
        );

        for (int[] point : points) {
            int x = point[0];
            int y = point[1];

            while (!maxHeap.isEmpty() && x - maxHeap.peek()[1] > k) {
                maxHeap.poll();
            }

            if (!maxHeap.isEmpty()) {
                int[] top = maxHeap.peek();  // (yi - xi, xi)
                int value = y + x + top[0];  // (yj + xj) + (yi - xi)
                result = Math.max(result, value);
            }

            maxHeap.offer(new int[]{y-x, x});
        }

        return result;
    }
}

/*
    yi + yj + (xj - xi) = (yi - xi) + (yj + xj)

    | Condition      | Meaning                 | Action         |
    | -------------- | ----------------------- | -------------- |
    | xj - xi <= k   | Within allowed distance | Keep in heap   |
    | xj - xi > k    | Too far apart → invalid | Remove         |

    You can't check all pairs — there can be up to 100,000 points
    Need to find the maximum, while keeping the distance between x's ≤ k
    So you're saying: "Give me the previous point i with the largest (yi - xi), but only if xi is not too far from xj."

    (y - x, x)
    y - x = yi - xi → the part you want to maximize
    x = xi → needed to check xj - xi <= k

    Steps:
    1) You're at a new point (xj, yj)
    2) You remove old points from the heap where xj - xi > k
    3) If heap is not empty:
        Take the top (yi - xi)
        Add to yj + xj
        Update the answer
    4) Add (yj - xj, xj) to the heap → now this point becomes "past" for next ones



    example:  points = [[1,3], [2,0], [3,4], [5,1]], k = 3

    Iteration 1: Point (1, 3)
    Heap is empty → nothing to compute
    Add (3 - 1 = 2, 1) → Heap = [(2,1)]

    Iteration 2: Point (2, 0)
    x = 2, x - xi = 1 (valid)
    Best yi - xi = 2 → compute 0 + 2 + 2 = 4
    max = 4
    Add (0 - 2 = -2, 2) → Heap = [(2,1), (-2,2)]

    Iteration 3: Point (3, 4)
    x = 3, x - xi = 2 (both points valid)
    Best yi - xi = 2 → compute 4 + 3 + 2 = 9
    max = 9
    Add (4 - 3 = 1, 3) → Heap = [(2,1), (-2,2), (1,3)]

    Iteration 4: Point (5, 1)
    Remove (2,1) since 5 - 1 = 4 > k
    Remaining top = 1 → compute 1 + 5 + 1 = 7
    max stays 9
    Add (1 - 5 = -4, 5)

    Final Answer = 9

*/