class Solution {
    public int tupleSameProduct(int[] nums) {

        HashMap<Integer,Integer> hs = new HashMap<>();
        int prod = 0;
        int result = 0;
        for(int i=0;i<nums.length;i++)
        {
            for(int j=i+1; j<nums.length; j++)
            {
                prod = nums[i]*nums[j];
                if(hs.containsKey(prod))
                {
                    hs.put(prod,(hs.get(prod)+1));
                }
                else
                {
                    hs.put(prod,1);
                }
            }
        }

        for(Map.Entry<Integer, Integer> entry:hs.entrySet())
        {
            int n = entry.getValue();

            if(n>1)
            {
                result += 8*(n*(n-1)/2);
            }
        }
           
           return result;
        
    }
}

/*

Approach

1. Use a hash map to store the product of each pair of numbers.
2. The key is the product, and the value is the count of pairs   that produce this product.

Iterate Over Pairs:
3. Iterate through all possible pairs (\U0001d456,\U0001d457) in the array and calculate their product.
4. Update the hash map with the product.

Count Tuples:
5. For each unique product in the map, count the number of valid tuples.
6. If a product has been seen \U0001d45b times, the number of ways to choose 2 pairs from \U0001d45b pairs is given by \U0001d45b\U0001d4362=\U0001d45b(\U0001d45b−1)2.
7. Each combination can form 8 tuples (\U0001d44e,\U0001d44f,\U0001d450,\U0001d451) by arranging the pairs.

*/