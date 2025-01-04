class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stk = new Stack<>();
        ArrayList<Integer> list = new ArrayList<>();
        for(int i : asteroids)
        {
            if(i > 0)
            {
                stk.add(i);
            }
            else
            {
                while(!stk.isEmpty() && stk.peek()>0 && stk.peek()<-i)
                {
                    stk.pop();
                }
                if(stk.isEmpty() || stk.peek()<0)
                {
                    stk.push(i);
                }
                if(stk.peek() == -i)
                {
                    stk.pop();
                }
            }
        }

        while(!stk.isEmpty())
        {
            list.add(stk.pop());
        }
        Collections.reverse(list);
        int[] arr = list.stream().mapToInt(i -> i).toArray();
        return (arr);
    }
}