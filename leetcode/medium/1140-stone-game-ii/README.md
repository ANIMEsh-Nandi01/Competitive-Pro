# Stone Game II

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Alice and Bob continue their games with piles of stones. There are a number of piles  **arranged in a row**, and each pile has a positive integer number of stones `piles[i]`. The objective of the game is to end with the most stones.

Alice and Bob take turns, with Alice starting first.

On each player's turn, that player can take  **all the stones**  in the  **first**  `X` remaining piles, where `1 <= X <= 2M`. Then, we set `M = max(M, X)`. Initially, M = 1.

The game continues until all the stones have been taken.

Assuming Alice and Bob play optimally, return the maximum number of stones Alice can get.

 

 **Example 1:** 

 **Input:**  piles = [2,7,9,4,4]

 **Output:**  10

 **Explanation:** 

- If Alice takes one pile at the beginning, Bob takes two piles, then Alice takes 2 piles again. Alice can get 2 + 4 + 4 = 10 stones in total.
- If Alice takes two piles at the beginning, then Bob can take all three piles left. In this case, Alice get 2 + 7 = 9 stones in total.

So we return 10 since it's larger.

 **Example 2:** 

 **Input:**  piles = [1,2,3,4,5,100]

 **Output:**  104

 

 **Constraints:** 

- 1 <= piles.length <= 100
- 1 <= piles[i] <= 104

## Solution

**Language:** Java  
**Runtime:** 2 ms (beats 100.00%)  
**Memory:** 43.8 MB (beats 98.71%)  
**Submitted:** 2026-08-09T17:05:40.647Z  

```java
class Solution {
    public int stoneGameII(int[] piles) {
        int n = piles.length;
        // Memoization table: memo[i][m]
        int[][] memo = new int[n][n + 1];
        
        // Suffix sum array to get total remaining stones quickly
        int[] suffixSum = new int[n];
        suffixSum[n - 1] = piles[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffixSum[i] = suffixSum[i + 1] + piles[i];
        }
        
        return dfs(piles, 0, 1, suffixSum, memo);
    }
    
    private int dfs(int[] piles, int i, int m, int[] suffixSum, int[][] memo) {
        // Base case: no more piles left
        if (i == piles.length) {
            return 0; 
        }
        
        // If we can take all remaining piles, take them all
        if (i + 2 * m >= piles.length) {
            return suffixSum[i]; 
        }
        
        // Return precalculated result if it exists
        if (memo[i][m] != 0) {
            return memo[i][m];
        }
        
        int minNextPlayerScore = Integer.MAX_VALUE;
        
        // Try all possible moves from 1 to 2M
        for (int x = 1; x <= 2 * m; x++) {
            // Find the MINIMUM score the next player can get
            minNextPlayerScore = Math.min(minNextPlayerScore, dfs(piles, i + x, Math.max(m, x), suffixSum, memo));
        }
        
        // Current player's best score = Total remaining stones - Next player's best score
        memo[i][m] = suffixSum[i] - minNextPlayerScore;
        
        return memo[i][m];
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/stone-game-ii/)