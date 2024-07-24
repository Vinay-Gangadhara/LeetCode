class Solution {
    public List<List<Integer>> maps;
    public int[] sortJumbled(int[] mapping, int[] nums) {
        maps = new ArrayList<>();
        int result[] = new int[nums.length];
        for(int i=0;i<nums.length;i++)
        {
            int num = nums[i];
            int mappedNumber = convertInt(num,mapping);
            maps.add(Arrays.asList(mappedNumber,i));
        }

        Collections.sort(maps, (a,b) -> {
            if(a.get(0).equals(b.get(0)))
            {
                return a.get(1) - b.get(1);
            }
            else
            {
                return a.get(0) - b.get(0);
            }
        });
        int i=0;
        for(List<Integer> lst : maps)
        {
            result[i] = nums[lst.get(1)];
            i++;
        }
        return result;
    }

    public int convertInt(int num, int[] mapping)
    {
        if (num == 0) {
            return mapping[0];
        }
        int mappedNumber=0;
        int placeValue = 1;
        while(num>0)
        {
            int digit = num%10;
            mappedNumber+= mapping[digit]* placeValue;
            num /=10;
            placeValue*=10;
        }
        return mappedNumber;
    }
}