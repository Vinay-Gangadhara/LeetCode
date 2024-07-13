class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {

        int n = healths.length;
        List<int[]> robots = new ArrayList<>();
        int[] finalHealths = new int[n];
        for(int i=0; i<n; i++)
        {
            robots.add(new int[] {positions[i], healths[i],i});
        }

        Collections.sort(robots, (a,b) -> a[0] - b[0]);

        Stack<int[]> stkL = new Stack<>();
        Stack<int[]> stkR = new Stack<>();

        for(int[] robo : robots)
        {
            if(directions.charAt(robo[2]) == 'R')
            {
                stkR.push(robo);
            }
            else
            {
                while(!stkR.empty())
                {
                    if(stkR.peek()[1] > robo[1])
                    {
                        stkR.peek()[1]--;
                        robo[1] =0;
                        break;
                    }
                    else if(stkR.peek()[1] < robo[1])
                    {
                        stkR.peek()[1] = 0;
                        robo[1]--;
                        stkR.pop();
                    }
                    else
                    {
                        stkR.peek()[1] = 0;
                        robo[1] =0;
                        stkR.pop();
                        break;
                    }
                }
                if(robo[1] >0)
                {
                    stkL.push(robo);
                }
            }
            
        }

        while (!stkR.isEmpty()) 
        {
            int[] robot = stkR.pop();
            finalHealths[robot[2]] = robot[1];
        }

        while (!stkL.isEmpty()) 
        {
            int[] robot = stkL.pop();
            finalHealths[robot[2]] = robot[1];
        }

        List<Integer> healthList = new ArrayList<>();
        for (int health : finalHealths) {
            if (health > 0) {
                healthList.add(health);
            }
        }
        
        return healthList;
        
    }
}