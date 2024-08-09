class Solution {
    public int minimumPushes(String word) {
        Integer sortedOrder[] = new Integer[26];
        int result = 0;
        for (int i = 0; i < sortedOrder.length; i++) {
            sortedOrder[i] = 0;
        }
        for(int i=0;i<word.length();i++)
        {
            Integer value = word.charAt(i) - 'a';
            sortedOrder[value] ++;
        }
        
        Arrays.sort(sortedOrder, Collections.reverseOrder());

        for(int i=0;i<sortedOrder.length;i++)
        {
            if(sortedOrder[i] == 0)
            {
                break;
            }
            result += (i/8 + 1)*sortedOrder[i] ;
        }

        return result;
    }



    /**
    
    -------> Main Idea:
    1. Use Greedy Algorithm
    2. Sort the frequenct in descind order
    3. Keep adding the character in 8 buttons. */
}