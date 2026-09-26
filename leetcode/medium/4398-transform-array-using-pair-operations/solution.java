class Solution {
    public boolean canTransform(int[] source, int[] target) {
        
        long sumSource = 0;
        long sumTarget = 0;
        
        for (int i = 0; i < source.length; i++) {
            sumSource += source[i];
            
            sumTarget += target[i];
        }
                return sumSource == sumTarget;
    }
}