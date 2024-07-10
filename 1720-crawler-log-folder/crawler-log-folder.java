class Solution {
    public int minOperations(String[] logs) {
        int count = 0;
        for(String a : logs)
        {
             if(a.equals("../"))
            {
                if(count>0)
                {
                    count--;
                }
            }
            else if(!a.equals("./"))
            {
                count++;
            }
            
        }
        return count;
    }
}