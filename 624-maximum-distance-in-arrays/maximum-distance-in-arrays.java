class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        
        int min = arrays.get(0).get(0);
        int max = arrays.get(0).get(arrays.get(0).size() - 1);
        int result = 0;
        for(int i=1;i<arrays.size();i++)
        {
            int currmin = arrays.get(i).get(0);
            int currmax = arrays.get(i).get(arrays.get(i).size()-1);
            result = Math.max(result,Math.abs(max - currmin));
            result = Math.max(result,Math.abs(min - currmax));
            min = Math.min(min,currmin);
            max = Math.max(max,currmax);
        }
        return result;
    }
}