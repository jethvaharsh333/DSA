# Subproblem ki Rasleela

  

Parent Folder: DSA (https://www.notion.so/DSA-253f4330985e806c8d7bfac6ef2fd8c5?pvs=21)

Last Edited Time: August 20, 2025 6:18 AM

  

<aside>

  

## :my-salute: **TOP SECRET**

  

</aside>

  

### Strategy

  

- Just start with backward recursion. Then do memoization from that backward recursion. Now optimize it with forward dp.

- This strategy works always as mostly we will use same base case.

- Priciple

    - As we know in **backward recursion, we always reduce the problem** (n → n-1, n-2).

    - In **forward DP, we build solutions step by step** (0 → n).

    - Both are the same recurrence, just different directions.

  

### `n` or `n+1` size dp

  

If the problem **asks you to reach beyond the last index** (like “step n”), → **`n+1` dp size**.

If the problem **ends exactly at the last index** (like min-cost where `cost` stops at `n-1`), → **`n` dp size**.

  

### `n+1` size

  

We use `dp = new int[n+1]` **when our state includes one extra position beyond the given input size**.

When we use **`n+1`:**

  

- Input: `n` = number of steps to reach the **top**.

- But the top is at index `n` (not `n-1` like an array).

- We need `dp[0..n]` → total `n+1` entries.

  

```

dp[i] = ways to reach step i

answer = dp[n]

```

  

**Reason:** The “top” is a *virtual extra step* beyond the last actual step.

  

### `n` size

  

When we use **`n`:**

  

- Input: `cost[0..n-1]` = actual steps.

- The “top” is virtual and has **no cost**.

- So we only store up to step `n-1`.

- Answer = `min(dp[n-1], dp[n-2])`.

  

```java

dp[i] = min cost to reach step i

answer = Math.min(dp[n-1], dp[n-2])

```

  

**Reason:** We don’t need `dp[n]` because cost array ends at `n-1`.

  

---

  

<aside>

  

## ♂️ **QUESTIONS**

  

</aside>

  

### 70. Climbing Stairs [🔗](https://leetcode.com/problems/climbing-stairs/)

  

- Climbing a staircase. It takes `n` steps to reach the top. Each time you can either climb `1` or `2` steps. In how many distinct ways can you climb to the top? Just visualize it like nodes in tree and connet the dotes.

- So it’s confirm we have to reach the last step [i.e. just cannot jump from the last second ladder].

- Thinking of base case and counting reach to last ladder … and when our function goes to last ladder return 1 which will add as one of the possibility of way to climb whole stair.

  

```java

// APPROACH 1

class Solution {

    public int climbStairs(int n) {

        if(n < 0) return 0;        // if steps beyond itr. means we aren't able to reach the last ladder .. not included in answer

        if(n == 0) return 1;       // successfully reach the last ladder

        // or if(n <= 1) return 1;

        int pick = climbStairs(n-1);

        int noPick = climbStairs(n-2);

  

        return pick+noPick;        // count all the possibility

    }

}

  

```

  

```java

// APPROACH 2

class Solution {

    public int climbStairs(int n) {

        int[] dp = new int[n+1];

        for(int i=0 ; i<n+1 ; i++){

            dp[i] = -1;

        }

  

        return climb(n, dp);

    }

  

    private int climb(int n, int[] dp){

        if(n <= 1) return 1;

  

        if(dp[n] != -1) return dp[n];

  

        int oneStep = climb(n-1, dp);

        int twoStep = climb(n-2, dp);

        dp[n] = oneStep + twoStep;

  

        return dp[n];

    }

}

```

  

```java

// APPROACH 3

class Solution {

    public int climbStairs(int n) {

        if (n <= 1) return 1;

  

        int[] dp = new int[n+1];    // dp[i] = the number of distinct ways to reach step i.

        dp[0] = 1;  // base: 1 way to stand at start

        dp[1] = 1;  // one way to reach step 1.

  

        for(int i=2 ; i<=n ; i++){

            dp[i] = dp[i-1] + dp[i-2];

        }

  

        return dp[n];

    }

}

```

  

### 746. Min Cost **Climbing Stairs** [🔗](https://leetcode.com/problems/min-cost-climbing-stairs/)

  

- You are given an integer array `cost` where `cost[i]` is the cost of `ith` step on a staircase. Once you pay the cost, you can either climb one or two steps. You can either start from the step with index `0`, or the step with index `1`. Return *the minimum cost to reach the top of the floor*.

- Here as we can see we have to reach at the `last` or `last second` step **and** we can start from either `first` or `second` step of the ladder **and**   `MIN COST`.

- The base case forms as of this 3 points.

  

```java

class Solution {

    public int minCostClimbingStairs(int[] cost) {

        int n = cost.length;

        return Math.min(minCost(cost, n-1), minCost(cost, n-2));   // We can reach at top either at last or last second step.

    }

  

    private int minCost(int[] cost, int i){

        if(i <= 1) return cost[i];      // BASE CASE: We can start either from 1st or 2nd step.

  

        int oneStep = minCost(cost, i-1);

        int twoStep = minCost(cost, i-2);

  

        return cost[i] + Math.min(oneStep, twoStep);   // add current cost with what we got min cost out of 2 possibility at each lvl

    }

}

```

  

```java

class Solution {

    public int minCostClimbingStairs(int[] cost) {

        int n = cost.length;

        int[] dp = new int[n+1];

        Arrays.fill(dp, -1);

        return Math.min(minCost(cost, n-1, dp), minCost(cost, n-2, dp));

    }

  

    private int minCost(int[] cost, int i, int[] dp){

        if(i <= 1) return cost[i];

        if(dp[i] != -1) return dp[i];

  

        int oneStep = minCost(cost, i-1, dp);

        int twoStep = minCost(cost, i-2, dp);

  

        dp[i] = cost[i] + Math.min(oneStep, twoStep);

        return dp[i];

    }

}

```

  

```java

class Solution {

    public int minCostClimbingStairs(int[] cost) {

        int n = cost.length;

        if(n < 2) return Math.min(cost[0], cost[1]);

  

        int[] dp = new int[n];      // dp[i] = min cost to reach step i

        dp[0] = cost[0];      // BASE CASE

        dp[1] = cost[1];      // BASE CASE

  

        for(int i=2 ; i<n ; i++){

            dp[i] = Math.min(dp[i-1], dp[i-2]) + cost[i];

        }

  

        return Math.min(dp[n-1], dp[n-2]);    // We can reach at top either at last or last second step.

    }

}

```

  

### **279. Perfect Squares** [🔗](https://leetcode.com/problems/perfect-squares/)

  

- Given an integer `n`, return *the least number of perfect square numbers that sum to* `n`.  A **perfect square** is an integer that is the square of an integer; in other words, it is the product of some integer with itself.

  

```

Example 1**:**

  

Input: n = 12

Output: 3

Explanation: 12 = 4 + 4 + 4.

  

Example 2:

  

Input: n = 13

Output: 2

Explanation: 13 = 4 + 9.

```

  

- First i think from optimized like to get max number out of which we can subtract. But as per problem solving just start from start 1 and go upto `i*i ≤ n`.

- Again that simple concept for counting adding 1 to the computed function.

- And again that computed function looks as reducing the parameter by condition satisfied. Here, perfect square.

- And base case will be for `n==0` returning `0` . Inspired by common sense.

  

```java

class Solution {

    public int numSquares(int n) {

        return count(n);

    }

  

    private int count(int n){

        if(n == 0) return 0; // If n==0 means count least no. of perfect squares where sum=0.

  

        int ans = Integer.MAX_VALUE;   // It's task is to save the last best least no. of perfect squares where sum=0.

        for(int i=1 ; i*i<=n ; i++){    // as i*i<=n we don't need other base case for n < 0

            ans = Math.min(ans, 1 + count(n-i*i));  

            // Each time subtracting square from it.

            // Meaning we will get least no. of squares possiblity from count(n-i*i) and add 1 saying count current psooibity also.

        }

  

        return ans;

    }

}

  

// Input : 16

// one of the 4 possibilties of getting sum 16

  

// 1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1 = 16 => 16

// 1+1+1+1+4+4+4 = 16 => 7

// 4+4+4+4 = 16 => 4

// 16 => 1

  

// Output : 1

```

  

```java

class Solution {

    public int numSquares(int n) {

        int[] dp = new int[n+1];

        Arrays.fill(dp, -1);

  

        return count(n, dp);

    }

  

    private int count(int n, int[] dp){

        if(n == 0) return 0;

        if(dp[n] != -1) return dp[n];

  

        int ans = Integer.MAX_VALUE;

        for(int i=1 ; i*i<=n ; i++){

            ans = Math.min(ans, 1 + count(n-i*i, dp));  

        }

  

        dp[n] = ans;

        return dp[n];

    }

}

```

  

```java

class Solution {

    public int numSquares(int n) {

        int[] dp = new int[n+1];

        dp[0] = 0;

  

        for(int i=1 ; i<=n ; i++){

            int min = Integer.MAX_VALUE;

  

            for(int j=1 ; j*j<=i ; j++){

                min = Math.min(min, 1 + dp[i - j*j]);

            }

  

            dp[i] = min;

        }

  

        return dp[n];

    }

}

```

  

### 91. Decode Ways [🔗](https://leetcode.com/problems/decode-ways/description/)

  

- You have intercepted a secret message encoded as a string of numbers. The message is **decoded** via the following mapping: “1”→A, … , “26”→Z. However, while decoding the message, you realize that there are many different ways you can decode the message because some codes are contained in other codes (`"2"` and `"5"` vs `"25"`).

- For example, `"11106"` can be decoded into:

    - `"AAJF"` with the grouping `(1, 1, 10, 6)`

    - `"KJF"` with the grouping `(11, 10, 6)`

    - The grouping `(1, 11, 06)` is invalid because `"06"` is not a valid code (only `"6"` is valid).

- Note: there may be strings that are impossible to decode.

- Thinking: Decode Ways ⇒ Ways → Counting → Adding 1.

    - Base case :-

        - 1st scenario (backward) : Just return 1 if we reach successfully to the end of string.

        - 2nd scenario (forward) : For `empty string` there is `1` way to decode it unfortunately and for `1 length string` checking if first digit is `0` then `0` way else `1` way.

    - Logic :-

        - Now just jump to next itr for  as `i+1` for `1 digit number` checking all possible inside it and `ADD` with other possibilty of `2 digit number` as `i+2` for which we have to check proper indexing and the number between (1 or 10) to 26.

  

```java

class Solution {

    public int numDecodings(String s) {

        return count(s, 0, s.length());

    }

  

    private int count(String s, int i, int len){

        if(i == len) return 1;

        if(s.charAt(i) == '0') return 0;

  

        int step1 = count(s, i+1, len);

        int step2 = 0;

  

        if(i < len-1){

            int num = (s.charAt(i)-'0')*10 + s.charAt(i+1)-'0';

            if(num > 0 && num < 27){

                step2 = count(s, i+2, len);

            }

        }

  

        return step1 + step2;

    }

}

```

  

```java

class Solution {

    public int numDecodings(String s) {

        int len = s.length();

        int[] dp = new int[len];

        Arrays.fill(dp, -1);

  

        return count(s, 0, len, dp);

    }

  

    private int count(String s, int i, int len, int[] dp){

        if(i == len) return 1;

        if(dp[i] != -1) return dp[i];

        if(s.charAt(i) == '0') return 0;

  

        int step1 = count(s, i+1, len, dp);

        int step2 = 0;

  

        if(i < len-1){

            int num = (s.charAt(i)-'0')*10 + s.charAt(i+1)-'0';

            if(num > 0 && num < 27){

                step2 = count(s, i+2, len, dp);

            }

        }

  

        dp[i] = step1 + step2;

        return dp[i];

    }

}

```

  

```java

class Solution {

    public int numDecodings(String s) {

        int n = s.length();

        int[] dp = new int[n+1];

        dp[n] = 1;

  

        for(int i=n-1 ; i>=0 ; i--){

            if(s.charAt(i) == '0'){

                dp[i] = 0;

            }

            else{

                dp[i] = dp[i+1];

                if(i < n-1){

                    int num = (s.charAt(i)-'0')*10 + (s.charAt(i+1)-'0');

                    if(num > 9 && num < 27){

                        dp[i] += dp[i+2];

                    }

                }

            }

  

        }

  

        return dp[0];

    }

}

```

  

```java

class Solution {

    public int numDecodings(String s) {

        int n = s.length();

        int[] dp = new int[n+1];  

  

        dp[0] = 1;  // Empty string has 1 way

        dp[1] = (s.charAt(0) != '0') ? 1 : 0; // First char valid or not

  

        for(int i=2 ; i<=n ; i++){

            // one digit (s[i-1])

            if(s.charAt(i-1) != '0'){

                dp[i] += dp[i-1];

            }

  

            // two digits (s[i-2..i-1])

            int num = (s.charAt(i-2)-'0')*10 + (s.charAt(i-1)-'0');

            if(num>9 && num<27){

                dp[i] += dp[i-2];

            }

        }

  

        return dp[n];

    }

}

  

/*

  

s = "12"

  

dp[0] = 1 (empty string → 1 way).

  

At i=1 ("1"): you can decode '1' → dp[1] = 1 * dp[0] = 1.

  

At i=2 ("12"): you can decode '2' (extend "1") OR decode "12" (extend empty).

→ dp[2] = dp[1] + dp[0] = 1 + 1 = 2.

  

*/

```

  

### **96. Unique Binary Search Trees** [🔗](https://leetcode.com/problems/unique-binary-search-trees/description/)

  

- Given an integer `n`, return *the number of structurally unique **BST'**s (binary search trees) which has exactly* `n` *nodes of unique values from* `1` *to* `n`. Example 1:- Input: n=3 Output: 5, Example 2:- Input: n=1 Output: 1.

-