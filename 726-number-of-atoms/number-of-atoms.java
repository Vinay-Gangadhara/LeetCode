class Solution {
    public String countOfAtoms(String formula) {   
        int n = formula.length();
        Stack<Integer> stk = new Stack<>();
        int[] values = new int[n];
        int mul =1;
        for(int i = n-1; i>=0; i--)
        {
            char ch = formula.charAt(i);
            if(ch == ')')
            {
                StringBuilder sb = new StringBuilder();
                for(int j = i+1; j<n;j++)
                {
                    char dig = formula.charAt(j);
                    if(Character.isDigit(dig))
                    {
                        sb.append(dig);
                    }
                    else
                    {
                        break;
                    }
                }
                if(sb.length() == 0) sb = sb.append(1);
                int digit = Integer.parseInt(sb.toString());
                mul = mul*digit;
                stk.push(digit);
            }
            else if(ch == '(')
            {
                mul = mul/stk.pop();
            }
            values[i] = mul;
        }

        Map<String,Integer> map = new TreeMap<>();

        for(int i=0; i<n; i++)
        {
            StringBuilder sb = new StringBuilder();
            StringBuilder sb1 = new StringBuilder();
            int j=0;
            int k=0;
            if(Character.isUpperCase(formula.charAt(i)))
            {
                int multiplier = values[i];
                sb.append(formula.charAt(i));
                for(j=i+1;j<n;j++)
                {
                    if(!Character.isLowerCase(formula.charAt(j))){
                        break;
                    }
                    sb.append(formula.charAt(j));
                }
                for(k = j; k<n;k++)
                {
                    if(!Character.isDigit(formula.charAt(k)))
                    {
                        break;
                    } 
                    sb1.append(formula.charAt(k));
                }

                if(sb1.length() == 0) sb1 = sb1.append(1);
                if(map.containsKey(sb.toString()))
                {
                    int val = map.get(sb.toString());
                    val = val + ((Integer.parseInt(sb1.toString())) * multiplier);
                    map.put((sb.toString()), val);
                }
                else
                {
                    map.put(sb.toString(),((Integer.parseInt(sb1.toString())) * multiplier));
                }
                i = k-1;
            }

            else if(formula.charAt(i) == '(')
            {
                continue;
            }

            else if(formula.charAt(i) == ')')
            {
                continue;
            }
        }

    StringBuilder result = new StringBuilder();
    for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            result.append(key);
            if(value != 1)
            {
                result.append(value);
            }
        }
    return result.toString();
    }
}