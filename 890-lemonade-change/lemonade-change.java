class Solution {
    public boolean lemonadeChange(int[] bills) {
        boolean flag = true;
        int total_5 = 0;
        int total_10 = 0;
        int total_20 = 0;
        for(int i=0;i<bills.length;i++)
        {
            if(bills[i] == 5)
            {
                total_5++;
            }
            else if(bills[i] == 10)
            {
                total_10++;
                if(total_5>0)
                {
                    total_5--;
                }
                else
                {
                    flag = false;
                    break;
                }
            }
            else if(bills[i] == 20)
            {
                total_20++;
                if(total_10>0 && total_5>0)
                {
                    total_10--;
                    total_5--;
                }
                else if(total_10 == 0 && total_5>2)
                {
                    total_5 -= 3;
                }
                else
                {
                    flag = false;
                    break;
                }
            }
        }
        return flag;
    }
}