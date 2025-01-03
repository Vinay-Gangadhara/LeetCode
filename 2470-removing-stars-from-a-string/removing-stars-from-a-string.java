class Solution {
    public String removeStars(String s) {
        Stack<Character> stk = new Stack<>();

        for(char c : s.toCharArray())
        {
            if(c == '*' && !stk.isEmpty())
            {
                stk.pop();
            }
            else
            {
                stk.push(c);
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!stk.isEmpty())
        {
            sb.append(stk.pop());
        }
        return String.valueOf(sb.reverse());
    }
}