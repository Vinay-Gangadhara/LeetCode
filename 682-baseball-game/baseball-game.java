class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> stk = new Stack<>();

        for(String operation : operations)
        {
            if(operation.equals("+"))
            {
                int first = stk.pop();
                int second = stk.peek();
                int sum = first+second;
                stk.push(first);
                stk.push(sum);
            }
            else if(operation.equals("D"))
            {
                int top_element = stk.peek();
                int new_number = top_element*2;
                stk.push(new_number);
            }
            else if(operation.equals("C"))
            {
                stk.pop();
            }
            else
            {
                stk.push(Integer.parseInt(operation));
            }
        }
        int result = 0;
        while(!stk.isEmpty())
        {
            result+= stk.pop();
        }
        return result;
    }
}