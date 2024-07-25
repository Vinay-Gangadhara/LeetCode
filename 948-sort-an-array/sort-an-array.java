class Solution {
    public int[] sortArray(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int minValue = Integer.MAX_VALUE;
        int maxValue = Integer.MIN_VALUE;
        for(int i : nums)
        {   
            if(i<minValue)
            {
                minValue = i;
            }
            if(i>maxValue)
            {
                maxValue = i;
            }
            if(!map.containsKey(i))
            {
                map.put(i,1);
            }
            else
            {
                map.put(i,map.get(i)+1);
            }
        }

        int place = 0;
        for(int i=minValue;i<=maxValue;i++)
        {
            if(map.containsKey(i))
            {
                int number = map.get(i);
            while(number>0)
            {
                nums[place] = i;
                number--;
                place++;
            }
            }  
        }
        return nums;
    }
}

/**

-------> Counting Sort
1. Find the min and max value in the range.
2. Keep a map which contains record of Number of time the perticular number has been appeared.
3. run a loop from min to max and find if that number is present keep ading in the result array
4. At end will give u sorted array. */

/**
----------> Time Complexity O(N+K)
----------> Space Complexity O(N) */