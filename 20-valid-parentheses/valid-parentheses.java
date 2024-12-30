class Solution {
    public boolean isValid(String s) {
        Stack<Character> stk = new Stack<>();
        for(int i=0;i<s.length();i++)
        {
            char bracket = s.charAt(i);
            if (bracket == '(' || bracket == '{' || bracket == '[')
            {
                stk.push(bracket);
            }
            else if (bracket == ')')
            {
                if(!stk.isEmpty() && stk.peek() == '(')
                {
                    stk.pop();
                }
                else
                {
                    stk.push(bracket);
                }
            }
            else if (bracket == '}' )
            {
                if(!stk.isEmpty() && stk.peek() == '{' )
                {
                    stk.pop();
                }
                else
                {
                    stk.push(bracket);
                }
            }
            else if (bracket == ']')
            {
                if(!stk.isEmpty() && stk.peek() == '[')
                {
                    stk.pop();
                }
                else
                {
                    stk.push(bracket);
                }
            }
        }

        if(!stk.isEmpty())
        {
            return false;
        }
        else
        {
            return true;
        }
    }
}