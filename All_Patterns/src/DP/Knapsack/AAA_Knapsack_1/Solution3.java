package DP.Knapsack.AAA_Knapsack_1;
import java.util.*;

/**
 * Date: 04-07-2025
 * Time complexity: O(N * W)
 * Space complexity: O(N * W)
 */

public class Solution3 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int W = sc.nextInt();

        int[] weights = new int[n];
        long[] values = new long[n];

        for(int i=0 ; i<n ; i++){
            weights[i] = sc.nextInt();
            values[i] = sc.nextLong();
        }

        // row => weight[horizontal arrangement], column => n[vertical]
        long[][] dp = new long[n+1][W+1];

        // initialization with base case condition
        for(int w=0 ; w<=W ; w++) dp[0][w] = 0;
        for(int i=0 ; i<=n ; i++) dp[i][0] = 0;

        // Bottom-up DP
        for(int i=1 ; i<=n ; i++){  // Object
            for(int w=0 ; w<=W ; w++){  // weight
                if(weights[i-1] <= w){
                    dp[i][w] = Math.max(values[i-1]+dp[i-1][w-weights[i-1]], dp[i-1][w]); // value of item + leftover best or leave it
                }else{
                    dp[i][w] = dp[i-1][w];
                }
            }
        }

        System.out.println(dp[n][W]);
    }
}

/*

* ****
We will take every object[i] and its weight[j]
For object we choose Object-i and since this is DP, we solve subproblems using all possible capacities as from 0 to W [Weight-j]
If current capacity is greater than or equal to the weight of the current item, then: [We will do it for every object and each variable weight]
If we don’t take this item → take previous value dp[i-1][j]
If we do take it → take value[i-1] + dp[i-1][j - weight[i-1]]
****

****
You're combining: dp[i-1][j - weights[i-1]]
The value of the current item: values[i-1]
The best result you can get using leftover space (j - weight) with previous items
****

| Concept                                   | Meaning                                             |
| ----------------------------------------- | --------------------------------------------------- |
| `i`                                       | Current item (1-based in DP)                        |
| `j`                                       | Current knapsack capacity                           |
| `weights[i-1]`                            | Actual weight of current item                       |
| `dp[i-1][j - weights[i-1]]`               | Best value using previous items with leftover space |
| `values[i-1] + dp[i-1][j - weights[i-1]]` | If we take the item                                 |
| `dp[i-1][j]`                              | If we don't take the item                           |

* */