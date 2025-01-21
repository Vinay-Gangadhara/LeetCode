class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int j=0;

        Stack<Integer> stk = new Stack<>();

        for(int i : pushed)
        {
            stk.push(i);
            while(!stk.isEmpty() && stk.peek() == popped[j])
            {
                stk.pop();
                j++;
            }
        }

    return stk.isEmpty();
        
    }
}
