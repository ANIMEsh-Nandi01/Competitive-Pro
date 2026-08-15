class Solution {
    public int elevatorRequests(int n, int[] requests) {
        
        int totalTime = 0;
        int currentFloor = 0; 
        
        for (int request : requests) {
            totalTime += Math.abs(currentFloor - request);           
            currentFloor = request; 
        }
        
        return totalTime; 
    }
}