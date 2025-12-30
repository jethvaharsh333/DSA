# **TIPS**

### 1

→ Just start with backward recursion. Then do memoization from that backward recursion. Now optimize it with forward dp.

→ This strategy works always as mostly we will use same base case. 

→ Principle:
    - As we know in **backward recursion, we always reduce the problem** (n → n-1, n-2).
    - In **forward DP, we build solutions step by step** (0 → n).
    - Both are the same recurrence, just different directions.

---

# **1) Climbing Stairs**

- Climbing a staircase. It takes `n` steps to reach the top. Each time you can either climb `1` or `2` steps. In how many distinct ways can you climb to the top?
- So it’s confirm we have to reach the last step [i.e. just cannot jump from the last second ladder].
- Code:

```java

```