class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int i=0;
        int j=0;

        Stack<Integer> stk = new Stack<>();

        while(i<pushed.length || (!stk.isEmpty() && j<popped.length))
        {
            if(!stk.isEmpty() && stk.peek() == popped[j])
            {
                stk.pop();
                j++;
            }
            else if(i<pushed.length)
            {
                stk.push(pushed[i]);
                i++;
            }
            else
            {
                break;
            }
        }

    return stk.isEmpty();
        
    }
}
