class Solution {
    public String losingPlayer(int x, int y) {
        int cnt = 0;

        while(x>0 && y>3)
        {
            x= x-1;
            y=y-4;
            cnt++;
        }
        if(cnt%2==0)
        {
            return "Bob";
        }
        else
        {
            return "Alice";
        }
    }
}

//75,75,75,75,10,10,10,10,10,10,10,10,10,10