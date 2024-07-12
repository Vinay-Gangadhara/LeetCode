class Solution {
    public int result = 0;
    //Use greedy approch
    //Which every value is grater first eleminate those strings
    public int maximumGain(String s, int x, int y) {
        String sb = new String();
        if(x > y)
        {
            // sb = calculate(s,'a','b', x);
            //  calculate(sb, 'b', 'a', y);

             sb = OnCalculate(s,'a','b', x);
             OnCalculate(sb, 'b', 'a', y);

        }
        else
        {
            // sb = calculate(s,'b','a', y);
            // sb = calculate(sb, 'a', 'b', x);

            sb = OnCalculate(s,'b','a', y);
            sb = OnCalculate(sb, 'a', 'b', x);
        }
        return result;
    }
    //Start building a stack and load elements
    //if top and string[i] == required string delete and add points
    // return reversed stacked string
    public String calculate (String s , char first, char second, int points)
    {
        Stack<Character> stk = new Stack<>();
        int length = s.length();
        int i=0;
        while(i<length)
        {
                if(stk.empty() || stk.peek() !=(first) || s.charAt(i)!=(second))
                {
                    stk.push(s.charAt(i));
                    i++;
                }
                else
                {
                    stk.pop();
                    i++;
                    result+=points;
                }
        }
        StringBuilder sb = new StringBuilder();
        while(!stk.empty())
        {
            sb.append(stk.pop());
        }
        return sb.reverse().toString();
    }


    public String OnCalculate(String s , char first, char second, int points)
    {
    int n = s.length(); 
        StringBuilder sb = new StringBuilder();
        
        for (int read = 0; read < n; read++) {
            sb.append(s.charAt(read));
            int write = sb.length();
            if (write > 1 && sb.charAt(write - 1) == second && sb.charAt(write - 2) == first) {
                sb.delete(write - 2, write); // Remove the last two characters
                result += points;
            }
    
    }
    return sb.toString();
    }
} 