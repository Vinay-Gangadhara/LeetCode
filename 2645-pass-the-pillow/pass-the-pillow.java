class Solution {
    public int passThePillow(int n, int time) {
        // Finding No. of Hops
        int hops = time/(n-1);
        // Calculate No. of Hops 
        int left = time%(n-1);
        // Based on odd/even we calculate direction and find the person.
        if(hops%2 == 0)
        {
            return (left+1);
        }
        else
        {
            return (n-left);
        }
      
    }
}