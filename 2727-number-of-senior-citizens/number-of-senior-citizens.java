class Solution {
    public int countSeniors(String[] details) {
        int count=0;
        for(String s : details)
        {
            String age = s.substring(11, 13);
            int P_age = Integer.valueOf(age);
            if(P_age > 60)
            {
                count++;
            }
        }
        return count;
        
    }
}