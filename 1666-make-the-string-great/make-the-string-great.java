class Solution {
    public String makeGood(String s) {
        // 97 - 122 small letters;
        Stack<Character> stk = new Stack<>();
        for(char c : s.toCharArray())
        {
            if (!stk.isEmpty() && Math.abs(stk.peek() - c) == 32) {
                stk.pop(); // Remove the bad pair
            } else {
                stk.push(c); // Otherwise, push the current character onto the stack
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