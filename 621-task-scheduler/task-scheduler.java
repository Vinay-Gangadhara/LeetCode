class Solution {
    public int leastInterval(char[] tasks, int n) {
        
        HashMap <Character, Integer> hm = new HashMap<>();
        // iterate to the array find the char counts
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
        // sort the array
        //take the max element * n to minimise the ideal task count
        //keep adding the rest of the elements such that they  fit in between the spaces or after the max element * cycles
        //now we have idea spaces available add the total number of element in the array to get the iterations/intervals
        int max_freq = lst.get(0)-1;
        int spaces = max_freq * n;
        for(int i=1; i<lst.size();i++)
        {
            spaces = spaces - Math.min(max_freq,lst.get(i));
        }
        
        return (tasks.length + Math.max(0,spaces));
    }
}