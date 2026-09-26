# Q1. Minimum Queen Moves to Reach Target

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

There is an `8 x 8` empty chessboard with  **1-indexed**  rows and columns.

You are given an array `source = [sr, sc]` representing the starting position of a  **queen**, and an array `target = [tr, tc]` representing the target position.

In one move, the queen travels one or more squares along a single  **row**,  **column**, or  **diagonal**, staying within the board.

Return the  **minimum**  number of moves for the queen to land  **exactly**  on `target`.

 

 **Example 1:** 

 **Input:**  source = [8,1], target = [1,8]

 **Output:**  1

 **Explanation:** 

**​​​​​​​
​​​​​​​**

A single diagonal move takes the queen straight from `(8, 1)` to `(1, 8)`.

 **Example 2:** 

 **Input:**  source = [4,2], target = [1,3]

 **Output:**  2

 **Explanation:** 

​​​​​​​

The queen moves from `(4, 2)` to `(4, 3)`, then from `(4, 3)` to `(1, 3)`, reaching the target in 2 moves.

 **Example 3:** 

 **Input:**  source = [1,1], target = [1,1]

 **Output:**  0

 **Explanation:** 

The queen is already at the target position, so no moves are needed.

 

 **Constraints:** ​​​​​​​

- source == [sr, sc]
- target == [tr, tc]
- 1 <= sr, sc, tr, tc <= 8

## Solution

**Language:** Java  
**Runtime:** 1 ms (beats 100.00%)  
**Memory:** 43.9 MB (beats 50.00%)  
**Submitted:** 2026-09-26T14:59:09.500Z  

```java
class Solution {
    public int minQueenMoves(int[] source, int[] target) {
        
        int sourceRow = source[0];
        int sourceCol = source[1];
        int targetRow = target[0];
        int targetCol = target[1];
        
        if (sourceRow == targetRow && sourceCol == targetCol) {
            return 0;
        }
        
        int rowDiff = Math.abs(sourceRow - targetRow);
        int colDiff = Math.abs(sourceCol - targetCol);
  
        if (sourceRow == targetRow || sourceCol == targetCol || rowDiff == colDiff) {
            return 1;
        }
       
        return 2;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/minimum-queen-moves-to-reach-target/)