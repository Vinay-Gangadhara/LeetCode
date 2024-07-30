class Solution {
    public int minimumDeletions(String s) {
        /**
        -----> Main Idea
        1. My result string should have all "a" then "b"
        2. Lets iterate to array when we find "b" lets increment count.
        3. Conce the count>0 and we find "a" we need to delete that "a" hence increment result count and decrement "b" count
        4. return result
         */
        int res = 0;
        int count = 0;
        for(char c : s.toCharArray())
        {
            if(c == 'b')
            {
                count++;
            }
            else if(count != 0)
            {
                res++;
                count--;
            }
        }
    return res;
    }
}