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