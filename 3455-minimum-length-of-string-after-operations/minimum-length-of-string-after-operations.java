class Solution {
    public int minimumLength(String s) {
        HashMap<Character,Integer> mp = new HashMap<>();
        for(int i=0;i<s.length();i++)
        {
            char ch = s.charAt(i);
            if(mp.containsKey(ch))
            {
                int count = mp.get(ch);
                mp.put(ch,count+1);
            }
            else
            {
                mp.put(ch,1);
            }
        }
        int duplicate = 0;
        for(Map.Entry<Character,Integer> entries : mp.entrySet())
        {
            int num = entries.getValue();
            if(num%2==0 )
            {
                duplicate += num-2;
            }
            else
            {
                duplicate += num-1;
            }
        }
        return s.length()-duplicate;
    }
}