// Time Complexity: O(n): generating n ugly numbers with O(1) operations per number, Space Complexity: O(n)
class Solution1 {
    public int nthUglyNumber(int n) {
        int[] dp = new int[n];
        dp[0] = 1;                      // The first ugly number is 1
        
        int i2=0, i3=0, i5=0;           // Pointers for multiples of 2, 3, and 5
        int next2=2, next3=3, next5=5;  // Next multiples
        
        for(int i=1 ; i<n ; i++){
            int nextUgly = Math.min(next2, Math.min(next3, next5));
            dp[i] = nextUgly;

            if(nextUgly == next2){
                i2++;
                next2 = dp[i2]*2;
            }

            if(nextUgly == next3){
                i3++;
                next3 = dp[i3]*3;
            }

            if(nextUgly == next5){
                i5++;
                next5 = dp[i5]*5;
            }
        }

        return dp[n-1];
    }
}

/*

Here’s a simplified version of the simulation for n=8:

***** Initial Setup
dp = [1] (list of ugly numbers so far).
Pointers: i2 = 0, i3 = 0, i5 = 0.
Next candidates:
next2 = dp[i2] * 2 = 1 * 2 = 2
next3 = dp[i3] * 3 = 1 * 3 = 3
next5 = dp[i5] * 5 = 1 * 5 = 5

**** Steps
1] Smallest is 2:
Add to dp: dp = [1, 2]
Move i2 = 1: next2 = dp[1] * 2 = 2 * 2 = 4

2]Smallest is 3:
Add to dp: dp = [1, 2, 3]
Move i3 = 1: next3 = dp[1] * 3 = 2 * 3 = 6

3]Smallest is 4:
Add to dp: dp = [1, 2, 3, 4]
Move i2 = 2: next2 = dp[2] * 2 = 3 * 2 = 6

4]Smallest is 5:
Add to dp: dp = [1, 2, 3, 4, 5]
Move i5 = 1: next5 = dp[1] * 5 = 2 * 5 = 10

5]Smallest is 6:
Add to dp: dp = [1, 2, 3, 4, 5, 6]
Update both i2 and i3:
i2 = 3: next2 = dp[3] * 2 = 4 * 2 = 8
i3 = 2: next3 = dp[2] * 3 = 3 * 3 = 9

6]Smallest is 8:
Add to dp: dp = [1, 2, 3, 4, 5, 6, 8]
Move i2 = 4: next2 = dp[4] * 2 = 5 * 2 = 10

7]Smallest is 9:
Add to dp: dp = [1, 2, 3, 4, 5, 6, 8, 9]
Move i3 = 3: next3 = dp[3] * 3 = 4 * 3 = 12


**** Final Result
dp = [1, 2, 3, 4, 5, 6, 8, 9]
The 8th ugly number is 9.
 */
