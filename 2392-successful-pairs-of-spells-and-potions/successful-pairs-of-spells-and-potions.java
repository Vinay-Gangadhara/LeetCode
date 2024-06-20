class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int n = spells.length;
        int m = potions.length;
        Arrays.sort(potions);
        int pairs[] = new int[n];
        // Taking each elements from spells
        for(int i=0;i<n;i++)
        {
            int spell = spells[i];
            int low = 0;
            int high = m-1;
            // Applying BS on potions array 
            while(low<=high)
            {
                int mid = low + (high-low)/2;
                // If poduct > success then descrease
                long product = (long) spell*potions[mid];
                if(product >= success)
                {
                    high = mid-1;
                }
                // Else increment my Low value
                else
                {
                    low = mid+1;
                }

            }
            // Finding No.of Products > success
            pairs[i] = m-low;
        }
        return pairs;
        
    }
}