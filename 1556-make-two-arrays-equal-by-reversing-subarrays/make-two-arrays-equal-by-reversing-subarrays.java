class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        int result[] = new int[1001];
        if(target.length != arr.length)
        {
            return false;
        }
        for(int i : arr)
        {
            result[i] += 1;
        }
        for(int j : target)
        {
            result[j] += -1;
        }
        for(int k=0; k< result.length; k++)
        {
            if(result[k] != 0)
            {
                return false;
            }
        }
        return true;
    }
}