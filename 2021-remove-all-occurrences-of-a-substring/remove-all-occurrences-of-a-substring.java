class Solution {

    public Boolean check(Stack<Character> stk, char pt[])
    {
        Stack<Character> stkk = new Stack<>();
        stkk.addAll(stk);

        int count = 0;
        for(int i=pt.length-1; i>=0; i--)
        {
            if(stkk.peek() != pt[i])
            {
                return false;
            }
            else
            {
                count++;
                stkk.pop();
            }
        }

        if(count == pt.length)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    public String removeOccurrences(String s, String part) {

        char str[] = s.toCharArray();
        char pt[] =  part.toCharArray();
        Stack<Character> stk = new Stack<Character>();

        for(int i=0; i<str.length; i++)
        {
            stk.push(str[i]);
            if(stk.size() >= pt.length && check(stk, pt) == true)
            {
                for(int j=0; j<pt.length; j++)
                {
                    stk.pop();
                }
            }
        }

        StringBuffer sb = new StringBuffer();
        while(!stk.isEmpty())
        {
            sb.append(stk.pop());
        }
        return (sb.reverse().toString());
        
    }
}