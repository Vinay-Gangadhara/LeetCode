class Solution {
    public int leastInterval(char[] tasks, int n) {
        
        HashMap <Character, Integer> hm = new HashMap<>();
        
        for(char i : tasks)
        {
            if(hm.containsKey(i))
            {
                hm.put(i,(hm.get(i)+1));
            }
            else
            {
                hm.put(i,1);
            }
        }
        List<Integer> lst = new ArrayList<>(hm.values());
        Collections.sort(lst , Collections.reverseOrder());
        
        int max_freq = lst.get(0)-1;
        int spaces = max_freq * n;
        for(int i=1; i<lst.size();i++)
        {
            spaces = spaces - Math.min(max_freq,lst.get(i));
        }
        
        return (tasks.length + Math.max(0,spaces));
    }
}