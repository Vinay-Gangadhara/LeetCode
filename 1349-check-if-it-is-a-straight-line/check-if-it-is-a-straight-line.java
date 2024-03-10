class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        int m = coordinates.length;
    
       
        int diffx = coordinates[1][0] - coordinates[0][0];
        int diffy = coordinates[1][1] - coordinates[0][1];
        
        
        for(int i = 2; i < m; i++) {
            int diff1 = coordinates[i][0] - coordinates[i-1][0];
            int diff2 = coordinates[i][1] - coordinates[i-1][1];
            
           
            if (diffx * diff2 != diffy * diff1) {
                return false;
            }
        }
        
        return true;
    }
}