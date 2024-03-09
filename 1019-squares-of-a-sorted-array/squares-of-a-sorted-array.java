class Solution {
    public int[] sortedSquares(int[] nums) {
        int start=0;
        int end = nums.length-1;
        int arr[] = new int[nums.length];
        int point = nums.length-1;
        while(start<=end)
        {
            if(Math.abs(nums[start]) > Math.abs(nums[end]))
               {
                   arr[point] = nums[start]*nums[start];
                   start++;
               }
               else
               {
                   arr[point] = nums[end]*nums[end];
                   end--;
               }
               point--;
        }
      return arr;         
        
    }
}