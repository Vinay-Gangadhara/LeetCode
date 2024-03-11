class Solution {
    public String customSortString(String order, String s) {
        //Creating variable Container
        HashMap<Character,Integer> hm = new HashMap<Character,Integer>();
        StringBuffer ans = new StringBuffer();
        //Adding count fo Characters in String to hashMap
        for(char i : s.toCharArray())
        {
            if(hm.containsKey(i))
            {
                hm.put(i,hm.get(i)+1);
            }
            else
            {
                hm.put(i,1);
            }
            
        }
        System.out.println(hm);
        //Checking the order and appending it to the ans
        for(char i:order.toCharArray())
        {
            if(hm.containsKey(i))
            {
                int count = hm.get(i);
                for(int j=0; j<count; j++)
                {
                    ans.append(i);
                }
                hm.put(i,0);
            }
        }
        System.out.println(hm);
        //Adding remaining values to answer
        for(Map.Entry <Character,Integer> i : hm.entrySet())
        {
            if(i.getValue() != 0)
            {
                for(int j=0; j<i.getValue(); j++)
                {
                    ans.append(i.getKey());
                }
            }
        }
        return ans.toString();
        
    }
}