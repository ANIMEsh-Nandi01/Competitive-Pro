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