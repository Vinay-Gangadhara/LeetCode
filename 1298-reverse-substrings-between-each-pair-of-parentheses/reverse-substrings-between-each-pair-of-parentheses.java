class Solution {
    public String reverseParentheses(String s) {
    //     Stack<Character> stk = new Stack<>();
    //     StringBuilder sb = new StringBuilder();
    //     String st = new String();
    //     for(int i=0; i<s.length(); i++)
    //     {
    //         char c = s.charAt(i);
    //         if(c == '(')
    //         {
    //             stk.push(c);
    //         }
    //         else
    //         {
    //             if(c == ')')
    //             {
    //                 while(stk.peek() != '(')
    //                 {
    //                     st = st + stk.pop();
    //                 }
    //                 stk.pop();
    //                 for(int j=0; j<st.length(); j++)
    //                 {
    //                     stk.push(st.charAt(j));
    //                 }
    //                 st = "";
    //             }
    //             else
    //             {
    //                 stk.push(c);
    //             }
    //         }
    //     }

    //     while(!stk.empty())
    //     {
    //         sb = sb.append(stk.pop()); 
    //     }

    //     return sb.reverse().toString();
    // }

// Wormhole Teleportation Method
// Keep a track of  ( & ) in an array
// once we get ( || )
// change the direction and move to its opposite bracket
// else keep appending to the result
int size = s.length();
int var[] = new int[size];
Stack<Integer> stk = new Stack<>();
for(int i=0; i<size; i++)
{
    if(s.charAt(i) == '(')
    {
        stk.push(i);
    }
    else if(s.charAt(i) == ')')
    {
        var[i] = stk.peek();
        var[stk.peek()] = i;
        stk.pop();
    }
}
int dir =1;
StringBuilder sb = new StringBuilder();
for(int i=0; i<size; i=i+dir)
{
    if(s.charAt(i) == '(' || s.charAt(i) == ')')
    {
        i = var[i];
        dir *= -1;
    }
    else
    {
        sb.append(s.charAt(i));
    }
}
return sb.toString();
}
}



















 